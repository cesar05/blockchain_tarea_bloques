package blockchain.domain.merkle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private String hash;
    private Node leftNode;
    private Node rightNode;
}
