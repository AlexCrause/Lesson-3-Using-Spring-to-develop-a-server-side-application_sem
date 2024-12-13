package com.example.sem3hometask.controllers;

import com.example.sem3hometask.domain.User;
import com.example.sem3hometask.servicies.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") //localhost:8080/tasks
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {

        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calculate");
        return tasks;
    }

    @GetMapping("/sort") //localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    @GetMapping("/filter/{age}") //localhost:8080/tasks/filter
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    @GetMapping("/calculate") //localhost:8080/tasks/calculate
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
