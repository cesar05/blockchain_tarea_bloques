package blockchain.domain.builder;

import blockchain.domain.Block;
import blockchain.domain.Body;
import blockchain.domain.Header;
import blockchain.domain.Transaction;
import blockchain.infrastructure.entity.BlockEntity;
import blockchain.infrastructure.entity.BodyEntity;
import blockchain.infrastructure.entity.HeaderEntity;
import blockchain.infrastructure.entity.TransactionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BlockBuilder {
    public static Block build(BlockEntity blockEntity) {
        if (blockEntity == null) return null;
        Header header = new Header(
                blockEntity.getHeader().getHashPrev()
                , blockEntity.getHeader().getHashRoot()
                , blockEntity.getHeader().getHashOwn());

        List<Transaction> transactions = blockEntity.getBody().getTransactions()
                .stream()
                .map(transEntity -> new Transaction(transEntity.getFrom(), transEntity.getTo(), transEntity.getQuantity()))
                .collect(Collectors.toList());

        Body body = new Body(transactions);
        return new Block(blockEntity.getId(), header, body, null);
    }

    public static BlockEntity build(Block block) {
        if (block == null) return null;

        HeaderEntity headerEntity = new HeaderEntity(
                block.getHeader().getHashPrev()
                , block.getHeader().getHashRoot()
                , block.getHeader().getHashOwn()
                , block.getHeader().getNonce());

        List<TransactionEntity> transactionEntities = block.getBody().getTransactions()
                .stream()
                .map(trans -> new TransactionEntity(trans.getFrom(), trans.getQuantity(), trans.getTo()))
                .collect(Collectors.toList());

        BodyEntity bodyEntity = new BodyEntity(transactionEntities);
        return new BlockEntity(block.getId(),headerEntity,bodyEntity);
    }
}
