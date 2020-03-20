package blockchain.application;

import blockchain.domain.Transaction;
import blockchain.domain.service.TransactionService;
import blockchain.infrastructure.dto.TransferDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class TransactionHandler {

    private TransactionService transactionService;

    public TransactionHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void save(TransferDTO transferDTO) {
        Transaction transfer = new Transaction(transferDTO.getFrom(), transferDTO.getTo(), transferDTO.getQuantity());
        this.transactionService.save(transfer);
    }

    public Flux<Transaction> getAll() {
        return this.transactionService.getAll();
    }
}
