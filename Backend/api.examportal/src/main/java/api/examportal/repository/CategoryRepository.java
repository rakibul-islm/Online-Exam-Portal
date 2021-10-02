package api.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.exam.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
