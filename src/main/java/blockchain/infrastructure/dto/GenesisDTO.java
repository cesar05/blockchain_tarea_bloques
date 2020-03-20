package blockchain.infrastructure.dto;

import lombok.Data;

@Data
public class GenesisDTO {
    private final Double maxCoins;
    private final String publicKey;
}
