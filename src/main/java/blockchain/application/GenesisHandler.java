package blockchain.application;

import blockchain.ProofOfWork;
import blockchain.domain.Block;
import blockchain.domain.Body;
import blockchain.domain.Header;
import blockchain.domain.Transaction;
import blockchain.domain.account.Genesis;
import blockchain.domain.service.GenesisServices;
import blockchain.infrastructure.dto.GenesisDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Random;

@Component
public class GenesisHandler {

    private GenesisServices genesisServices;
    private BlockHandler blockHandler;

    public GenesisHandler(GenesisServices genesisServices, BlockHandler blockHandler) {
        this.genesisServices = genesisServices;
        this.blockHandler = blockHandler;
    }

    public Mono<Genesis> create(GenesisDTO genesisDTO) {
        return this.genesisServices.create(new Genesis(genesisDTO.getMaxCoins()));
    }

    public Mono<Genesis> find() {
        return this.genesisServices.find();
    }

    public Mono<String> undermineGenesis(String to) {
        return this.find().map(genesis -> {
            Transaction transaction = new Transaction(genesis.getPublicKey(), to, 25d);
            Block blockGenesis = new Block(new Header("", ""), new Body(Arrays.asList(transaction)), null);
            ProofOfWork.pow(blockGenesis, difficulty());
            this.blockHandler.save(blockGenesis);
            return blockGenesis.getHeader().getHashOwn();
        });
    }

    public Integer difficulty() {
        Integer difficulty = new Random().nextInt(5);
        difficulty = difficulty == 0 ? 1 : difficulty;
        return difficulty;
    }
}
