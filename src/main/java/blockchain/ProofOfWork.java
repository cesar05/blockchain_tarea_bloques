package blockchain;

import blockchain.domain.Block;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class ProofOfWork {

    public static void pow(Block block, Integer difficulty) {
        if (block == null) {
            throw new RuntimeException("Bloque no puede ser null");
        }
        Random rand = new Random();
        Long nonce = null;
        String ceros = "0".repeat(difficulty);
        String sha256hex = "";
        while (true) {
            nonce = rand.nextLong();
            block.getHeader().setNonce(nonce);
            sha256hex = DigestUtils.sha256Hex(block.toString());
            if (sha256hex.substring(0, difficulty).equals(ceros)) {
                block.getHeader().setHashOwn(sha256hex);
                break;
            }
        }
    }

    public static String pow(String content, Integer difficulty) {
//        Random rand = new Random();
//        Long nonce = null;
//        String ceros = "0".repeat(difficulty);
        String sha256hex = "";
//        while (true) {
//            nonce = rand.nextLong();
        sha256hex = DigestUtils.sha256Hex(content);
//            if (sha256hex.substring(0, difficulty).equals(ceros)) {
//                break;
//            }
//        }
        return sha256hex;
    }
}
