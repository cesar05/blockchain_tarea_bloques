package blockchain.application;

import blockchain.domain.account.User;
import blockchain.domain.service.UserService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserHandler {

    private static List<User> listUser = new ArrayList<>();
    private UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<String> create(String password) {
        User user = new User(password);
        return this.userService.save(user);
    }

    public Flux<User> getAll() {
        return this.userService.findAll();
    }

    public Mono<User> findById(String id) {
        return this.userService.findById(id);
    }
}
