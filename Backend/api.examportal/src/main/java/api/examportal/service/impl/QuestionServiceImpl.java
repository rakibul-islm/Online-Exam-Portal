package api.examportal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.examportal.model.exam.Exam;
import api.examportal.model.exam.Question;
import api.examportal.model.exam.Quiz;
import api.examportal.repository.QuestionRepository;
import api.examportal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}
	
	
	@Override
	public void deleteQuestion(Long quesId) {
		Question question = new Question();
		question.setQuesId(quesId);
		this.questionRepository.delete(question);
	}

	@Override
	public Set<Question> getQuestionsOfExam(Exam exam) {
		return this.questionRepository.findByExam(exam);
	}

}
