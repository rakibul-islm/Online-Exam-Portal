package api.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.examportal.helper.UserFoundException;
import api.examportal.model.Authority;
import api.examportal.model.Role;
import api.examportal.model.User;
import api.examportal.model.UserRole;
import api.examportal.model.exam.Exam;
import api.examportal.model.exam.Question;
import api.examportal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/* creating user */
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		user.setProfile("default.png");

		// encoding password with bcryptpasswordencoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Set<UserRole> userRoleSet = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		userRoleSet.add(userRole);

		return this.userService.createUser(user, userRoleSet);
	}

	/* creating candidate */
	@PostMapping("/candidate")
	public User createCandidate(@RequestBody User user) throws Exception {

//		user.setProfile("default.png");
//		user.setPassword("123");
//		user.setUsername("r1234");
//		user.setFirstName("RAKIBUL");
//		user.setLastName("ISLAM");

		// encoding password with bcryptpasswordencoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Set<UserRole> userRoleSet = new HashSet<>();

		Role role = new Role();
		role.setRoleId(46L);
		role.setRoleName("CANDIDATE");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		userRoleSet.add(userRole);

		return this.userService.createUser(user, userRoleSet);
	}

	/* get user by username */
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return this.userService.getUser(username);

	}

	/* get user by exam Id */
	@GetMapping("/exam/{qid}")
	public ResponseEntity<?> getUsersOfExamAdmin(@PathVariable("qid") Long qid) {
		Exam exam = new Exam();
		exam.setExId(qid);
		Set<User> usersOfExam = this.userService.getUserOfExam(exam);
		return ResponseEntity.ok(usersOfExam);

	}

	/* delete user by Id */
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long Id) {
		this.userService.deleteUser(Id);
	}

	// update user
	@PutMapping("/")
	public ResponseEntity<User> update(@RequestBody User user) {

		//user.setPassword(this.bCryptPasswordEncoder.encode("123"));
		return ResponseEntity.ok(this.userService.updateUser(user));
	}
	
	// update password
		@PutMapping("/password")
		public ResponseEntity<User> updatePassword(@RequestBody User user) {

			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			return ResponseEntity.ok(this.userService.updateUser(user));
		}

	// update api
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}

}
