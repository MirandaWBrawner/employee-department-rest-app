package cogent.tutorial.dao;

import java.util.List;
import cogent.tutorial.model.Department;

public interface DepartmentDao {
	List<Department> selectAll();
	Department selectById(int id);
	void add(Department dept);
	void update(Department dept);
	void delete(Department dept);
}
