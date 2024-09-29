package com.company.TaskTracker.service;

import com.company.TaskTracker.enums.TaskStatus;
import com.company.TaskTracker.model.Task;
import com.company.TaskTracker.request.TaskRequest;
import com.company.TaskTracker.request.TasksRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;


@Service
public class TaskService {

    private static final String REDIS_TASK = "TASK";

    @Autowired
    private RedisTemplate redisTemplate;



    public Task createTask(TaskRequest taskRequest) {
        if (getTaskById(taskRequest.getTaskName()) != null){
            return new Task();
        }
        Task newTask = new Task(taskRequest.getTaskName(), taskRequest.getTaskDescription(), LocalDate.now(),TaskStatus.INITIATED);
        redisTemplate.opsForHash().put(REDIS_TASK,newTask.getTaskName(),newTask);
        return newTask;
    }

    public Map<String,Task> createTask(TasksRequest tasks){
        for (TaskRequest task : tasks.getTaskRequests()){
            createTask(task);
        }
        return getAllTask();
    }

    public Task getTaskById(String id) {
        return (Task) redisTemplate.opsForHash().get(REDIS_TASK,id);
    }

    public Map<String,Task> getAllTask() {
        return redisTemplate.opsForHash().entries(REDIS_TASK);
    }

    public Map<String,Task> deleteAllTask() {
        redisTemplate.delete(REDIS_TASK);
        return getAllTask();
    }

    public Map<String,Task> deleteTaskById(String id) {
        redisTemplate.opsForHash().delete(REDIS_TASK,id);
        return getAllTask();
    }
}
