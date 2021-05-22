package com.kevdev.ecomplatform.Interfaces;

import com.kevdev.ecomplatform.Domain.User.User;
import com.kevdev.ecomplatform.Domain.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity getUsers(){
        Iterable<User> userList = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        Long uid = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(uid);
    }

    @PostMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user){
        Boolean exist = userService.updateUser(id, user);
        if(!exist) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cannot found");
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }
}
