package lt.bt.messager.messanger.repository;

import lt.bt.messager.messanger.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {


    UserEntity findByUsername(String username);
}
