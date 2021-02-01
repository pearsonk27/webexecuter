package com.webexecutor.ui;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

    @Autowired
    private AppProperties appProperties;

    public void run(Task task, Runtime runtime) throws IOException {
        String cmd = String.format("%s %s.py", appProperties.getPythonCommand(), Paths.get(appProperties.getExecutionDirectory(), task.getExecutionName()));
        runtime.exec(cmd);
    }
    
}
