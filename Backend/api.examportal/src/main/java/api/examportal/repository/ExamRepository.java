package api.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.exam.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	public List<Exam> findByActive(Boolean b);
}
