package com.webexecutor.ui;

import java.io.IOException;

import com.webexecuter.task.Task;
import com.webexecuter.task.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ApiController {

	private ExecutionService executionService;

	private TaskRepository taskRepository;

	@Autowired
	public ApiController(ExecutionService executionService, TaskRepository taskRepository) {
		this.executionService = executionService;
		this.taskRepository = taskRepository;
	}
    
	@PostMapping("/execute")
    public @ResponseBody ResponseEntity<?> execute(@RequestParam(name = "name", required = true) String name) throws IOException {
        Task task = taskRepository.findByName(name);
        executionService.run(task, Runtime.getRuntime());
        return ResponseEntity.ok(null);
    }
}
