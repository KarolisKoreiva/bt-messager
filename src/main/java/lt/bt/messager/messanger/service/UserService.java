package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers() {

        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        return userEntities.stream().map(User::new).collect(Collectors.toList());
    }

    public void createUser(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(userEntity);

    }

    public Long getCurrentUserId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = userRepository.findByUsername(username);

        return userEntity.getUserId();
    }
}
