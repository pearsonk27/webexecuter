package com.webexecutor.ui;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ApiController {

	private ExecutionService executionService;

	@Autowired
	public ApiController(ExecutionService executionService) {
		this.executionService = executionService;
	}
    
	@PostMapping("/execute")
    public @ResponseBody ResponseEntity<?> execute(@RequestParam(name = "name", required = true) String name) throws IOException {
        Task task = Task.findTaskByUiName(name);
        executionService.run(task, Runtime.getRuntime());
        return ResponseEntity.ok(null);
    }
}
