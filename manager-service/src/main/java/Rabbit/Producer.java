package Rabbit;

import Config.Config;
import Models.DeleteRequest;
import Models.DriveRequest;
import Models.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Producer {
    private static final Logger LOGGER = LogManager.getLogger(Producer.class);
    private AmqpTemplate rabbitTemplate;

    public Producer() throws Exception {
        try {
            ConnectionFactory connectionFactory = new CachingConnectionFactory(Config.RABBIT_URL);

            Binding deleteBinding = new Binding(Config.DELETE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.DELETE_ROUTING_KEY, null);

            Binding driveBinding = new Binding(Config.DRIVE_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.DRIVE_SERVICE_ROUTING_KEY, null);

            Binding errorBinding = new Binding(Config.ERROR_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.ERROR_ROUTING_KEY, null);

            AmqpAdmin admin = new RabbitAdmin(connectionFactory);


            admin.declareExchange(new TopicExchange(Config.EXCHANGE_NAME));
            LOGGER.info(String.format("Declared exchange '%s'",Config.EXCHANGE_NAME));
            admin.declareQueue(new Queue(Config.DELETE_QUEUE_NAME));
            LOGGER.info(String.format("Declared queue '%s'",Config.DELETE_QUEUE_NAME));
            admin.declareQueue(new Queue(Config.DRIVE_SERVICE_QUEUE_NAME));
            LOGGER.info(String.format("Declared queue '%s'",Config.DRIVE_SERVICE_QUEUE_NAME));
            admin.declareQueue(new Queue(Config.ERROR_QUEUE_NAME));
            LOGGER.info(String.format("Declared queue '%s'",Config.ERROR_QUEUE_NAME));

            admin.declareBinding(deleteBinding);
            admin.declareBinding(driveBinding);
            admin.declareBinding(errorBinding);

            RabbitTemplate template = new RabbitTemplate(new CachingConnectionFactory(Config.RABBIT_URL));
            template.setMessageConverter(producerMessageConverter());
            template.setChannelTransacted(true);
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

    @Transactional
    public void sendDelete(DeleteRequest message) throws AmqpException {
        try{
//            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.DELETE_ROUTING_KEY,
//                    message);
            this.rabbitTemplate.convertAndSend("11212",Config.DELETE_ROUTING_KEY, message);
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.DELETE_QUEUE_NAME));
        }
        catch(AmqpException exception){
            throw exception;
        }
    }

    public void sendError(ErrorMessage message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.ERROR_ROUTING_KEY,
                    message);
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.ERROR_QUEUE_NAME));
        }
        catch(AmqpException exception){
            throw exception;
        }

    }

    public void sendDriveRequest(DriveRequest message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.DRIVE_SERVICE_ROUTING_KEY,message);
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.DRIVE_SERVICE_QUEUE_NAME));
        }
        catch (AmqpException exception){
            throw exception;
        }
    }
}