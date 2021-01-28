package com.webexecutor.ui;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public void dashboard(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("waterBillLastRun", new Date());
    }
}
