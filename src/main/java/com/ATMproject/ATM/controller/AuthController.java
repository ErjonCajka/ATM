/*package com.ATMproject.ATM.controller;

import com.ATMproject.ATM.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> doLogin(Authentication authentication){
        var token = "Bearer ".concat(tokenService.generateToken(authentication));
        return ResponseEntity.ok(token);
    }
}
*/