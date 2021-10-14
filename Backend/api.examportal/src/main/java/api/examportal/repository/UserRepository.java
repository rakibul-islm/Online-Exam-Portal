package api.examportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.User;
import api.examportal.model.exam.Exam;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	Set<User> findByExam(Exam exam);

}
