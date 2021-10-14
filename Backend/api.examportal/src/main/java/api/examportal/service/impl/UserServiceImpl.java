package api.examportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.examportal.helper.UserFoundException;
import api.examportal.model.User;
import api.examportal.model.UserRole;
import api.examportal.model.exam.Exam;
import api.examportal.repository.RoleRepository;
import api.examportal.repository.UserRepository;
import api.examportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local = this.userRepository.findByUsername(user.getUsername());

		if (local != null) {
			System.out.println("User is already there !!");
			throw new UserFoundException();
		} else {
			// user create

			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);

		}

		return local;
	}

	@Override
	public User getUser(String username) {

		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);

	}

	@Override
	public Set<User> getUserOfExam(Exam exam) {
		return this.userRepository.findByExam(exam);
	}

	@Override
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}

	
	
	
	

}
