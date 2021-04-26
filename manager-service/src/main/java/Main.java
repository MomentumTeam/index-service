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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main (String[] args){
        LOGGER.info("manager-service started");
        initHealthCheck();
        Producer.initQueues();
        SpringApplication.run(Consumer.class, args);
    }

    public static void initHealthCheck() {
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost",
                    Config.HC_PORT), 0);
            server.createContext("/healthcheck", new HttpHandler() {
                public void handle(HttpExchange t) throws IOException {
                    String response = "ManagerService - UP";
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
