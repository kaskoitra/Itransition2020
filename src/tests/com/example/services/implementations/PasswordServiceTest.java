package com.example.services.implementations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Pattern;

import static org.mockito.ArgumentMatchers.notNull;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceTest {

    private static final String PASSWORD = "qwerty";

    @InjectMocks
    private PasswordService passwordService;

    @Test
    public void  generateSecurePassword(){
        String result = passwordService.generateSecurePassword(PASSWORD);
        Assert.assertTrue(Pattern.matches("[a-z0-9]+", result));
    }

}
