package com.webexecutor.ui;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {
    
    @Autowired
    private AppProperties appProperties;

    public void run(Task task) {
        String cmd = String.format("python %s.py", Paths.get(appProperties.getExecutionDirectory(), task.getExecutionName()));
        System.out.println(cmd);
    }
    
}
