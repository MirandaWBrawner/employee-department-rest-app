package cogent.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cogent.tutorial.model.Department;

public interface DepartmentJpaRepository extends JpaRepository<Department, Integer>{
	
}
