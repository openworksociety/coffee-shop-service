package app.coffee.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.coffee.service.dto.UserInfo;
import app.coffee.service.entity.User;
import app.coffee.service.repository.UserRepository;

@RestController
@RequestMapping(path = "/api")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@PostMapping("/login")
	public UserInfo login(@RequestBody UserInfo userInfo) {

		User loggedInUser = userRepository.findByUsernameAndPassword(userInfo.getUsername(), userInfo.getPassword());

		UserInfo user = new UserInfo();
		if (loggedInUser != null) {
			user.setValid(true);
			user.setId(loggedInUser.getId());
			user.setUsername(loggedInUser.getUsername());
			user.setMessage("Login Successful");
		} else {
			user.setValid(false);
			user.setMessage("Invalid Credentials");
		}
		return user;
	}

}
