import Config.Config;
import Rabbit.Consumer;
import Rabbit.Producer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main (String[] args) throws InterruptedException {
        LOGGER.info("elastic-service started");
        initHealthCheck();
        boolean flag = false;
        int waitTime = 1000;
        while(!flag){
            try{
                Producer.initQueues();
                flag = true;
            }
            catch(Exception e){
                LOGGER.info("RabbitMQ is down probably");
                Thread.sleep(waitTime);
                waitTime = waitTime * 2;
                if(waitTime >= Config.RABBIT_MAX_WAIT_TIME){
                    waitTime = 5000;
                }
            }
        }
        SpringApplication.run(Consumer.class, args);
    }

    public static void initHealthCheck() {
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost",
                    Config.HC_PORT), 0);
            server.createContext("/healthcheck", new HttpHandler() {
                public void handle(HttpExchange t) throws IOException {
                    String response = "ElasticService - UP";
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
