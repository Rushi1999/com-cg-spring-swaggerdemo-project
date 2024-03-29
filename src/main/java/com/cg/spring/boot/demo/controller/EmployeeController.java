package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

//@Component
@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;

	// http://localhost:8082/getallemps           //------->URL
	@GetMapping("/getallemps")                    //-------> API
	public List<Employee> getAllEmps() {
		LOG.info("getAllEmps"); // in normal block
		LOG.warn("getAllEmps"); // in normal or exception block
		LOG.error("getAllEmps"); // in exception block
//		LOG.debug("getAllEmps"); // in debug mode 
		return empService.getAllEmployees();
	}

//	// returns only employee object (body)
//	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int eid) {
//		System.out.println("Controller getEmpById");
//		return empService.getEmployeeById(eid);
//	}

////	// returns responseentity object including employee object (body)
//	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
//		return response;
//	}

// returns responseentity object including employee object (body)
	
 /* // http://localhost:8082/getempbyid/101
	//exception
	@GetMapping("/getempbyid/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmpById");
		Employee emp = empService.getEmployeeById(eid);
		HttpHeaders headers = new HttpHeaders();
		if (null != emp) {
			headers.add("message", "This employee is available in the database.");
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			return response;
		}
		else {
			headers.add("message", "This employee is NOT available in the database.");
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.NOT_FOUND);
			return response;			
		}

	}
	*/
	
	// exception on eid
	
	// returns responseentity object including employee object (body) and (header)
		// http://localhost:8082/getempbyid/101
		@GetMapping("/getempbyid/{eid}")
		public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
			LOG.info("getEmpById");
			Employee emp = empService.getEmployeeById(eid); // line 
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This employee is available in the database.");
			LOG.info(headers.toString());
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			return response;
		}
	// http://localhost:8082/addemp
	@PostMapping("/addemp")
		public ResponseEntity<Employee> addemp(@RequestBody Employee employee) {
			LOG.info("/addemp");
			Employee emp = empService.addEmployee(employee); // line 
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "employee data added sucessefully");
			LOG.info(headers.toString());
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			return response;
		}
	// http://localhost:8082/updateemp
	@PutMapping("/updateemp")
		public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
			LOG.info("/updateemp");
			Employee emp = empService.updateEmployee(employee); // line 
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "employee data Update sucessefully");
			LOG.info(headers.toString());
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			return response;
		}
	@DeleteMapping("/deleteempbyid/{eid}")
	public ResponseEntity<Employee> deleteEmpById(@PathVariable int eid) {
	LOG.info("deleteEmpById");
	int emp = empService.deleteEmployeeById(eid); // line 
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This employee deleted sucessefully");
	LOG.info(headers.toString());
	ResponseEntity<Employee> response = new ResponseEntity<Employee>(headers, HttpStatus.OK);
	return response;
  }
}

//@RestController
//public class EmployeeController {
//
//	@GetMapping("/getemp")
//	public Employee getEmployee() {
//		System.out.println("getEmployee");
//		return new Employee(101, "Sonu", 10.5);
//	}
//
//	@GetMapping("/getallemp")
//	public List<Employee> getAllEmployees() {
//		System.out.println("getAllEmployees");
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//		return empList;
//	}
//
////	@RequestMapping("/rrrrr")
////	@GetMapping("/ggggg")
////	@PostMapping("/aaaa")
////	@PutMapping("/ppp")
////	@DeleteMapping("/ddddd")
//
//}
