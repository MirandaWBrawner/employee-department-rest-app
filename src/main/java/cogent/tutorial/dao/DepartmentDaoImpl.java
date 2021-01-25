package cogent.tutorial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cogent.tutorial.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	DataSource dataSource;
	
	/* @PostConstruct
	void init() {
		setDataSource(dataSource);
	} */
	
	@PersistenceContext(name = "data")
	EntityManager em;

	@Override
	public List<Department> selectAll() {
		TypedQuery<Department> query = em.createQuery(
				"SELECT d FROM Department d", Department.class);
		return query.getResultList();
	}

	@Override
	public Department selectById(int id) {
		return em.find(Department.class, id);
	}

	@Override
	@Transactional
	public void add(Department dept) {
		em.persist(dept);
	}

	@Override
	@Transactional
	public void update(Department dept) {
		em.merge(dept);
	}

	@Override
	public void delete(Department dept) {
		em.remove(dept);

	}

}
