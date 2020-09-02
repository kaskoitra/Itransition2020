package com.example.dto;

public class AuthTokenDto
{

    private String token;

    public AuthTokenDto(){
    }

    public AuthTokenDto(String token){
        this.token = token;
    }

    public AuthTokenDto(String token, String username) {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "[token=" + this.token + "]";
    }
}
