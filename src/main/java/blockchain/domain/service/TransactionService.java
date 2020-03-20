package blockchain.domain.service;

import blockchain.application.BlockHandler;
import blockchain.domain.Transaction;
import blockchain.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private BlockHandler blockHandler;

    public TransactionService(TransactionRepository transactionRepository, BlockHandler blockHandler) {
        this.transactionRepository = transactionRepository;
        this.blockHandler = blockHandler;
    }

    public void save(Transaction transaction) {
        this.blockHandler.findAll().last().subscribe(block -> {
            block.getBody().getTransactions().add(transaction);
            this.blockHandler.save(block);
        });
    }

    public Flux<Transaction> getAll() {
        return this.transactionRepository.findAll().map(transactionEntity -> new Transaction(transactionEntity.getFrom(),
                transactionEntity.getTo(), transactionEntity.getQuantity()));
    }
}
