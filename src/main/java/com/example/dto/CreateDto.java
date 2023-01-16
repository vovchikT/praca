package com.example.dto;

public class CreateDto{


    private String createName;

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateLogin() {
        return createLogin;
    }

    public void setCreateLogin(String createLogin) {
        this.createLogin = createLogin;
    }

    public String getCreatePassword() {
        return createPassword;
    }

    public void setCreatePassword(String createPassword) {
        this.createPassword = createPassword;
    }

    private String createLogin;
    private String createPassword;
}
