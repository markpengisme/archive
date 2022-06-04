package com.markpeng.Todolist.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    
    @Test
    public void whenSetIdThenGetId() {
        Todo todo = new Todo();
        todo.setId(1);
        Integer expected = 1;
        Integer actual = todo.getId();

        assertEquals(expected, actual);

    }

    @Test
    public void whenSetTaskThenGetTask() {
        Todo todo = new Todo();
        todo.setTask("write");
        String expected = "write";
        String actual = todo.getTask();

        assertEquals(expected, actual);
    }

    @Test
    public void whenSetStatusThenGetStatus() {
        Todo todo = new Todo();
        todo.setStatus(true);
        Boolean expected = true;
        Boolean actual = todo.getStatus();

        assertEquals(expected, actual);
    }
}
