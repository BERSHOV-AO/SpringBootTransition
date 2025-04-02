package ru.kata.springboottransition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.springboottransition.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
