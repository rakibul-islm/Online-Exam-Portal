package api.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
