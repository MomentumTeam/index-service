
package Rabbit;

import Config.Config;
import Models.Document;
import RabbitModels.ErrorMessage;
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

@SpringBootApplication
public class Producer {
    private static final Logger LOGGER = LogManager.getLogger(Producer.class);
    private AmqpTemplate rabbitTemplate;

    public Producer() throws Exception {
        try {
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
            connectionFactory.setUri(Config.RABBIT_URL);
            RabbitTemplate template = new RabbitTemplate(connectionFactory);
            template.setMessageConverter(producerMessageConverter());
            template.setChannelTransacted(true);
            this.rabbitTemplate = template;
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public static void initQueues(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(Config.RABBIT_URL);

        Binding driveBinding = new Binding(Config.DRIVE_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                Config.EXCHANGE_NAME, Config.DRIVE_SERVICE_ROUTING_KEY, null);

        Binding parsingBinding = new Binding(Config.PARSING_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                Config.EXCHANGE_NAME, Config.PARSING_SERVICE_ROUTING_KEY, null);

        Binding elasticBinding = new Binding(Config.ELASTIC_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                Config.EXCHANGE_NAME, Config.ELASTIC_SERVICE_ROUTING_KEY, null);

        Binding errorBinding = new Binding(Config.ERROR_QUEUE_NAME, Binding.DestinationType.QUEUE,
                Config.EXCHANGE_NAME, Config.ERROR_ROUTING_KEY, null);

        AmqpAdmin admin = new RabbitAdmin(connectionFactory);


        admin.declareExchange(new TopicExchange(Config.EXCHANGE_NAME));
        LOGGER.info(String.format("Declared exchange '%s'",Config.EXCHANGE_NAME));
        admin.declareQueue(new Queue(Config.DRIVE_SERVICE_QUEUE_NAME));
        LOGGER.info(String.format("Declared queue '%s'",Config.DRIVE_SERVICE_QUEUE_NAME));
        admin.declareQueue(new Queue(Config.PARSING_SERVICE_QUEUE_NAME));
        LOGGER.info(String.format("Declared queue '%s'",Config.PARSING_SERVICE_QUEUE_NAME));
        admin.declareQueue(new Queue(Config.ELASTIC_SERVICE_QUEUE_NAME));
        LOGGER.info(String.format("Declared queue '%s'",Config.ELASTIC_SERVICE_QUEUE_NAME));
        admin.declareQueue(new Queue(Config.ERROR_QUEUE_NAME));
        LOGGER.info(String.format("Declared queue '%s'",Config.ERROR_QUEUE_NAME));

        admin.declareBinding(driveBinding);
        LOGGER.info(String.format("Declared Binding of '%s' to %s",Config.DRIVE_SERVICE_QUEUE_NAME,Config.EXCHANGE_NAME));
        admin.declareBinding(parsingBinding);
        LOGGER.info(String.format("Declared Binding of '%s' to %s",Config.PARSING_SERVICE_QUEUE_NAME,Config.EXCHANGE_NAME));
        admin.declareBinding(elasticBinding);
        LOGGER.info(String.format("Declared Binding of '%s' to %s",Config.ELASTIC_SERVICE_QUEUE_NAME,Config.EXCHANGE_NAME));
        admin.declareBinding(errorBinding);
        LOGGER.info(String.format("Declared Binding of '%s' to %s",Config.ERROR_QUEUE_NAME,Config.EXCHANGE_NAME));
        connectionFactory.resetConnection();

    }

    public Jackson2JsonMessageConverter producerMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }


    public void sendToParsingQueue(Document message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.PARSING_SERVICE_ROUTING_KEY,
                    message);
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.PARSING_SERVICE_QUEUE_NAME));
        }
        catch(AmqpException exception){
            throw exception;
        }
    }

    public void sendToElasticQueue(Document message) throws AmqpException {
        try{
//            message.setAncestors();
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.ELASTIC_SERVICE_ROUTING_KEY,message);
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.ELASTIC_SERVICE_QUEUE_NAME));
        }
        catch (AmqpException exception){
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


}
