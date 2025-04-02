package ru.kata.springboottransition.service;

import ru.kata.springboottransition.model.User;

import java.util.List;

public interface UserService {
    List<User> finalAllUsers();
    void saveUser(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
}
