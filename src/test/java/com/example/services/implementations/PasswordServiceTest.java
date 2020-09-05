package com.example.services.implementations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.regex.Pattern;

@RunWith(JUnit4.class)
public class PasswordServiceTest {

    private static final String PASSWORD = "qwerty";

    private PasswordService passwordService = new PasswordService();

    @Test
    public void  generateSecurePassword(){
        String result = passwordService.generateSecurePassword(PASSWORD);
        System.out.println("Test message: Git actions work success!");
        Assert.assertTrue(Pattern.matches("[a-z0-9]+", result));
    }
}
