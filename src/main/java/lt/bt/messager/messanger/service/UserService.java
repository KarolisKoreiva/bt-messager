package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers() {

        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        return userEntities.stream().map(User::new).collect(Collectors.toList());
    }

    public void createUser(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());

        userRepository.save(userEntity);

    }
}
