package com.webexecutor.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskMetricsRepository taskMetricsRepository;

    public List<TaskMetrics> findAll() {
        return taskMetricsRepository.findAll();
    }
}
