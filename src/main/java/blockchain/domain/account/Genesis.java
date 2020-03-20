package blockchain.domain.account;

import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

@Getter
public class Genesis {
    public static final String ID = "1";
    private final Double maxCoins;
    private final String publicKey;

    public Genesis(Double maxCoins) {
        this.maxCoins = maxCoins;
        this.publicKey = DigestUtils.sha256Hex(ID + maxCoins);
    }
}
