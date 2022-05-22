package app.coffee.service.event;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import app.coffee.service.entity.User;
import app.coffee.service.repository.UserRepository;

@Component
public class DefaultDataSetupListener implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		createUserIfNotFound("admin");
		createUserIfNotFound("user");

		alreadySetup = true;
	}

	private void createUserIfNotFound(String username) {
		User entity = userRepository.findByUsername(username);
		if (Objects.isNull(entity)) {
			User user = new User();
			user.setFname("F-" + username);
			user.setLname("L-" + username);
			user.setUsername(username);
			user.setPassword(username);
			user.setCreatedBy(1L);
			user.setModifiedBy(1L);
			userRepository.save(user);
		}
	}

}
