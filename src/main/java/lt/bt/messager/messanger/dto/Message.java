package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.MessageEntity;

import javax.persistence.ManyToOne;

public class Message {

    private String message;

    private Long recipientId;

    private Long senderId;

    public Message() {}

    public Message (MessageEntity entity) {
        setMessage(entity.getMessage());
        setRecipientId(entity.getRecipientId());
        setSenderId(entity.getSenderId());
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
