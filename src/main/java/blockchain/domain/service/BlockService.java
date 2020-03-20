package blockchain.domain.service;

import blockchain.ProofOfWork;
import blockchain.domain.Block;
import blockchain.domain.Body;
import blockchain.domain.Header;
import blockchain.domain.Transaction;
import blockchain.domain.builder.BlockBuilder;
import blockchain.domain.repository.BlockRepository;
import blockchain.infrastructure.entity.BlockEntity;
import blockchain.infrastructure.entity.BodyEntity;
import blockchain.infrastructure.entity.HeaderEntity;
import blockchain.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlockService {
    private BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public Mono<Block> save(Block block) {
        this.blockRepository.save(BlockBuilder.build(block)).subscribe();
        return Mono.just(block);
    }

    public Flux<Block> findAll() {
        return this.blockRepository.findAll().map(BlockBuilder::build);
    }

    public String undermine(String content) {
        return ProofOfWork.pow(content, 1);
    }

    public Mono<String> undermine() {
        return this.blockRepository.findAll().last().map(blockEntity -> {
            Block block = BlockBuilder.build(blockEntity);
            if (block.getBody().getTransactions().size() < 3) {
                throw new RuntimeException("Numero de transacciones no disponibles para minar, deber ser 3");
            }
            ProofOfWork.pow(block, difficulty());
            this.save(block);
            Block newBlock = new Block(new Header(block.getHeader().getHashOwn(), ""), new Body(new ArrayList<>()), block);
            this.save(newBlock);
            return block.getHeader().getHashOwn();
        });
    }

    public Integer difficulty() {
        Integer difficulty = new Random().nextInt(5);
        difficulty = difficulty == 0 ? 1 : difficulty;
        return difficulty;
    }
}
