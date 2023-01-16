package com.example.repository;

import com.example.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
    boolean existsByLogin(String login);

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    int updatePassword(@Param(value = "password") String password, @Param(value = "id") Long id);

    @Transactional
    @Modifying
    @Query("update User u set u.name = :name where u.id = :id")
    int updateName(@Param(value = "name") String name, @Param(value = "id") Long id);
}
