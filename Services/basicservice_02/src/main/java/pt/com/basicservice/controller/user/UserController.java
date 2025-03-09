package pt.com.basicservice.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.com.basicservice.common.dto.User;
import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.mapper.UserMapper;
import pt.com.basicservice.service.user.UserService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<Collection<UserResponse>> findAll() {
        Collection<User> users = userService.findAll();
        return ResponseEntity.ok(userMapper.modelListToResponseList(users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable("userId") long userId) throws NotFoundException {
        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        Optional<User> user = userService.findById(userId);

        if (user.isPresent()) {
            response = ResponseEntity.ok(userMapper.modelToResponse(user.get()));
        }

        return response;
    }

    @PostMapping()
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest user) {
        User newUser = userService.save(User.builder().name(user.getName()).lastname(user.getLastname()).build());

        return ResponseEntity.ok(userMapper.modelToResponse(newUser));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> replaceById(@PathVariable("userId") long userId, @RequestBody UserReplaceRequest user) throws NotFoundException {
        Optional<User> replacedUser = userService.replaceById(userId, User.builder().name(user.getName()).lastname(user.getLastname()).build());

        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        if (replacedUser.isPresent()) {
            response = ResponseEntity.ok(userMapper.modelToResponse(replacedUser.get()));
        }

        return response;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> changeById(@PathVariable("userId") long userId, @RequestBody UserUpdateRequest user) throws NotFoundException {
        Optional<User> replacedUser = userService.changeById(userId, User.builder().name(user.getName()).lastname(user.getLastname()).build());

        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        if (replacedUser.isPresent()) {
            response = ResponseEntity.ok(userMapper.modelToResponse(replacedUser.get()));
        }

        return response;
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") long userId) {
        userService.deleteById(userId);
    }
}
