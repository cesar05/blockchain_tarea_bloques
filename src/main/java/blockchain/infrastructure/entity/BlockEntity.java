package blockchain.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockEntity {
    @Id
    private String id;
    private HeaderEntity header;
    private BodyEntity body;
}
