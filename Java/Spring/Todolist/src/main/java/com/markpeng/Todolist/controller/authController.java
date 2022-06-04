package com.markpeng.Todolist.controller;

import java.util.HashMap;

import javax.security.auth.message.AuthException;

import com.markpeng.Todolist.response.ResponseHandler;
import com.markpeng.Todolist.security.JwtToken;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class authController {

    // Get token
    @ResponseBody
    @PostMapping("/token")
    public ResponseEntity<Object> login(@RequestBody HashMap<String, String> user) {
        System.out.println(user);
        JwtToken jwtToken = new JwtToken();
        String token = jwtToken.generateToken(user);

        return ResponseHandler.generateResponse("Successfully login!", HttpStatus.OK, token);
    }

    // Check token
    @GetMapping("/token")
    public ResponseEntity<Object> hello(@RequestHeader("Authorization") String auth) {
        String token = auth.substring(7);
        JwtToken jwtToken = new JwtToken();
        try {
            jwtToken.validateToken(token);
        } catch (AuthException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.FORBIDDEN, null);
        }
        return ResponseHandler.generateResponse("You have a correct token!", HttpStatus.OK, null);
    }
}