package com.markpeng.Todolist.model.dao;

import com.markpeng.Todolist.model.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Integer>{
    
}