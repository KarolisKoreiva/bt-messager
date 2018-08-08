package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.ChannelEntity;

public class Channel {

    Long id;

    String name;

    public Channel(){}

    public Channel(ChannelEntity entity){
        setName(entity.getName());
        setId(entity.getId());
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
