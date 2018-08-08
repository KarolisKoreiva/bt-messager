package lt.bt.messager.messanger.controller;

import lt.bt.messager.messanger.dto.Channel;
import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.service.ChannelService;
import lt.bt.messager.messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    MessageService messageService;

    @Autowired
    ChannelService channelService;

    @RequestMapping
    public List<Channel> getChannels() {

        return channelService.fetchAllChannels();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Channel createChannel(@RequestBody Channel channel) {

        ChannelEntity channelEntity = channelService.createChannel(channel);

        return new Channel(channelEntity);
    }

    @RequestMapping("/{id}")
    public List<Message> getChannelMessages(@PathVariable Long id){

        return messageService.fetchMessagesByChannel(id);
    }
}
