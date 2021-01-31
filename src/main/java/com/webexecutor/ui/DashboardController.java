package com.webexecutor.ui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @Autowired
    private ExecutionService executionService;

    @GetMapping("/dashboard")
    public void dashboard(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("waterBillLastRun", new Date());
        model.addAttribute("gasBillLastRun", new Date());
        model.addAttribute("electricBillLastRun", new Date());
        model.addAttribute("cableBillLastRun", new Date());
    }

    @PostMapping("/dashboard")
    public void execute(@RequestParam(name="name", required=true) String name, Model model) {
        Task task = Task.findTaskByUiName(name);
        executionService.run(task);
        dashboard(name, model);
    }
}
