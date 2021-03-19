package com.webexecutor.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UiController {

    @RequestMapping(value = "/")
	public String index() {
		return "home";
	}

    @RequestMapping(value = "/dashboard")
	public String dashboard() {
		return "dashboard";
	}

    @RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}
