package com.markpeng.Todolist.service;

import java.util.Optional;

import com.markpeng.Todolist.model.dao.UserDao;
import com.markpeng.Todolist.model.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Optional<User> getTodosByUserId(Integer id) {
        Optional<User> user = userDao.findById(id);
        return user;
    }
}