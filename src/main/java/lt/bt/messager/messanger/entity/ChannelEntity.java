package lt.bt.messager.messanger.entity;

import lt.bt.messager.messanger.dto.Channel;

import javax.persistence.*;

@Entity
public class ChannelEntity {

    @Id
    Long id;

    String name;

    public ChannelEntity(){}

    public ChannelEntity(String id) {
        this.id = Long.parseLong(id);
    }

    public ChannelEntity(Long id) {
        this.id = id;
    }

    public ChannelEntity(Channel channel){
        setName(channel.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
