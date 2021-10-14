package api.examportal.service;

import java.util.Set;

import api.examportal.model.exam.Exam;
import api.examportal.model.exam.Question;
import api.examportal.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(Long questionId);

	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public Set<Question> getQuestionsOfExam(Exam exam);

	public void deleteQuestion(Long quesId);
}
