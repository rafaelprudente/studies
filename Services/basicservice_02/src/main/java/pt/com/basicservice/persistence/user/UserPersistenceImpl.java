package pt.com.basicservice.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pt.com.basicservice.common.dto.User;
import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.mapper.UserMapper;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistence {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Collection<User> findAll() {
        return userMapper.entityListToModelList(userRepository.findAll());
    }

    @Override
    public Optional<User> findById(long userId) throws NotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }

        Optional<User> response = Optional.empty();
        Optional<UserEntity> databaseResponse = userRepository.findById(userId);
        if (databaseResponse.isPresent()) {
            response = Optional.of(userMapper.entityToModel(databaseResponse.get()));
        }

        return response;
    }

    @Override
    public User save(User user) {
        return userMapper.entityToModel(userRepository.save(userMapper.modelToEntity(user)));
    }

    @Override
    public Optional<User> replaceById(long userId, User replaceData) throws NotFoundException {
        Optional<User> response = Optional.empty();

        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }

        Optional<UserEntity> databaseUser = userRepository.findById(userId);
        if (databaseUser.isPresent()) {
            userMapper.replace(replaceData, databaseUser.get());

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
            userMapper.replace(changeData, databaseUser.get());

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
