package com.markpeng.Todolist.service;

import com.markpeng.Todolist.model.dao.TodoDao;
import com.markpeng.Todolist.model.entity.Todo;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @MockBean
    TodoDao todoDao;

    @Test
    public void testGetTodos() {
        ArrayList<Todo> expectedTodoList = new ArrayList<Todo>();
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTask("do homework");
        todo.setStatus(true);
        expectedTodoList.add(todo);

        // Mock todoDao
        Mockito.when(todoDao.findAll()).thenReturn(expectedTodoList);
        Iterable<Todo> actualTodoList = todoService.getTodos();
        assertEquals(expectedTodoList, actualTodoList);
    }

    @Test
    public void testCreateTodo() {
        String todoContensts = "do homework";
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTask(todoContensts);
        todo.setStatus(true);

        Mockito.when(todoDao.save(any(Todo.class))).thenReturn(todo);
        Integer actualId = todoService.createTodo(todoContensts);
        assertEquals(1, actualId);
    }

    @Test
    public void testUpdateTodoSuccess() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTask("do homework");
        todo.setStatus(false);
        Optional<Todo> resTodo = Optional.of(todo);
        
        Todo updateData = new Todo();
        updateData.setStatus(true);

        Mockito.when(todoDao.existsById(1)).thenReturn(true);
        Mockito.when(todoDao.findById(1)).thenReturn(resTodo);

        Boolean actualUpdateResult = todoService.updateTodo(1, updateData);
        assertEquals(true, actualUpdateResult);
    }

    @Test
    public void testUpdateTodoIdNotExist() {
        Todo updateData = new Todo();
        updateData.setStatus(true);

        Mockito.when(todoDao.existsById(1)).thenReturn(false);

        Boolean actualUpdateResult = todoService.updateTodo(1, updateData);
        assertEquals(false, actualUpdateResult);
    }

    @Test
    public void testUpdateTodoStatusIsNull() {
        Todo updateData = new Todo();
        Mockito.when(todoDao.existsById(1)).thenReturn(true);

        Boolean actualUpdateResult = todoService.updateTodo(1, updateData);
        assertEquals(false, actualUpdateResult);
    }

    @Test
    public void testDeleteTodo() {
        Mockito.when(todoDao.existsById(1)).thenReturn(true);
        Mockito.when(todoDao.existsById(2)).thenReturn(false);

        Boolean actualDeleteResult1 = todoService.deleteTodo(1);
        Boolean actualDeleteResult2 = todoService.deleteTodo(2);

        assertEquals(true, actualDeleteResult1);
        assertEquals(false, actualDeleteResult2);
    }
    
}