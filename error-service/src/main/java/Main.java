import Rabbit.Consumer;
import Services.BeeperControl;
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
//        System.out.println("enter");



//        SpringApplication.run(Consumer.class,args);
//        System.exit(SpringApplication
//                .exit(SpringApplication.run(Consumer.class, args)));
        BeeperControl.beepForAnHour();
    }



}
