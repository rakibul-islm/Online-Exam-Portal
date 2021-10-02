package api.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.examportal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
