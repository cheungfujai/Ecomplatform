package com.kevdev.ecomplatform.Domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) { return userRepository.findById(id); }

    public Long createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    public Boolean updateUser(Long id, User user) {
        Optional<User> isExist = userRepository.findById(id);
        if(isExist.isEmpty()) return false;

        User newUser = isExist.get();
        userRepository.save(newUser);
        return true;
    }

    public Boolean deleteUser(Long id, User user) {
        Optional<User> isExist = userRepository.findById(id);
        if(isExist.isEmpty()) return false;

        User selectedUser = isExist.get();
        userRepository.delete(selectedUser);
        return true;
    }
}
