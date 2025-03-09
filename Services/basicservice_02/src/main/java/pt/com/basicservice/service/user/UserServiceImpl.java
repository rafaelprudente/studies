package pt.com.basicservice.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.persistence.user.UserPersistence;
import pt.com.basicservice.common.dto.User;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistence userPersistence;

    @Override
    public Collection<User> findAll() {
        return userPersistence.findAll();
    }

    @Override
    public Optional<User> findById(long userId) throws NotFoundException {
        return userPersistence.findById(userId);
    }

    @Override
    public User save(User user) {
        return userPersistence.save(user);
    }

    @Override
    public Optional<User> replaceById(long userId, User replaceData) throws NotFoundException {
        return userPersistence.replaceById(userId, replaceData);
    }

    @Override
    public Optional<User> changeById(long userId, User changeData) throws NotFoundException {
        return userPersistence.changeById(userId, changeData);
    }

    @Override
    public void deleteById(long userId) {
        userPersistence.deleteById(userId);
    }
}
