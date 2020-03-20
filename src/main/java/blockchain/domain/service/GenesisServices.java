package blockchain.domain.service;

import blockchain.domain.account.Genesis;
import blockchain.domain.repository.GenesisRepository;
import blockchain.infrastructure.entity.GenesisEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GenesisServices {

    private GenesisRepository genesisRepository;

    public GenesisServices(GenesisRepository genesisRepository) {
        this.genesisRepository = genesisRepository;
    }

    public Mono<Genesis> create(Genesis genesis) {
        this.genesisRepository.save(new GenesisEntity(Genesis.ID, genesis.getMaxCoins(), genesis.getPublicKey())).subscribe();
        return Mono.just(genesis);
    }

    public Mono<Genesis> find() {
        return this.genesisRepository.findById(Genesis.ID).map(genesisEntity -> new Genesis(genesisEntity.getMaxCoins()));
    }
}
