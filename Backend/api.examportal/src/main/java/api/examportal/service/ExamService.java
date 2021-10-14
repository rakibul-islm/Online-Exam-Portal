package api.examportal.service;

import java.util.List;
import java.util.Set;

import api.examportal.model.exam.Exam;

public interface ExamService {
	
	public Exam addExam(Exam exam);

	public Exam updateExam(Exam exam);

	public Set<Exam> getExams();

	public Exam getExam(Long examId);

	public void deleteExam(Long examId);


	public List<Exam> getActiveExams();

}
