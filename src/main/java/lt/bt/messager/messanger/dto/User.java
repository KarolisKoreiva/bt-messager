package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.UserEntity;

public class User {

    private String name;

    public User() {
    }

    public User(UserEntity entity) {
        setName(entity.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
