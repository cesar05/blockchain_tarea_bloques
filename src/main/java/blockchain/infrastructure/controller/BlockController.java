package blockchain.infrastructure.controller;

import blockchain.application.BlockHandler;
import blockchain.domain.Block;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    private BlockHandler blockHandler;

    public BlockController(BlockHandler blockHandler) {
        this.blockHandler = blockHandler;
    }

    @GetMapping
    public Flux<Block> findAll() {
        return this.blockHandler.findAll();
    }
}
