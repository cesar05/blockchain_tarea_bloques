package blockchain.modelo;

public class Header {
    private String hashPrev;
    private String hashRoot;
    private Long nonce;

    public Header(String hashPrev, String hashRoot) {
        this.hashPrev = hashPrev;
        this.hashRoot = hashRoot;
    }

    public String getHashPrev() {
        return hashPrev;
    }

    public void setHashPrev(String hashPrev) {
        this.hashPrev = hashPrev;
    }

    public String getHashRoot() {
        return hashRoot;
    }

    public void setHashRoot(String hashRoot) {
        this.hashRoot = hashRoot;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "Header{" +
                "hashPrev='" + hashPrev + '\'' +
                ", hashRoot='" + hashRoot + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
