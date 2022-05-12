package app.coffee.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class TestController {

	@GetMapping(path = "/fetch")
	public String login() {
		return "test";
	}
}
