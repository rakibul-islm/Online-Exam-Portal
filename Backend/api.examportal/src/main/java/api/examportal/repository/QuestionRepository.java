package api.examportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.exam.Exam;
import api.examportal.model.exam.Question;
import api.examportal.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);
	
	Set<Question> findByExam(Exam exam);
}
