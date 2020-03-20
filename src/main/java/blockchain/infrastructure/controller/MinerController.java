package blockchain.infrastructure.controller;

import blockchain.application.BlockHandler;
import blockchain.application.GenesisHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/miner")
public class MinerController {

    private BlockHandler blockHandler;
    private GenesisHandler genesisHandler;

    public MinerController(BlockHandler blockHandler, GenesisHandler genesisHandler) {
        this.blockHandler = blockHandler;
        this.genesisHandler = genesisHandler;
    }

    @PostMapping
    public Mono<String> undermine() {
        return this.blockHandler.undermine();
    }

    @PostMapping("/genesis/{to}")
    public Mono<String> genesisHandler(@PathVariable("to") String to) {
        return genesisHandler.undermineGenesis(to);
    }
}
