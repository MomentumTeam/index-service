import Rabbit.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import Models.*;
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main (String[] args){
        LOGGER.info("Manager Service started");
        SpringApplication.run(Consumer.class, args);
    }
}
