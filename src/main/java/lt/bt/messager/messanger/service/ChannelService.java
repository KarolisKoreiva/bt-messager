package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.Channel;
import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository channelRepository;

    public ChannelEntity createChannel(Channel channel) {

        ChannelEntity entity = new ChannelEntity(channel);

        return channelRepository.save(entity);
    }

    public List<Channel> fetchAllChannels() {

        List<ChannelEntity> channels = (List<ChannelEntity>) channelRepository.findAll();

        return channels.stream().map(Channel::new).collect(Collectors.toList());
    }

    public ChannelEntity getChannelById(Long id) {

        return channelRepository.findById(id).get();
    }
}
