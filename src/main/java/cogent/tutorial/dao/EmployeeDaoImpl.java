package cogent.tutorial.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import cogent.tutorial.model.Department;
import cogent.tutorial.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	DataSource dataSource;
	
	@PersistenceContext(name = "data")
	EntityManager em;

	@Override
	public List<Employee> selectAll() {
		TypedQuery<Employee> query = em.createQuery(
				"SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee selectById(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public void add(Employee employee) {
		em.persist(employee);

	}

	@Override
	public void update(Employee employee) {
		em.merge(employee);

	}

	@Override
	public void delete(Employee employee) {
		em.remove(employee);
	}

	@Override
	public List<Employee> selectByDept(Department dept) {
		TypedQuery<Employee> query = em.createQuery(
				"SELECT e FROM Employee e WHERE e.dept = :dept", Employee.class);
		query.setParameter("dept", dept);
		return query.getResultList();
	}

}
