package blockchain.infrastructure.dto;

import lombok.Data;

@Data
public class TransferDTO {
    private String from;
    private Double quantity;
    private String to;
}
