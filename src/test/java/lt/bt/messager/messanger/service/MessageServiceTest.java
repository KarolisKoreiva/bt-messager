package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.MessageRepository;
import lt.bt.messager.messanger.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class MessageServiceTest {

    @Mock
    MessageRepository messageRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    UserService userService;

    @InjectMocks
    MessageService messageService;

    @Test
    public void shouldCreateMessage(){

    }

    @Test
    public void shouldReturnCurrentUserMessages() {

        List<MessageEntity> messages = new ArrayList<>();
        MessageEntity msg1 = new MessageEntity();
        msg1.setSenderId(new Long (1));
        messages.add(msg1);
        MessageEntity msg2 = new MessageEntity();
        msg2.setSenderId(new Long (1));
        messages.add(msg2);

        when(userService.getCurrentUserId()).thenReturn(new Long(1));

        when(messageRepository.findAllBySenderId(new Long(1))).thenReturn(messages);

        List<Message> messagesDTO = new ArrayList<>();
        messagesDTO = messages.stream().map(Message::new).collect(Collectors.toList());

        List<Message> currentUserMessages = messageService.fetchCurrentUserMessages();

        for (Message msg : messagesDTO) {
            for (Message msgCurrent : currentUserMessages) {
                assertEquals(msg.getSenderId(), msgCurrent.getSenderId());
            }
        }
    }

}
