package Rabbit;

import Config.Config;
import Enums.ErrorOperation;
import Exceptions.DeleteException;
import Models.DriveEventMessage;
import Services.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Consumer {
    private static final Logger LOGGER = LogManager.getLogger(Consumer.class.getName());

    @RabbitListener(queues = "events")
    public void receiveMessage(final DriveEventMessage message) {
        try{
            LOGGER.info(String.format("Received message from queue='%s': %s", Config.EVENTS_QUEUE_NAME,message.toString()));
            Manager.processMessage(message);
        }
        catch (Exception exception){
            LOGGER.error(String.format("Error while processing message, exception: %s",exception.getMessage()));
            String fileId = message.getFileId();
            if(fileId != null){
                try{
                    ErrorOperation operation = ErrorOperation.REFRESH;
                    if(exception instanceof DeleteException) {
                        operation = ErrorOperation.DELETE;
                    }
                    Manager.sendError(fileId,operation);
                }
                catch(Exception error){
                    LOGGER.error(String.format("Tried unsuccessfully to push '%s' to the Error queue, " +
                            "exception: %s",fileId,error.getMessage()));
                }
            }
        }
    }

    @Bean
    public TopicExchange tipsExchange() {
        return new TopicExchange(Config.EXCHANGE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(Config.EVENTS_QUEUE_NAME);
    }

    public String defaultRoutingKey(){
        return Config.EVENTS_ROUTING_KEY;
    }

    @Bean
    public Binding queueToExchangeBinding() {
        return BindingBuilder.bind(defaultParsingQueue()).to(tipsExchange()).with(defaultRoutingKey());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(Config.RABBIT_URL);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
