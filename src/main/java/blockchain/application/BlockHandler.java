package blockchain.application;

import blockchain.domain.Block;
import blockchain.domain.service.BlockService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BlockHandler {

    private BlockService blockService;

    public BlockHandler(BlockService blockService) {
        this.blockService = blockService;
    }

    public Mono<Block> save(Block block) {
        return this.blockService.save(block);
    }

    public Flux<Block> findAll() {
        return this.blockService.findAll();
    }

    public String undermine(String content) {
        return this.blockService.undermine(content);
    }

    public Mono<String> undermine() {
        return this.blockService.undermine();
    }
}
