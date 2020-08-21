package com.example.services.implementations;

import com.example.dao.UserDAO;
import com.example.dto.Role;
import com.example.dto.User;
import com.example.services.PasswordService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(String firstName, String lastName, String email, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        PasswordService ps = new PasswordService();
        String salt = generateRandomString();
        user.setPassword(ps.generateSecurePassword(password, salt));

        Role role = new Role();
        role.setTitle("User");
        role.setSalt(salt);

        user.setRole(role);

        UserDAO userdao = new UserDAO();
        userdao.save( user, role);
    }

    @Override
    public User receiveUser(long id) {
        UserDAO userDAO = new UserDAO();
        return userDAO.receiveUser(id);
    }

    @Override
    public User receiveUser(String email, String password) {
        UserDAO userDAO = new UserDAO();
        return userDAO.receiveUser(email, password);
    }

    private String generateRandomString() {
        char[] text = new char[16];
        String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}
