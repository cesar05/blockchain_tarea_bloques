package blockchain.infrastructure.controller;

import blockchain.application.UserHandler;
import blockchain.domain.account.User;
import blockchain.infrastructure.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserHandler userHandler;

    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @PostMapping
    public Mono<String> crear(@RequestBody UserDTO userDTO) {
        return this.userHandler.create(userDTO.getPassword());
    }

    @GetMapping
    public Flux<User> getAll() {
        return this.userHandler.getAll();
    }
}
