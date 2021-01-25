package cogent.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cogent.tutorial.model.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
	
}
