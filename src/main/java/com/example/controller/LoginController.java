package com.example.controller;

import com.example.dto.*;
import com.example.service.LoginService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User has been logged in",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Błąd", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LogInDto logInDto) {
        return loginService.logInUser(logInDto);
    }

    @CrossOrigin
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bład", content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateDto createDto) {
        return loginService.createNewUser(createDto);
    }

    @CrossOrigin
    @PostMapping("/change/password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDto changeDto) {
        return loginService.changePassword(changeDto.getId(), changeDto.getPassword());
    }

    @CrossOrigin
    @PostMapping("/change/name")
    public ResponseEntity<?> changeName(@Valid @RequestBody ChangeNameDto changeDto) {
        return loginService.changeName(changeDto.getId(), changeDto.getName());
    }


}
