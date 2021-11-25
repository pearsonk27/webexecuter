package com.webexecutor.taskexecutor;

import com.webexecuter.schedule.ExecutionScheduleRepository;
import com.webexecutor.ui.AppProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskExecutorThreadConfig {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ExecutionScheduleRepository executionScheduleRepository;
    
    @Bean
    public TaskExecutorThread taskExecutorThread() {
        return new TaskExecutorThread(appProperties, executionScheduleRepository);
    }
}
