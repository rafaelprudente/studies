package pt.com.basicservice.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReplaceRequest {
    private String name;
    private String lastname;
}
