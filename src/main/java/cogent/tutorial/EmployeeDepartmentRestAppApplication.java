package cogent.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import cogent.tutorial.model.Department;
import cogent.tutorial.services.DepartmentService;

@SpringBootApplication
public class EmployeeDepartmentRestAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeDepartmentRestAppApplication.class, args);
		
		/*
		DepartmentService service = context.getBean(DepartmentService.class);
		
		System.out.println("\nTesting selectAll:");
		service.selectAll().forEach(d -> System.out.println(d.getName()));
		System.out.println();
		
		System.out.println("Testing selectById:");
		System.out.println(service.selectById(1) + "\n");
		
		Department dept = new Department();
		
		/*
		System.out.println("Testing add:");
		Department dept = new Department();
		dept.setId(0);
		dept.setName("Accounting");
		dept.setOffice("75 Main Street, Office 325");
		dept.setMeetingTime("12:00 Noon Wednesdays");
		service.add(dept);
		service.selectAll().forEach(d -> System.out.println(d));
		System.out.println();
		*/
		
		/*
		System.out.println("Testing update:");
		dept = service.selectById(0);
		dept.setMeetingTime("12:00 Noon Fridays");
		service.update(dept);
		service.selectAll().forEach(d -> System.out.println(d));
		System.out.println();
		*/
		/*
		System.out.println("Testing delete:");
		service.deleteById(0);
		service.selectAll().forEach(d -> System.out.println(d));
		System.out.println();
		
		*/
	}

}
