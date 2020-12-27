import Rabbit.Consumer;
import Services.BeeperControl;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling

public class Main {


    public static void main (String[] args){
        SpringApplication.run(Consumer.class,args);
//        System.exit(SpringApplication
//                .exit(SpringApplication.run(Consumer.class, args)));
//        RabbitListenerEndpointRegistry registry = new RabbitListenerEndpointRegistry();
//        registry.stop();
//        BeeperControl.beepForAnHour();
    }
}
