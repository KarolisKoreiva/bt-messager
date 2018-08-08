package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.entity.MessageEntity;

import javax.persistence.ManyToOne;

public class Message {

    private String message;

    private Long recipientId;

    private Long senderId;

    private ChannelEntity channelId;

    public Message() {}

    public Message (MessageEntity entity) {
        setMessage(entity.getMessage());
        setRecipientId(entity.getRecipientId());
        setSenderId(entity.getSenderId());
        setChannelId(entity.getChannelId());
    }

    public ChannelEntity getChannelId() {
        return channelId;
    }

    public void setChannelId(ChannelEntity channelId) {
        this.channelId = channelId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipient) {
        this.recipientId = recipient;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long sender) {
        this.senderId = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
