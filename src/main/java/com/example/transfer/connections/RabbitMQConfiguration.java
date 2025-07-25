package com.example.transfer.connections;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfiguration {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.virtualhost}")
    private String virtualhost;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    private static final String QUEUE_NAME = "DOC";

    public void publish(String message) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(this.host);
        factory.setVirtualHost(this.virtualhost);
        factory.setPort(this.port);
        factory.setUsername(this.username);
        factory.setPassword(this.password);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        }

    }
}
