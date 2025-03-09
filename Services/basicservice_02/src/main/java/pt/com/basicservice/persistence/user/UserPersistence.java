package pt.com.basicservice.persistence.user;

import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.dto.User;

import java.util.Collection;
import java.util.Optional;

public interface UserPersistence {
    Collection<User> findAll();

    User save(User user);

    Optional<User> findById(long userId) throws NotFoundException;

    Optional<User> replaceById(long userId, User replaceData) throws NotFoundException;

    Optional<User> changeById(long userId, User changeData) throws NotFoundException;

    void deleteById(long userId);
}
