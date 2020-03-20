package blockchain.infrastructure.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String publicKey;
    private String password;
}
