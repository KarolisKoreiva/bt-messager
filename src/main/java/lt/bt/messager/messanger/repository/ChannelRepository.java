package lt.bt.messager.messanger.repository;

import lt.bt.messager.messanger.entity.ChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CrudRepository<ChannelEntity, Long> {
}
