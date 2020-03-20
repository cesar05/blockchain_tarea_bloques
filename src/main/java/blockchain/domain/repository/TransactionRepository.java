package blockchain.domain.repository;

import blockchain.infrastructure.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<TransactionEntity, String> {
}
