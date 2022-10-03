package controller;

import java.sql.Connection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.bean.Employee;
import com.accenture.connection.ConnectionFactory;

import Entity.EmployeeCRUD;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	//static final Connection conn = new ConnectionFactory().connect();
	
	@GetMapping(path= "/employee")
	public Employee getEmployee()
	{
		Employee employee = new Employee();
		
		
		//new EmployeeCRUD().select(conn);
		new EmployeeCRUD().select(new ConnectionFactory().connect());
		
		return employee;		
		
	}
	
	@PostMapping("/employee")
	public long setEmployee(@RequestBody Employee newEmployee)
	{
		
		//return new EmployeeCRUD().insert(newEmployee, conn);		
		return new EmployeeCRUD().insert(newEmployee, new ConnectionFactory().connect());	
	
	}
	
	@GetMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable Long id)
	{
		
		Employee employee = new Employee();
		
		ConnectionFactory connection = new ConnectionFactory();
		
		return employee;
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee putEmployee(@PathVariable Long id)
	{
		
		Employee employee = new Employee();
		
		ConnectionFactory connection = new ConnectionFactory();
		
		return employee;
		
	}
	
	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable Long id)
	{
		
		Employee employee = new Employee();
		
		ConnectionFactory connection = new ConnectionFactory();
		
		return employee;
		
	}
	
}
