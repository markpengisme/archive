package com.markpeng.Todolist.util;

import com.markpeng.Todolist.controller.TodoController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyLogger {
    private static final Logger logger
        = LoggerFactory.getLogger(TodoController.class);

    public void loggerExample() {
        logger.info("Hi...");
        logger.error("I am an error");
        logger.warn("Warning!.");
        logger.debug("???");
    }
}
