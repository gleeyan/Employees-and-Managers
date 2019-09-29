package com.codingdojo.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.employees.models.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	
	List<Employee> findAll();
	
	@Query("SELECT e from Employee e WHERE firstName = ?1 AND lastName = ?2")
	Employee findByName(String fn, String ln);
}
