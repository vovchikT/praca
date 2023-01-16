package com.example.dto;

public class ChangePasswordDto {
    private Long Id;
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ChangePasswordDto(Long id, String password) {
        Id = id;
        this.password = password;
    }
}
