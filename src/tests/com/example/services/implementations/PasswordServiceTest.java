package com.example.services.implementations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceTest {

    private static final String PASSWORD = "qwerty";

    @InjectMocks
    private PasswordService passwordService;

    @Test
    public void  generateSecurePassword(){
        String result = passwordService.generateSecurePassword(PASSWORD);
        System.out.println("Test message: Git actions work success!");
        Assert.assertTrue(Pattern.matches("[a-z0-9]+", result));
    }

}
