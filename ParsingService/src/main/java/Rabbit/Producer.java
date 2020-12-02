
package Rabbit;

import Config.Config;
import Models.Document;
import RabbitModels.ErrorMessage;
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

            Binding parsingBinding = new Binding(Config.PARSING_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.PARSING_SERVICE_ROUTING_KEY, null);

            Binding elasticBinding = new Binding(Config.ELASTIC_SERVICE_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.ELASTIC_SERVICE_ROUTING_KEY, null);

            Binding errorBinding = new Binding(Config.ERROR_QUEUE_NAME, Binding.DestinationType.QUEUE,
                    Config.EXCHANGE_NAME, Config.ERROR_ROUTING_KEY, null);

            AmqpAdmin admin = new RabbitAdmin(connectionFactory);


            admin.declareExchange(new TopicExchange(Config.EXCHANGE_NAME));
            admin.declareQueue(new Queue(Config.PARSING_SERVICE_QUEUE_NAME));
            admin.declareQueue(new Queue(Config.ELASTIC_SERVICE_QUEUE_NAME));
            admin.declareQueue(new Queue(Config.ERROR_QUEUE_NAME));

            admin.declareBinding(parsingBinding);
            admin.declareBinding(elasticBinding);
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


    public void sendToElasticQueue(Document message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.ELASTIC_SERVICE_ROUTING_KEY,message);
        }
        catch (AmqpException exception){
            throw exception;
        }
    }

    public void sendError(ErrorMessage message) throws AmqpException {
        try{
            this.rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME,Config.ERROR_ROUTING_KEY,
                    message);
        }
        catch(AmqpException exception){
            throw exception;
        }

    }
}
