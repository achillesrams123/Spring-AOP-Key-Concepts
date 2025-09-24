package com.example.aoplab.service;

import com.example.aoplab.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private Map<Long, User> users = new HashMap<>();
    private long nextId = 1;

    public User createUser(String username, String fullName, String email) {
        User user = new User(nextId++, username, fullName, email);
        users.put(user.getId(), user);
        return user;
    }

    public User findUserById(Long id) {
        return users.get(id);
    }

    public User updateUser(Long id, String fullName, String email) {
        User user = users.get(id);
        if (user != null) {
            user.setFullName(fullName);
            user.setEmail(email);
        }
        return user;
    }

    public void deleteUser(Long id) {
        if (!users.containsKey(id)) {
            throw new RuntimeException("User not found");
        }
        users.remove(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserByUsername(String username) {
        return users.values().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void simulateError() {
        throw new RuntimeException("Simulated error");
    }
}
