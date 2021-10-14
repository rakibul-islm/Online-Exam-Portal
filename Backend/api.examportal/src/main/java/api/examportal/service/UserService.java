package api.examportal.service;

import java.util.Set;

import api.examportal.model.User;
import api.examportal.model.UserRole;
import api.examportal.model.exam.Exam;

public interface UserService {

	/* creating user */
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	

	/* update user */
	public User updateUser(User user);
	

	/* get user by username */
	public User getUser(String username);
	
	/* get user by exam Id */
	public Set<User> getUserOfExam(Exam exam);
	

	/* delete user by userId */
	public void deleteUser(Long userId);
	
	
}
