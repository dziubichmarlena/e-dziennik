package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByLogin(String login);
}
