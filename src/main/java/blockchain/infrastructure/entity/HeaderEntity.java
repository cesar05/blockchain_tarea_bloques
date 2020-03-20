package blockchain.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderEntity {
    private String hashPrev;
    private String hashRoot;
    private String hashOwn;
    private Long nonce;
}
