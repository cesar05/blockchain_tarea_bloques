package blockchain.infrastructure.entity;

import lombok.Data;

@Data
public class TransactionEntity {
    private String id;
    private final String from;
    private final Double quantity;
    private final String to;
}
