package blockchain.infrastructure.entity;

import lombok.Data;

import java.util.List;

@Data
public class BodyEntity {
    private final List<TransactionEntity> transactions;
}
