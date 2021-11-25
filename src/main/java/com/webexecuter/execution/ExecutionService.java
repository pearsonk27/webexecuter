package com.webexecuter.execution;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.webexecuter.schedule.ExecutionSchedule;
import com.webexecuter.schedule.ExecutionScheduleRepository;
import com.webexecuter.task.Task;
import com.webexecutor.ui.AppProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ExecutionService {

    private AppProperties appProperties;

    @Autowired
    public ExecutionService(ExecutionLogRepository executionLogRepository, AppProperties appProperties, ExecutionScheduleRepository executionScheduleRepository) {
        this.appProperties = appProperties;
    }

    public void run(Task task, Runtime runtime) throws IOException {
        String cmd = String.format("%s %s/main.py %s", appProperties.getPythonCommand(), appProperties.getExecutionDirectory(), task.getName());
        runtime.exec(cmd);
    }
    
}
