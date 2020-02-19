package blockchain.modelo;

public class Transaction {
    private String origin;
    private String destination;
    private Double valor;

    public Transaction(String origin, String destination, Double valor) {
        this.origin = origin;
        this.destination = destination;
        this.valor = valor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", valor=" + valor +
                '}';
    }
}
