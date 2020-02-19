package blockchain;

import blockchain.modelo.Block;
import blockchain.modelo.Body;
import blockchain.modelo.Header;
import blockchain.modelo.Transaction;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public Integer nonce;


    public Main(Integer nonce) {
        this.nonce = nonce;
    }

    public static void main(String[] args) {
        Integer difficulty = new Random().nextInt(5);
        difficulty = difficulty == 0 ? 1 : difficulty;
        String hashDefault = "0";

        Block block1 = new Block(new Header(hashDefault, hashDefault), new Body(Arrays.asList(new Transaction("A", "B", 10D))), null);
        String hashBlock1 = ProofOfWork.pow(block1, difficulty);

        Block block2 = new Block(new Header(hashBlock1, hashDefault), new Body(Arrays.asList(new Transaction("B", "A", 5D))), block1);
        String hashBlock2 = ProofOfWork.pow(block2, difficulty);

        Block block3 = new Block(new Header(hashBlock2, hashDefault), new Body(Arrays.asList(new Transaction("C", "A", 15D))), block2);
        String hashBlock3 = ProofOfWork.pow(block3, difficulty);

        Block lastBlock = block3;
        while (lastBlock.getBlockPrev() != null) {
            System.out.println("Hash: " + lastBlock.getHeader().getHashPrev());
            lastBlock = lastBlock.getBlockPrev();
        }
        System.out.println("Hash: " + lastBlock.getHeader().getHashPrev());
    }

}
