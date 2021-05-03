package Rabbit;

import Config.Config;
import Enums.ErrorOperation;
import RabbitModels.ErrorMessage;
import Services.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Seconds;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class Consumer {
    private static final Logger LOGGER = LogManager.getLogger(Consumer.class);
    private static boolean flag = false;
    private static LocalTime now = null;
    @RabbitListener(queues = "error")
    public void receiveMessage(final ErrorMessage message) {
        try{
            now = LocalTime.now();
            if(now.isBefore(Config.startTime) || now.isAfter(Config.endTime)){
                flag = false;
                LOGGER.info(String.format("error-service stopped"));
                long seconds = now.isBefore(Config.startTime)?
                        now.until(Config.startTime, ChronoUnit.SECONDS):
                        24*60*60 - Config.endTime.until(now, ChronoUnit.SECONDS) -
                                Config.startTime.until(Config.endTime, ChronoUnit.SECONDS);
                LOGGER.info(String.format("I need to wait %d seconds = %f minutes = %f hours",
                        seconds, seconds/60.0, seconds/3600.0));
                TimeUnit.SECONDS.sleep(seconds);
            }
            if(!flag){
                LOGGER.info(String.format("error-service started"));
                flag = true;
            }
            LOGGER.info(String.format("Received message from queue='%s': %s", Config.ERROR_QUEUE_NAME,message.toString()));
            Manager.processError(message);
        }
        catch (Exception error){
            LOGGER.error(error.getMessage());
        }
    }

    @Bean
    public TopicExchange tipsExchange() {
        return new TopicExchange(Config.EXCHANGE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(Config.ERROR_QUEUE_NAME);
    }

    public String defaultRoutingKey(){
        return Config.ERROR_ROUTING_KEY;
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
        connectionFactory.setUri(Config.RABBIT_URL);
        connectionFactory.setCloseTimeout(0);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
