package app.coffee.service.repository;

import org.springframework.data.repository.CrudRepository;

import app.coffee.service.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

}
