package pt.com.basicservice.service.user;

import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.dto.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Collection<User> findAll();

    Optional<User> findById(long userId) throws NotFoundException;

    User save(User user);

    Optional<User> replaceById(long userId, User build) throws NotFoundException;

    Optional<User> changeById(long userId, User build) throws NotFoundException;

    void deleteById(long userId);
}
