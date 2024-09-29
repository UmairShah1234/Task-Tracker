package com.company.TaskTracker.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasksRequest {
    List<TaskRequest> taskRequests;
}
