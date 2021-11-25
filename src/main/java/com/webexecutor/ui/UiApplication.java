package com.webexecutor.ui;

import com.webexecutor.taskexecutor.TaskExecutorThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"com.webexecuter.execution", "com.webexecuter.task", "com.webexecuter.schedule", "com.webexecutor.ui", "com.webexecutor.taskexecutor"}) 
@EntityScan(basePackages={"com.webexecuter.execution", "com.webexecuter.task", "com.webexecuter.schedule"}) 
@EnableJpaRepositories(basePackages={"com.webexecuter.execution", "com.webexecuter.task", "com.webexecuter.schedule"}) 
@SpringBootApplication
public class UiApplication {

	@Autowired
	private TaskExecutorThread taskExecutorThread;

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
