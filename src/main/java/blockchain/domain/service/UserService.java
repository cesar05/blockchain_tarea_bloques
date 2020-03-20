package blockchain.domain.service;

import blockchain.domain.account.User;
import blockchain.domain.repository.UserRepository;
import blockchain.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findAll() {
        Flux<UserEntity> userPojoFlux = this.userRepository.findAll();
        return userPojoFlux.map(userEntity -> new User(userEntity.getId()));
    }

    public Mono<String> save(User user) {
        UserEntity userEntity = new UserEntity(user.getId(), user.getPublicKey());
        this.userRepository.save(userEntity).subscribe();
        return Mono.just(user.getPublicKey());
    }

    public Mono<User> findById(String id) {
        return this.userRepository.findById(id).map(userEntity -> new User(userEntity.getId()));
    }
}
