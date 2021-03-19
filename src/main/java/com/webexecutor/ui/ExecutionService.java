package com.webexecutor.ui;

import java.io.IOException;

import com.webexecuter.task.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

    @Autowired
    private AppProperties appProperties;

    public void run(Task task, Runtime runtime) throws IOException {
        String cmd = String.format("%s %s/main.py %s", appProperties.getPythonCommand(), appProperties.getExecutionDirectory(), task.getDisplayName());
        runtime.exec(cmd);
    }
    
}
