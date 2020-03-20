package blockchain.domain;

import lombok.Data;

import java.util.List;

@Data
public class Body {
    private List<Transaction> transactions;

    public Body(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}
