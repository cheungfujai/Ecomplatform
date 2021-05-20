package com.kevdev.ecomplatform.Interfaces;

import com.kevdev.ecomplatform.Domain.User.User;
import com.kevdev.ecomplatform.Domain.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(){
        userService.createNewUser(new User(
                "myName",
                "insta",
                "HK",
                "10101010",
                true,
                0.0
        ));
    }

}
