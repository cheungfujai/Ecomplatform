package com.kevdev.ecomplatform.Interfaces;

import com.kevdev.ecomplatform.Domain.User.User;
import com.kevdev.ecomplatform.Domain.User.UserService;
import com.kevdev.ecomplatform.EcomplatformApplication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public Collection<User> getUsers() throws Exception {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            throw new Exception("Cannot get Users");
        }
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) throws Exception {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            throw new Exception("Cannot find this user");
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) throws Exception{
        try {
            Long uid = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(uid);
        } catch (Exception e){
            return new ResponseEntity<>("Cannot create user with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user){
        try {
            Boolean isExist = userService.updateUser(id, user);
            if(!isExist) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cannot found user");
            return ResponseEntity.status(HttpStatus.OK).body("user updated");
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot update user with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id, @RequestBody User user){
        try {
            Boolean isExist = userService.deleteUser(id, user);
            if(!isExist) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cannot found user");
            return  ResponseEntity.status(HttpStatus.OK).body("user deleted");
        } catch (Exception e){
            return new ResponseEntity<>("Cannot delete user with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
