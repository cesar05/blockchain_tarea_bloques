package blockchain.infrastructure.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "genesis")
@Data
public class GenesisEntity {
    @MongoId
    private final String id;
    private final Double maxCoins;
    private final String publicKey;
}
