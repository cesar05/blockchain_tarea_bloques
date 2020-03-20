package blockchain.infrastructure.controller;

import blockchain.application.GenesisHandler;
import blockchain.domain.account.Genesis;
import blockchain.infrastructure.dto.GenesisDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/genesis")
public class GenesisController {

    private GenesisHandler genesisHandler;

    public GenesisController(GenesisHandler genesisHandler) {
        this.genesisHandler = genesisHandler;
    }

    @PostMapping
    public Mono<Genesis> create(@RequestBody GenesisDTO genesisDTO) {
        return this.genesisHandler.create(genesisDTO);
    }

    @GetMapping
    public Mono<Genesis> find() {
        return this.genesisHandler.find();
    }
}
