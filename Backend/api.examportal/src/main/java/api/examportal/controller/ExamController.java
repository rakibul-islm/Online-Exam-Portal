package api.examportal.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

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
import api.examportal.service.ExamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	// add exam service
		@PostMapping("/")
		public ResponseEntity<Exam> add(@RequestBody Exam exam) {
		
			return ResponseEntity.ok(this.examService.addExam(exam));
		}

		// update exam

		@PutMapping("/")
		public ResponseEntity<Exam> update(@RequestBody Exam exam) {
			return ResponseEntity.ok(this.examService.updateExam(exam));
		}

		// get exam
		@GetMapping("/")
		public ResponseEntity<?> exams() {
			return ResponseEntity.ok(this.examService.getExams());
		}

		// get single exam
		@GetMapping("/{qid}")
		public Exam exam(@PathVariable("qid") Long qid) {
			
			return this.examService.getExam(qid);
		}

		// delete the exam
		@DeleteMapping("/{qid}")
		public void delete(@PathVariable("qid") Long qid) {
			this.examService.deleteExam(qid);
		}

		

		// get active exams
		@GetMapping("/active")
		public List<Exam> getActiveExams() {
			return this.examService.getActiveExams();
		}

		

}
