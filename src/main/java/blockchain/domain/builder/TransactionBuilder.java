package blockchain.domain.builder;

import blockchain.domain.Transaction;
import blockchain.infrastructure.entity.TransactionEntity;

public class TransactionBuilder {
    public static Transaction build(TransactionEntity transactionEntity) {
        return new Transaction(transactionEntity.getFrom(), transactionEntity.getTo(), transactionEntity.getQuantity());
    }

    public static TransactionEntity build(Transaction transaction) {
        return new TransactionEntity(transaction.getFrom(), transaction.getQuantity(), transaction.getTo());
    }

}
