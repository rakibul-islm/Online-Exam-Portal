package api.examportal.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.examportal.model.User;

@Entity
public class Exam {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exId;

	private String title;

	@Column(length = 5000)
	private String description;

	private String maxMarks;

	private String numberOfQuestions;
	
	private String date;
	
	private String time;

	private boolean active = false;
	

	// add..



	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<User> users = new HashSet<>();


	public Exam() {

	}


	public Exam(Long exId, String title, String description, String maxMarks, String numberOfQuestions, String date,
			String time, boolean active, Set<Question> questions, Set<User> users) {
		super();
		this.exId = exId;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.date = date;
		this.time = time;
		this.active = active;
		this.questions = questions;
		this.users = users;
	}


	public Long getExId() {
		return exId;
	}


	public void setExId(Long exId) {
		this.exId = exId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getMaxMarks() {
		return maxMarks;
	}


	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}


	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}


	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
	


}
