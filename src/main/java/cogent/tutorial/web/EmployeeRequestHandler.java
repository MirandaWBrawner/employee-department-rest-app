package cogent.tutorial.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cogent.tutorial.model.Department;
import cogent.tutorial.model.Employee;
import cogent.tutorial.services.DepartmentService;
import cogent.tutorial.services.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRequestHandler {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping(path = "/getById", produces = "application/json")
	public Object getEmployeeById(@RequestParam("id") int id) {
		Employee employee = employeeService.selectById(id);
		if (employee == null) {
			return "No employee found.";
		} else {
			return employee;
		}
	}
	
	@GetMapping(path = "/getList", produces = "application/json")
	public List<Employee> getEmployeeList() {
		return employeeService.selectAll();
	}
	
	@GetMapping(path = "/getPage", produces = "application/json")
	public Page<Employee> getEmployeePage(
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize,
			@RequestParam("sortBy") String sortBy) {
		return employeeService.findPaginated(pageNumber, pageSize, sortBy);
	}
	
	@GetMapping(path = "/getByDept", produces = "application/json")
	public List<Employee> getEmployeesByDept(int deptId) {
		return employeeService.selectByDeptId(deptId);
	}
	
	@PostMapping(path = "/add", produces = "text/html")
	public String addEmployee(@RequestBody Employee employee) {
		try {
			int deptId = employee.getDeptId();
			Department dept = deptService.selectById(deptId);
			employee.setDept(dept);
			employeeService.add(employee);
			return "Employee added.";
		} catch (Throwable t) {
			System.out.println("There was a problem with the post request.");
			t.printStackTrace();
			return "The employee could not be added.";
		}
	}
	
	@PutMapping(path = "/update", produces = "text/html")
	public String updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.update(employee);
			return "Employee updated.";
		} catch (Throwable t) {
			return "The employee could not be updated.";
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "text/html")
	public String deleteEmployee(@RequestBody int id) {
		try {
			employeeService.deleteById(id);
			return "Employee deleted";
		} catch (Throwable t) {
			return "The employee could not be deleted.";
		}
	}
}
