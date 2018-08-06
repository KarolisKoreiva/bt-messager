package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    public MessageEntity createMessage(Message message) {
        MessageEntity entity = new MessageEntity();

        entity.setMessage(message.getMessage());
        entity.setRecipientId(message.getRecipientId());
        entity.setSenderId(userService.getCurrentUserId());

        return messageRepository.save(entity);
    }

    public List<Message> fetchMessages() {
        List<MessageEntity> messages = (List<MessageEntity>) messageRepository.findAll();

        return messages.stream().map(Message::new).collect(Collectors.toList());

    }
}
