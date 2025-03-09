package pt.com.basicservice.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.dto.User;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistence {
    private final UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll().stream().map(ue -> new User(ue.getId(), ue.getName(), ue.getLastname()))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<User> findById(long userId) throws NotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }

        return userRepository.findById(userId).map(ue -> new User(ue.getId(), ue.getName(), ue.getLastname()));
    }

    @Override
    public User save(User user) {
        UserEntity ndbUser = userRepository.save(UserEntity.builder().name(user.getName()).lastname(user.getLastname()).build());

        return new User(ndbUser.getId(), ndbUser.getName(), ndbUser.getLastname());
    }

    @Override
    public Optional<User> replaceById(long userId, User replaceData) throws NotFoundException {
        Optional<User> response = Optional.empty();

        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }

        Optional<UserEntity> databaseUser = userRepository.findById(userId);
        if (databaseUser.isPresent()) {
            databaseUser.get().setName(replaceData.getName());
            databaseUser.get().setLastname(replaceData.getLastname());

            UserEntity updatedUser = userRepository.save(databaseUser.get());

            response = Optional.of(User.builder().id(updatedUser.getId()).name(updatedUser.getName()).lastname(updatedUser.getLastname()).build());
        }

        return response;
    }

    @Override
    public Optional<User> changeById(long userId, User changeData) throws NotFoundException {
        Optional<User> response = Optional.empty();

        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }

        Optional<UserEntity> databaseUser = userRepository.findById(userId);
        if (databaseUser.isPresent()) {
            if (StringUtils.hasText(changeData.getName())) {
                databaseUser.get().setName(changeData.getName());
            }
            if (StringUtils.hasText(changeData.getLastname())) {
                databaseUser.get().setLastname(changeData.getLastname());
            }

            UserEntity updatedUser = userRepository.save(databaseUser.get());

            response = Optional.of(User.builder().id(updatedUser.getId()).name(updatedUser.getName()).lastname(updatedUser.getLastname()).build());
        }

        return response;
    }

    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }
}
