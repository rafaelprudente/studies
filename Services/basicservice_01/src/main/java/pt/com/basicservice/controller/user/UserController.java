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
import pt.com.basicservice.common.exception.NotFoundException;
import pt.com.basicservice.common.dto.User;
import pt.com.basicservice.service.user.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Collection<UserResponse>> findAll() {
        Collection<User> users = userService.findAll();
        return ResponseEntity.ok(users.stream().map(ud -> new UserResponse(ud.getId(), ud.getName(), ud.getLastname())).collect(Collectors.toSet()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable("userId") long userId) throws NotFoundException {
        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        Optional<User> user = userService.findById(userId);

        if (user.isPresent()) {
            response = ResponseEntity.ok(new UserResponse(user.get().getId(), user.get().getName(), user.get().getLastname()));
        }

        return response;
    }

    @PostMapping()
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest user) {
        User newUser = userService.save(User.builder().name(user.getName()).lastname(user.getLastname()).build());

        return ResponseEntity.ok(new UserResponse(newUser.getId(), newUser.getName(), newUser.getLastname()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> replaceById(@PathVariable("userId") long userId, @RequestBody UserReplaceRequest user) throws NotFoundException {
        Optional<User> replacedUser = userService.replaceById(userId, User.builder().name(user.getName()).lastname(user.getLastname()).build());

        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        if (replacedUser.isPresent()) {
            response = ResponseEntity.ok(UserResponse.builder().id(replacedUser.get().getId()).name(replacedUser.get().getName()).lastname(replacedUser.get().getLastname()).build());
        }

        return response;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> changeById(@PathVariable("userId") long userId, @RequestBody UserUpdateRequest user) throws NotFoundException {
        Optional<User> replacedUser = userService.changeById(userId, User.builder().name(user.getName()).lastname(user.getLastname()).build());

        ResponseEntity<UserResponse> response = ResponseEntity.notFound().build();
        if (replacedUser.isPresent()) {
            response = ResponseEntity.ok(UserResponse.builder().id(replacedUser.get().getId()).name(replacedUser.get().getName()).lastname(replacedUser.get().getLastname()).build());
        }

        return response;
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") long userId) {
        userService.deleteById(userId);
    }
}
