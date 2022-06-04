package com.markpeng.Todolist.intergation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.markpeng.Todolist.service.TodoService;
import com.markpeng.Todolist.model.entity.Tag;
import com.markpeng.Todolist.model.entity.Todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.json.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@Sql(scripts = "classpath:test/data.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    TodoService todoService;
    @Autowired
    ObjectMapper objectMapper;

    private Todo todo;
    private ArrayList<Todo> expectedList;

    @BeforeEach
    public void setup() throws Exception {

        String strDate = "2020-09-20 19:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(strDate);
        Set<Tag> tags = new HashSet<Tag>();

        todo = new Todo();
        todo.setId(1);
        todo.setTask("do homework");
        todo.setStatus(false);
        todo.setCreateTime(date);
        todo.setUpdateTime(date);
        todo.setTags(tags);
        expectedList = new ArrayList<Todo>();
        expectedList.add(todo);

    }

    @Test
    public void testGetTodos() throws Exception {
        String returnString = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/todo").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        Iterable<Todo> actualList = objectMapper.readValue(jsonObject.getJSONArray("data").toString(),
                new TypeReference<Iterable<Todo>>() {
                });
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testGetTodo() throws Exception {
        String returnString = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/todo/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        Todo actualTodo = objectMapper.readValue(jsonObject.getJSONObject("data").toString(), Todo.class);
        assertEquals(todo, actualTodo);
    }

    @Test
    public void testGetTodoIdNotExist() throws Exception {
        String returnString = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/todo/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);
        assertEquals(true, jsonObject.isNull("data"));
    }

    @Test
    public void testCreateTodo() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("task", "do homework");

        String returnString = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/todo").accept(MediaType.APPLICATION_JSON) // response
                        .contentType(MediaType.APPLICATION_JSON) // request
                        .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getContentAsString();

        JSONObject jsonObject = new JSONObject(returnString);

        Integer actualId = jsonObject.getJSONObject("data").getInt("id");
        assertEquals(2, actualId);
    }

    @Test
    public void testCreateTodoEmptyContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo").accept(MediaType.APPLICATION_JSON)) // response
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn().getResponse()
                .getContentAsString();
    }

    @Test
    public void testUpdateTodo() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("status", true);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/1").accept(MediaType.APPLICATION_JSON) // response
                .contentType(MediaType.APPLICATION_JSON) // request
                .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateTodoIdNotExist() throws Exception {
        JSONObject todoObject = new JSONObject();
        todoObject.put("status", true);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/2").accept(MediaType.APPLICATION_JSON) // response
                .contentType(MediaType.APPLICATION_JSON) // request
                .content(todoObject.toString())) // body
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testDeleteTodo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent()); // 預期回應的status code 應為 204(No Content)
    }

    @Test
    public void testDeleteTodoIdNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound()); // 預期回應的status code 應為 204(No Content)
    }
}