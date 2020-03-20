package blockchain.domain.repository;

import blockchain.infrastructure.entity.BlockEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends ReactiveMongoRepository<BlockEntity, String> {
}
