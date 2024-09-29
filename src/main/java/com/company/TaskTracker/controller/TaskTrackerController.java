package com.company.TaskTracker.controller;

import com.company.TaskTracker.model.Task;
import com.company.TaskTracker.request.TaskRequest;
import com.company.TaskTracker.request.TasksRequest;
import com.company.TaskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-tracker")
public class TaskTrackerController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create-task")
    public Task createtask(@RequestBody TaskRequest taskRequest){
        return taskService.createTask(taskRequest);
    }

    @PostMapping("/create-tasks")
    public Map<String,Task> createTasks(@RequestBody TasksRequest tasksRequest){
        return taskService.createTask(tasksRequest);
    }


    @GetMapping("/get-all-task")
    public Map<String,Task> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/get-task-by-id/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/delete-all-task")
    public Map<String,Task> deleteAllTask(){
        return taskService.deleteAllTask();
    }

    @DeleteMapping("/delete-task-by-id/{id}")
    public Map<String,Task> deleteTaskById(@PathVariable String Id){
        return taskService.deleteTaskById(Id);
    }
}
