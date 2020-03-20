package blockchain.domain.account;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private String id;
    private String publicKey;

    public User(String publicKey) {
        this.id = publicKey;
        this.publicKey = DigestUtils.sha256Hex(publicKey);
    }

    public String getId() {
        return id;
    }

    public String getPublicKey() {
        return publicKey;
    }
}
