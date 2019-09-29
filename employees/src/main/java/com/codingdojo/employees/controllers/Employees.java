package com.codingdojo.employees.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.employees.models.Employee;
import com.codingdojo.employees.services.EmployeeService;

@Controller
public class Employees {
	
	private final EmployeeService es;
	public Employees(EmployeeService es) {
		this.es = es;
	}
	
	@RequestMapping("/")
	public void index() {
		Employee e1 = es.findByName("Dylan", "Arb");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(es.findByName("Maggie", "May"));
		employees.add(es.findByName("Torpedo", "Burrito"));
		e1.setEmployees(employees);
		es.findByName("Maggie", "May").setManager(e1);
		es.findByName("Torpedo", "Burrito").setManager(e1);
		for(Employee e : e1.getEmployees()) {
			System.out.println("Employee: " + e.getFirstName() + " " + e.getLastName());
		}
		System.out.println("Manager: " + es.findByName("Maggie", "May").getManager().getFirstName());
	}
}
