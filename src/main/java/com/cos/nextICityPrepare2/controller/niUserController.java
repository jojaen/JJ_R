package com.cos.nextICityPrepare2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class niUserController {
	
	@GetMapping("/auth/loginForm")
	public String login() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/joinForm")
	public String join() {
		return "user/joinForm";
	}
}
