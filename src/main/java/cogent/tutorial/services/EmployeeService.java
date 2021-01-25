package cogent.tutorial.services;

import java.util.List;

import org.springframework.data.domain.Page;

import cogent.tutorial.model.Department;
import cogent.tutorial.model.Employee;

public interface EmployeeService {
	List<Employee> selectAll();
	Employee selectById(int id);
	List<Employee> selectByDept(Department dept);
	List<Employee> selectByDeptId(int id);
	void add(Employee employee);
	void update(Employee employee);
	void delete(Employee employee);
	void deleteById(int id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortBy);
}
