package blockchain.modelo;

import java.util.List;

public class Body {
    private List<Transaction> transactions;

    public Body(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Body{" +
                "transactions=" + transactions +
                '}';
    }
}
