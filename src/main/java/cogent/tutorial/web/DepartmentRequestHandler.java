package cogent.tutorial.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cogent.tutorial.model.Department;
import cogent.tutorial.services.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentRequestHandler {
	
	@Autowired
	DepartmentService deptServ;

	@GetMapping(path = "/getById", produces = "application/json")
	public Object getDepartmentById(@RequestParam("id") int id) {
		Department dept = deptServ.selectById(id);
		if (dept == null) {
			return "No department found.";
		} else {
			return dept;
		}
	}
	
	@GetMapping(path = "/getList", produces = "application/json")
	public Object getDepartmentList() {
		return deptServ.selectAll();
	}
	
	@PostMapping(path = "/add", produces = "application/json")
	public String addDept(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("office") String office,
			@RequestParam("meetingTime") String meetingTime) {
		Department dept = new Department(id, name, office, meetingTime);
		try {
			deptServ.add(dept);
			return "Department added.";
		} catch (Throwable t) {
			return "The department could not be added.";
		}
	}
	
	@PutMapping(path = "/update", produces = "application/json")
	public String updateDept(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("office") String office,
			@RequestParam("meetingTime") String meetingTime) {
		Department dept = new Department(id, name, office, meetingTime);
		try {
			deptServ.update(dept);
			return "Department updated.";
		} catch (Throwable t) {
			return "The department could not be updated.";
		}
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public String deleteDept(@RequestParam("id") int id) {
		try {
			deptServ.deleteById(id);
			return "Department deleted";
		} catch (Throwable t) {
			return "The department could not be deleted.";
		}
	}
}
