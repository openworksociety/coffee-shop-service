package app.coffee.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.coffee.service.entity.User;
import app.coffee.service.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	void create(@RequestBody User user) {
		user.setId(null);
		userRepository.save(user);
	}

	@ResponseBody
	@GetMapping("/{id}")
	User findById(@PathVariable Long id) {
		Optional<User> userEntity = userRepository.findById(id);
		if (userEntity.isPresent()) {
			return userEntity.get();
		}
		return null;
	}

	@ResponseBody
	@GetMapping("")
	List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Iterable<User> iterable = userRepository.findAll();
		iterable.forEach(user -> {
			if (!user.isDeactivated()) {
				users.add(user);
			}
		});
		return users;
	}

	@PutMapping("/update")
	void update(@RequestBody User user) {
		if (user.getId() != null) {
			Optional<User> UserEntity = userRepository.findById(user.getId());
			if (UserEntity.isPresent()) {
				userRepository.save(user);
			}
		}
	}

	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			user.get().setDeactivated(true);
			user.get().setModifiedDate(new Date());
			userRepository.save(user.get());
		}
	}

	@PostMapping("/test/{id}")
	void setupTestData(@PathVariable Long id) {

		for (int i = 1; i <= id.intValue(); i++) {
			User user = new User();
			user.setFname("Haridas" + i);
			user.setLname("Kanure" + i);
			user.setUsername("test" + i + "@gmail.com");
			user.setPassword("password" + i);
			userRepository.save(user);
		}
	}
}
