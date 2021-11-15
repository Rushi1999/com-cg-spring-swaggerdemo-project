package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;
import com.cg.spring.boot.demo.exception.EmployeeNotFound;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		System.out.println("Service getAllEmployees");
		return empRepository.findAll();
	}
	
	/* public Employee addEmployee(Employee employee) {
		System.out.println("Service addEmployee");
		if (!empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		System.out.println(employee.getEid() + " already exists.");
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		System.out.println("Service updateEmployee");
		if (empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		System.out.println(employee.getEid() + " does not exist.");
		return null;
	}

	public int deleteEmployeeById(int eid) {
		System.out.println("Service deleteEmployeeById");
		if (empRepository.existsById(eid)) {
			empRepository.deleteById(eid);
			return eid;
		}
		System.out.println(eid + " does not exist.");
		return 0;
	}
	*/

//	public Employee getEmployeeById(int eid) {
//		System.out.println("Service getEmployeeById");
//		return empRepository.findById(eid).get();
//	}
	
	// handdle using ifelse 
	
//	public Employee getEmployeeById(int eid) {
//		Optional<Employee> empOpt = empRepository.findById(eid);
//		if (!empOpt.isEmpty())
//			return empOpt.get();
//		return null;
//	}
	
	
	
//exception handle 
	public Employee getEmployeeById(int eid) {
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent())
			return empOpt.get();
		else
			throw new EmployeeNotFound(eid + " this employee is not found.");
	}
	
	public Employee addEmployee(Employee employee) {
		System.out.println("Service addEmployee");
		if (!empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		else 
			throw new EmployeeNotFound (employee.getEid() + " already exists.");

	}

	public Employee updateEmployee(Employee employee) {
		System.out.println("Service updateEmployee");
		if (empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		else
			throw new EmployeeNotFound(employee + " this employee is not found.");
	}

	public int deleteEmployeeById(int eid) {
		System.out.println("Service deleteEmployeeById");
		if (empRepository.existsById(eid)) {
			empRepository.deleteById(eid);
			return eid;
		}
		else 
		{
			
			throw new EmployeeNotFound(eid + " this employee is not found.");		
	    }
   }
}

////@Component
//
//@Service
//public class EmployeeService {
//
//	private List<Employee> empList = new ArrayList<>();
//
//	{
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//	}
//
//	public List<Employee> getAllEmployees() {
//		System.out.println("Service getAllEmployees");
//		return empList;
//	}
//
//	public Employee getEmployeeById(int eid) {
//		System.out.println("Service getEmployeeById");
//		return empList.stream().filter(e -> eid == e.getEid()).findAny().orElse(null);
//	}
//
//	public Employee addEmployee(Employee employee) {
//		empList.add(employee);
//		return employee;
//	}
//
//}
