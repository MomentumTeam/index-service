package Rabbit;

import Config.Config;
import Models.DeleteRequest;
import Models.DriveEventMessage;
import Models.RabbitErrorMassage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Producer {
    private AmqpTemplate rabbitTemplate;

    public Producer() throws Exception {
        try {
            ConnectionFactory connectionFactory = new CachingConnectionFactory(Config.RABBIT_URL);

            Binding eventBinding = new Binding(Config.EVENTS_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.EVENTS_ROUTING_KEY, null);

            Binding errorBinding = new Binding(Config.ERROR_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.ERROR_ROUTING_KEY, null);

            AmqpAdmin admin = new RabbitAdmin(connectionFactory);


            admin.declareExchange(new TopicExchange(Config.EXCHANGE_NAME));
            admin.declareQueue(new Queue(Config.EVENTS_QUEUE_NAME));
            admin.declareQueue(new Queue(Config.ERROR_QUEUE_NAME));

            admin.declareBinding(eventBinding);
            admin.declareBinding(errorBinding);

            RabbitTemplate template = new RabbitTemplate(new CachingConnectionFactory(Config.RABBIT_URL));
            template.setMessageConverter(producerMessageConverter());
            this.rabbitTemplate = template;
        }
        catch(Exception exception){
            throw exception;
        }
    }


    public Jackson2JsonMessageConverter producerMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }


    public void sendDelete(DeleteRequest message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.DELETE_ROUTING_KEY,
                    message);
        }
        catch(AmqpException exception){
            throw exception;
        }
    }

    public void sendError(RabbitErrorMassage message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.ERROR_ROUTING_KEY,
                    message);
        }
        catch(AmqpException exception){
            throw exception;
        }

    }

    public void sendEventRequest(DriveEventMessage message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.EVENTS_ROUTING_KEY,message);
        }
        catch (AmqpException exception){
            throw exception;
        }
    }
}