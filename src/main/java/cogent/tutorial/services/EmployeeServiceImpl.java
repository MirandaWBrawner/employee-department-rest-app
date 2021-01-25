package cogent.tutorial.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cogent.tutorial.dao.DepartmentDao;
import cogent.tutorial.dao.EmployeeDao;
import cogent.tutorial.dao.EmployeeJpaRepository;
import cogent.tutorial.model.Department;
import cogent.tutorial.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao edao;
	
	@Autowired
	EmployeeJpaRepository employeeJpa;

	@Autowired
	DepartmentDao ddao;

	@Override
	public List<Employee> selectAll() {
		return edao.selectAll();
	}

	@Override
	public Employee selectById(int id) {
		return edao.selectById(id);
	}

	@Override
	public List<Employee> selectByDept(Department dept) {
		return edao.selectByDept(dept);
	}
	
	@Override
	public List<Employee> selectByDeptId(int id) {
		Department dept = ddao.selectById(id);
		if (dept != null) {
			return edao.selectByDept(dept);
		} else return new ArrayList<>();
	}

	@Override
	@Transactional
	public void add(Employee employee) {
		edao.add(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		edao.update(employee);

	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		edao.delete(employee);

	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		Employee employee = edao.selectById(id);
		if (employee != null) {
			edao.delete(employee);
		}
	}
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortBy) {
		Sort sort = Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return employeeJpa.findAll(pageable);
	}

}
