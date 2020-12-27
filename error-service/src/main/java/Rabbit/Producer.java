
package Rabbit;

import Config.Config;
import RabbitModels.DeleteRequest;
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
            ConnectionFactory connectionFactory = new CachingConnectionFactory(Config.RABBIT_URL);

            Binding deleteBinding = new Binding(Config.DELETE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.DELETE_ROUTING_KEY, null);

            AmqpAdmin admin = new RabbitAdmin(connectionFactory);


            admin.declareExchange(new TopicExchange(Config.EXCHANGE_NAME));
            admin.declareQueue(new Queue(Config.DELETE_QUEUE_NAME));

            admin.declareBinding(deleteBinding);


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
            LOGGER.info(String.format("Message %s sent to %s queue successfully",
                    message.toString(),Config.DELETE_QUEUE_NAME));
        }
        catch(AmqpException exception){
            throw exception;
        }
    }
}
