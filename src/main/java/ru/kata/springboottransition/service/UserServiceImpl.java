package ru.kata.springboottransition.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.springboottransition.model.User;
import ru.kata.springboottransition.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> finalAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            userRepository.save(existingUser);
        } else {
            userRepository.save(user);
        }
    }
    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }
}
