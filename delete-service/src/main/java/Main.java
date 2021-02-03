import Rabbit.Consumer;
import Rabbit.Producer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main (String[] args){
        LOGGER.info("delete-service started");
        Producer.initQueues();
        SpringApplication.run(Consumer.class, args);
    }
}
