package api.examportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.examportal.model.exam.Exam;
import api.examportal.model.exam.Question;
import api.examportal.model.exam.Quiz;
import api.examportal.service.ExamService;
import api.examportal.service.QuestionService;
import api.examportal.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@Autowired
	private QuizService quizService;

	@Autowired
	private ExamService examService;

	// add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question) {
		return ResponseEntity.ok(this.service.addQuestion(question));
	}

	// update the question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question) {
		return ResponseEntity.ok(this.service.updateQuestion(question));
	}

	// get all question of any quizId
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);

	}

	// get all question of any examId
	@GetMapping("/exam/{qid}")
	public ResponseEntity<?> getQuestionsOfExam(@PathVariable("qid") Long qid) {

		Exam exam = this.examService.getExam(qid);
		Set<Question> questions = exam.getQuestions();
		List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(exam.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(exam.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);

	}
	
	
		

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
		Quiz quiz = new Quiz();
		quiz.setqId(qid);
		Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);

	}

	// get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.service.getQuestion(quesId);
	}
	
	
	
	@GetMapping("/exam/all/{qid}")
	public ResponseEntity<?> getQuestionsOfExamAdmin(@PathVariable("qid") Long qid) {
		Exam exam = new Exam();
		exam.setExId(qid);
		Set<Question> questionsOfExam = this.service.getQuestionsOfExam(exam);
		return ResponseEntity.ok(questionsOfExam);

	}
	
	
	
	
	

	// delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		this.service.deleteQuestion(quesId);
	}
}
