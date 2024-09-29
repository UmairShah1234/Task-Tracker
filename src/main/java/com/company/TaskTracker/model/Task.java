package com.company.TaskTracker.model;


import com.company.TaskTracker.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {
    @Id
    private String taskName;
    private String taskDescription;
    private LocalDate creationDate;
    private TaskStatus taskStatus;
    private Long userId;
}
