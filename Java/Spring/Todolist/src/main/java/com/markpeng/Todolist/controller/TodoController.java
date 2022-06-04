package com.markpeng.Todolist.controller;

import java.util.Optional;

import com.markpeng.Todolist.model.entity.Todo;
import com.markpeng.Todolist.service.TodoService;
// import com.markpeng.Todolist.util.MyLogger;
import com.markpeng.Todolist.response.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.PathVariable;
import org.json.JSONObject;

@Api(tags = "Todo-list-APIs")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class TodoController {
    // private final MyLogger logger = new MyLogger();
    @Autowired
    TodoService todoService;

    @ApiOperation("Get all todos")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully get all todos") })
    @ResponseBody
    @GetMapping(value = "/todo", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> getTodos() {
        Iterable<Todo> todoList = todoService.getTodos();
        return ResponseHandler.generateResponse("Successfully get all todos!", HttpStatus.OK, todoList);
    }

    @ApiOperation("Get one todo by id")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully get a todo"),
            @ApiResponse(responseCode = "404", description = "Id does not exists") })
    @ResponseBody
    @GetMapping(value = "/todo/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> getTodo(@PathVariable Integer id) {
        // logger.loggerExample();
        Optional<Todo> todo = todoService.getTodo(id);
        if (todo.isPresent()) {
            return ResponseHandler.generateResponse("Successfully get a todo", HttpStatus.OK, todo.get());
        } else {
            return ResponseHandler.generateResponse("Id does not exists!", HttpStatus.NOT_FOUND, null);
        }
    }

    @ApiOperation("Create one todo with task content")
    @ApiResponses({ @ApiResponse(responseCode = "201", description = "Successfully created a todo"),
            @ApiResponse(responseCode = "400", description = "Created failed when task is empty") })
    @ResponseBody
    @PostMapping(value = "/todo", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Object> createTodo(@RequestBody Optional<Todo> todo) {
        if (todo.isPresent() && todo.get().getTask() != null) {
            Integer resultId = todoService.createTodo(todo.get().getTask());
            JSONObject jo = new JSONObject();
            jo.put("id", resultId);
            return ResponseHandler.generateResponse("Successfully created a todo!", HttpStatus.CREATED, jo.toMap());
        } else {
            return ResponseHandler.generateResponse("Created failed!", HttpStatus.BAD_REQUEST, null);
        }

    }

    @ApiOperation("Update one todo by id")
    @ResponseBody
    @PutMapping(value = "/todo/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> upadteTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        Boolean result = todoService.updateTodo(id, todo);
        if (!result) {
            return ResponseHandler.generateResponse("Update failed!", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Successfully updated a todo!", HttpStatus.OK, null);
    }

    @ApiOperation("Delete one todo by id")
    @ResponseBody
    @DeleteMapping(value = "/todo/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTodo(@PathVariable Integer id) {
        Boolean result = todoService.deleteTodo(id);
        if (!result) {
            return ResponseHandler.generateResponse("Id does not exists!", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Successfully deleted a todo!", HttpStatus.NO_CONTENT, null);
    }
}
