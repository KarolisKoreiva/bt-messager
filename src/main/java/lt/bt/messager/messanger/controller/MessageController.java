package lt.bt.messager.messanger.controller;

import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @RequestMapping()
    public List<Message> getMessages() {

        return messageService.fetchMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message message) {

        MessageEntity messageEntity = messageService.createMessage(message);

        return new Message(messageEntity);
    }

    @RequestMapping("/myMessages")
    public List<Message> getCurrentUserMessages() {

        return messageService.fetchCurrentUserMessages();
    }

}
