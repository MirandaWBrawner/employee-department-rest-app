package cogent.tutorial.dao;

import java.util.List;

import cogent.tutorial.model.Department;
import cogent.tutorial.model.Employee;

public interface EmployeeDao {
	List<Employee> selectAll();
	Employee selectById(int id);
	List<Employee> selectByDept(Department dept);
	void add(Employee employee);
	void update(Employee employee);
	void delete(Employee employee);
}
