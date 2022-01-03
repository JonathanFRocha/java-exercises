package br.com.jonathanferreira.spring.forum.repository;

import br.com.jonathanferreira.spring.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
