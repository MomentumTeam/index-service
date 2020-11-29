package Rabbit;

import Config.Config;
import Enums.DriveField;
import Models.DeleteRequest;
import Models.DriveEventMessage;
import Models.DriveRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Consumer {
    public static Producer producer = new Producer();
    @RabbitListener(queues = Config.EVENTS_QUEUE_NAME)
    public void receiveMessage(final DriveEventMessage message) {
        try{
            System.out.println(message);
            DeleteRequest deleteRequest = new DeleteRequest("123456",true);
            DriveRequest driveRequestMessage = new DriveRequest("123456",
                    new DriveField[]{DriveField.DOWNLOAD, DriveField.METADATA});

            producer.sendDelete(deleteRequest);
            producer.sendDriveRequest(driveRequestMessage);
        }
        catch (Exception e){

        }
    }

    @Bean
    public TopicExchange tipsExchange() {
        return new TopicExchange(Config.EVENTS_QUEUE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(Config.EVENTS_QUEUE_NAME);
    }

    @Bean
    public Binding queueToExchangeBinding() {
        return BindingBuilder.bind(defaultParsingQueue()).to(tipsExchange()).with(Config.EVENTS_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
