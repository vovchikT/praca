package com.example.service;

import com.example.dto.CreateDto;
import com.example.dto.LogInDto;
import com.example.dto.MessageDto;
import com.example.entity.User;
import com.example.dto.ResponseDto;
import com.example.repository.ExpenseRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public ResponseEntity<?> createNewUser(CreateDto createDto) {
        if (userRepository.existsByLogin(createDto.getCreateLogin())) {
            return ResponseEntity.badRequest()
                    .body(new MessageDto("Error: login already in use!", 400));
        }

        User user = new User(createDto.getCreateName(), createDto.getCreateLogin(), createDto.getCreatePassword());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageDto("User was created", 200));
    }

    public ResponseEntity<?> logInUser(LogInDto logInDto) {
        User user = userRepository.findByLogin(logInDto.getLogin()).get();
        if (userRepository.findByLogin(logInDto.getLogin()).isPresent()) {
            if (userRepository.findByLogin(logInDto.getLogin()).get().getPassword().equals(logInDto.getPassword()))
                return ResponseEntity.ok(new ResponseDto( user.getId(), user.getName()));
            else
                return ResponseEntity.badRequest()
                        .body(new MessageDto("Incorrect password", 400));
        } else {
                return ResponseEntity.badRequest()
                        .body(new MessageDto("Incorrect login", 400));
        }
    }

    public ResponseEntity<?> changePassword(Long id, String password) {
        if (userRepository.updatePassword(password, id) > 0) {
            User user = userRepository.findById(id).get();
            return ResponseEntity.ok(new ResponseDto(user.getId(), user.getName()));
        } else {
            return ResponseEntity.badRequest()
                    .body(new MessageDto("Something went wrong", 400));
        }
    }

    public ResponseEntity<?> changeName(Long id, String name) {
        if (userRepository.updateName(name, id) > 0) {
            User user = userRepository.findById(id).get();
            return ResponseEntity.ok(new ResponseDto(user.getId(), user.getName()));
        } else {
            return ResponseEntity.badRequest()
                    .body(new MessageDto("Something went wrong", 400));
        }
    }
}

    Proszę jeszcze opisać co można zobaczyć na tych wykresach ze statystyką wydatków, jak są generowane, jak można nimi zarządzać itd.

        Zanim nastepne zdania, proszę tutaj napisać: jakie funkcje daje aplikacja, co można zrobić, i też krótko podsumować jak ta aplikacja postw
        ała – w jakich technologiach, jakimi narzędziami i jak działa. Dosłownie kilka zdań – max. pół strony.