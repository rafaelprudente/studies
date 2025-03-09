package pt.com.basicservice.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {
    private String name;
    private String lastname;
}
