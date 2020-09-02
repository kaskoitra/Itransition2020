package com.example.controllers;

import com.example.dto.AuthTokenDto;
import com.example.dto.UserDtoForLogin;
import com.example.filters.TokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *Controller for authentication and token generation
 *
 * @return ResponseEntity response status and JWT
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenProvider jwtTokenUtil;

    @RequestMapping(value = "/generate-token", method = POST)
    public ResponseEntity<?> register(@RequestBody final UserDtoForLogin userDtoForLogin) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                userDtoForLogin.getUsername(),
                userDtoForLogin.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthTokenDto(token));
    }
}
