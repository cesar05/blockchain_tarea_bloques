package blockchain.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Transaction {
    private final String from;
    private final String to;
    private final Double quantity;
}
