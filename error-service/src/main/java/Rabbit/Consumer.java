package Rabbit;

import Config.Config;
import Enums.ErrorOperation;
import RabbitModels.ErrorMessage;
import Services.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Consumer {
    @RabbitListener(queues = Config.ERROR_QUEUE_NAME)
    @Scheduled(cron = "0 0 * * * *")
    public void receiveMessage(final ErrorMessage message) {
        try{
            System.out.println(message);
            Manager.processError(message);
        }
        catch (Exception error){
            error.printStackTrace();
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
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(new CachingConnectionFactory(Config.RABBIT_URL));
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
