package com.markpeng.Todolist.service;

import com.markpeng.Todolist.model.dao.TodoDao;
import com.markpeng.Todolist.model.entity.Todo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public Iterable<Todo> getTodos() {
        return todoDao.findAll();
    }

    public Optional<Todo> getTodo(Integer id) {
        Optional<Todo> todo = todoDao.findById(id);
        return todo;
    }

    public Integer createTodo(String todoContensts) {
        Todo todo = new Todo();
        todo.setTask(todoContensts);
        Todo result = todoDao.save(todo);
        return result.getId();
    }

    public Boolean updateTodo(Integer id, Todo todo) {
        if (todoDao.existsById(id) && todo.getStatus() != null) {
            Todo result = todoDao.findById(id).get();
            result.setStatus(todo.getStatus());
            todoDao.save(result);
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteTodo(Integer id) {
        if (todoDao.existsById(id)) {
            todoDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
