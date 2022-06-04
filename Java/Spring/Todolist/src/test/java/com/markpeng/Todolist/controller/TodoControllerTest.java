package com.markpeng.Todolist.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.markpeng.Todolist.model.entity.Todo;
import com.markpeng.Todolist.service.TodoService;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.json.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TodoService todoService;

    @Test
    public void testGetTodos() throws Exception {
        ArrayList<Todo> expectedList = new ArrayList<Todo>();
        Todo todo = new Todo();
        todo.setTask("do homework");
        todo.setId(1);
        expectedList.add(todo);
    
        Mockito.when(todoService.getTodos()).thenReturn(expectedList);
     
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/todo")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        Iterable<Todo> actualList = 
            objectMapper.readValue(jsonObject.getJSONArray("data").toString(),
            new TypeReference<Iterable<Todo>>(){});
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testGetTodo() throws Exception {
        Todo todo = new Todo();
        todo.setTask("do homework");
        todo.setId(1);
        Optional<Todo> resTodo = Optional.of(todo);
        
        Mockito.when(todoService.getTodo(1)).thenReturn(resTodo); 
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        Todo actualTodo = objectMapper.readValue(jsonObject.getJSONObject("data").toString(), Todo.class);
        assertEquals(todo, actualTodo);
    }

    @Test
    public void testGetTodoIdNotExist() throws Exception {
        Optional<Todo> todo = Optional.empty();
        Mockito.when(todoService.getTodo(2)).thenReturn(todo); 
        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        assertEquals(true, jsonObject.isNull("data"));
    }

    @Test
    public void testCreateTodo() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("task", "do homework");
    
        Mockito.when(todoService.createTodo("do homework")).thenReturn(1);
        String returnString = mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .accept(MediaType.APPLICATION_JSON) //response
                .contentType(MediaType.APPLICATION_JSON) // request
                .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        
        System.out.println(jsonObject);
        Integer actualId = jsonObject.getJSONObject("data").getInt("id");
        assertEquals(1, actualId);
    }

    @Test
    public void testCreateTodoEmptyContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .accept(MediaType.APPLICATION_JSON)) //response
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
    }

    @Test 
    public void testUpdateTodo() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("status", true);

        Mockito.when(todoService.updateTodo(eq(1), any(Todo.class))).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/1")
                .accept(MediaType.APPLICATION_JSON) //response
                .contentType(MediaType.APPLICATION_JSON) // request
                .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test 
    public void testUpdateTodoIdNotExist() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("status", true);

        Mockito.when(todoService.updateTodo(eq(2), any(Todo.class))).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/2")
                .accept(MediaType.APPLICATION_JSON) //response
                .contentType(MediaType.APPLICATION_JSON) // request
                .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test 
    public void testDeleteTodo() throws Exception {
        Mockito.when(todoService.deleteTodo(1)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent()); // 預期回應的status code 應為 204(No Content)
    }

    @Test 
    public void testDeleteTodoIdNotExist() throws Exception {
        Mockito.when(todoService.deleteTodo(2)).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound()); // 預期回應的status code 應為 204(No Content)
    }
}
