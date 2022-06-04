package com.markpeng.Todolist.model.dao;

import com.markpeng.Todolist.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    
}
