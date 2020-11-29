package Rabbit;

import Config.Config;
import Models.DeleteRequest;
import Models.DriveRequest;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class Producer {
    private AmqpTemplate deleteTemplate;
    private AmqpTemplate driveTemplate;

    public Producer() {
        ConnectionFactory deleteConnectionFactory = new CachingConnectionFactory();
        AmqpAdmin deleteAdmin = new RabbitAdmin(deleteConnectionFactory);
        deleteAdmin.declareQueue(new Queue(Config.DELETE_QUEUE_NAME));

        ConnectionFactory driveConnectionFactory = new CachingConnectionFactory();
        AmqpAdmin driveAdmin = new RabbitAdmin(driveConnectionFactory);
        driveAdmin.declareQueue(new Queue(Config.DRIVE_SERVICE_QUEUE_NAME));

        this.deleteTemplate = new RabbitTemplate(deleteConnectionFactory);
        this.driveTemplate = new RabbitTemplate(driveConnectionFactory);
    }

    public void sendDelete(DeleteRequest message) throws AmqpException {
        this.deleteTemplate.convertAndSend(Config.EXCHANGE_NAME, Config.DELETE_ROUTING_KEY, message);
    }

    public void sendDriveRequest(DriveRequest message) throws AmqpException {
        this.deleteTemplate.convertAndSend(Config.EXCHANGE_NAME, Config.DELETE_ROUTING_KEY, message);
    }
}