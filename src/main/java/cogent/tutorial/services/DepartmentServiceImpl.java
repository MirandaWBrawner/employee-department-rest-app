package cogent.tutorial.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.tutorial.dao.DepartmentDao;
import cogent.tutorial.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDao dao;

	@Override
	public List<Department> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Department selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public void add(Department dept) {
		dao.add(dept);
	}

	@Override
	public void update(Department dept) {
		dao.update(dept);
	}

	@Override
	@Transactional
	public void delete(Department dept) {
		dao.delete(dept);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Department dept = dao.selectById(id);
		if (dept != null) {
			dao.delete(dept);
		}
	}
	
	

}
