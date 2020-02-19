package blockchain;

import blockchain.modelo.Block;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class ProofOfWork {

    public static String pow(Block block, Integer difficulty) {
        Random rand = new Random();
        Long nonce = null;
        String ceros = "0".repeat(difficulty);
        String sha256hex = "";
        while (true) {
            nonce = rand.nextLong();
            block.getHeader().setNonce(nonce);
            sha256hex = DigestUtils.sha256Hex(block.toString());
            if (sha256hex.substring(0, difficulty).equals(ceros)) {
                break;
            }
        }
        return sha256hex;
    }
}
