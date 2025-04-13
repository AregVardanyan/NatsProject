package org.example.natsproject.subscriber;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import lombok.RequiredArgsConstructor;
import org.example.natsproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class NatsSubscriber implements CommandLineRunner {

    private final MessageService messageService;

    @Override
    public void run(String... args) throws Exception {
        Connection natsConnection = Nats.connect(System.getenv("NATS_URL"));

        Dispatcher dispatcher = natsConnection.createDispatcher((msg) -> {
            String data = new String(msg.getData(), StandardCharsets.UTF_8);
            System.out.println("Received message: " + data);
            messageService.processMessage(data);
        });

        dispatcher.subscribe("messages");
        System.out.println("Subscribed to NATS subject: messages");
    }
}
