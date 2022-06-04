package com.markpeng.Todolist.controller;

import java.util.Optional;

import com.markpeng.Todolist.model.entity.User;
import com.markpeng.Todolist.response.ResponseHandler;
import com.markpeng.Todolist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}/todo")
    public ResponseEntity<Object> getTodosByUserId(@PathVariable Integer id) {
        Optional<User> user = userService.getTodosByUserId(id);
        if (user.isPresent()) {
            return ResponseHandler.generateResponse("Successfully get user's todos", HttpStatus.OK,
                    user.get().getTodos());
        } else {
            return ResponseHandler.generateResponse("User does not exists!", HttpStatus.NOT_FOUND, null);
        }
    }
}
