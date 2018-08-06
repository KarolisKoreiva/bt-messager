package lt.bt.messager.messanger.entity;

import lt.bt.messager.messanger.dto.Message;

import javax.persistence.*;

@Entity
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Long recipientId;

    private Long senderId;

    public MessageEntity() {}

    public MessageEntity(Message message) {
        setSenderId(message.getSenderId());
        setRecipientId(message.getRecipientId());
        setMessage(message.getMessage());
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long sender) {
        this.senderId = sender;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipient) {
        this.recipientId = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
