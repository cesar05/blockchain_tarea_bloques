package blockchain.domain.repository;

import blockchain.infrastructure.entity.GenesisEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenesisRepository extends ReactiveMongoRepository<GenesisEntity, String> {
}
