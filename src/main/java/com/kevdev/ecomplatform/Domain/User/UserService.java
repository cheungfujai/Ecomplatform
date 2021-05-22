package com.kevdev.ecomplatform.Domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Long createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    public boolean updateUser(Long id, User user) {
        Optional<User> isExist = userRepository.findById(id);
        if(!isExist.isPresent()) return false;

        User newUser = isExist.get();
        userRepository.save(newUser);
        return true;
    }
}
