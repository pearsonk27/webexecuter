package com.webexecutor.taskexecutor;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import com.webexecuter.schedule.ExecutionSchedule;
import com.webexecuter.schedule.ExecutionScheduleRepository;
import com.webexecutor.ui.AppProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

public class TaskExecutorThread extends Thread {
    
    Logger logger = LoggerFactory.getLogger(TaskExecutorThread.class);

    private AppProperties appProperties;

    private ExecutionScheduleRepository executionScheduleRepository;

    @Autowired
    public TaskExecutorThread(AppProperties appProperties, ExecutionScheduleRepository executionScheduleRepository) {
        this.appProperties = appProperties;
        this.executionScheduleRepository = executionScheduleRepository;
    }

    public void run() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("TaskExecutorThread");
        threadPoolTaskScheduler.initialize();
        while (true) {
            try {
                Iterable<ExecutionSchedule> executionSchedules = executionScheduleRepository.findAll();
                for (ExecutionSchedule executionSchedule : executionSchedules) {
                    if (executionSchedule.isActive()) {
                        if ("One Time".equals(executionSchedule.getScheduleType().getName()) && OffsetDateTime.now().isBefore(executionSchedule.getStartTime())) {
                            // TODO add more logic about searching for execution in history, don't add if there's a one time execution done
                            threadPoolTaskScheduler.schedule(new ExecutableTask(executionSchedule), executionSchedule.getStartTime().toInstant());
                        } else if ("Cron".equals(executionSchedule.getScheduleType().getName()) && OffsetDateTime.now().isAfter(executionSchedule.getStartTime())) {
                            threadPoolTaskScheduler.schedule(new ExecutableTask(executionSchedule), new CronTrigger(executionSchedule.getCronExpression()));
                        }
                    }
                }
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class ExecutableTask implements Runnable {

        private ExecutionSchedule executionSchedule;

        ExecutableTask(ExecutionSchedule executionSchedule) {
            this.executionSchedule = executionSchedule;
        }
        
        @Override
        public void run() {
            String cmd = String.format("%s %s/main.py %s", appProperties.getPythonCommand(), appProperties.getExecutionDirectory(), executionSchedule.getTask().getName());
            logger.info("Running Task: {}", executionSchedule.getTask().getName());
            logger.info("Command: {}", cmd);
        }
        
    }
}
