package api.examportal.service;

import java.util.Set;

import api.examportal.model.User;
import api.examportal.model.UserRole;

public interface UserService {

	/* creating user */
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	/* get user by username */
	public User getUser(String username);
	

	/* delete user by userId */
	public void deleteUser(Long userId);
}