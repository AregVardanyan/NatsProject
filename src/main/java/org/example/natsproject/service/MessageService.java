package org.example.natsproject.service;
import org.example.natsproject.entity.MessageEntity;
import org.example.natsproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void processMessage(String content) {
        MessageEntity message = new MessageEntity();
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }
}