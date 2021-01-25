package cogent.tutorial.services;

import java.util.List;

import cogent.tutorial.model.Department;

public interface DepartmentService {
	List<Department> selectAll();
	Department selectById(int id);
	void add(Department dept);
	void update(Department dept);
	void delete(Department dept);
	void deleteById(int id);
}
