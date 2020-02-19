package blockchain.modelo;

public class Block {
    private Header header;
    private Body body;
    private Block blockPrev;

    public Block(Header header, Body body, Block blockPrev) {
        this.header = header;
        this.body = body;
        this.blockPrev = blockPrev;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Block getBlockPrev() {
        return blockPrev;
    }

    public void setBlockPrev(Block blockPrev) {
        this.blockPrev = blockPrev;
    }

    @Override
    public String toString() {
        return "Block{" +
                "header=" + (header.toString() == null ? "" : header.toString()) +
                ", body=" + (body.toString() == null ? "" : body.toString()) +
                ", blockPrev=" + (blockPrev == null ? "" : blockPrev.toString()) +
                '}';
    }
}
