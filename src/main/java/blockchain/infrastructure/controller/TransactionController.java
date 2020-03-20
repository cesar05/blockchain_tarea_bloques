package blockchain.infrastructure.controller;

import blockchain.application.TransactionHandler;
import blockchain.domain.Transaction;
import blockchain.infrastructure.dto.TransferDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionHandler transactionHandler;

    public TransactionController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @PostMapping
    public void transfer(@RequestBody TransferDTO transferDTO) {
        this.transactionHandler.save(transferDTO);
    }

    @GetMapping
    public Flux<Transaction> getAll() {
        return this.transactionHandler.getAll();
    }
}
