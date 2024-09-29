package com.company.TaskTracker.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private String taskName;
    private String taskDescription;
}
