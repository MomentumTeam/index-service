import Config.Config;
import Rabbit.Consumer;
import Rabbit.Producer;
import Services.BeeperControl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@SpringBootApplication
@EnableScheduling

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main (String[] args){
        LOGGER.info("error-service started");
        initHealthCheck();
        Producer.initQueues();
        SpringApplication.run(Consumer.class,args);
//        System.exit(SpringApplication
//                .exit(SpringApplication.run(Consumer.class, args)));
//        RabbitListenerEndpointRegistry registry = new RabbitListenerEndpointRegistry();
//        registry.stop();
//        BeeperControl.beepForAnHour();
    }

    public static void initHealthCheck() {
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost",
                    Config.HC_PORT), 0);
            server.createContext("/healthcheck", new HttpHandler() {
                public void handle(HttpExchange t) throws IOException {
                    String response = "ErrorService - UP";
                    t.sendResponseHeaders(200, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            });
            server.setExecutor(null);
            server.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
