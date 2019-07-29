package com.codesby.rest.webservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class EmployeeController {
	
	@GetMapping("fieldFiltering")
	public MappingJacksonValue showEmployee() {
		Employee employee = new Employee("Thomas", "Schmidt", 23, "thomas.schmidt@gmail.com");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("age", "email");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("employeefieldfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(employee);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("fieldFilteringVersion2")
	public MappingJacksonValue showAllEmployee(){
		List<Employee> list = Arrays.asList(new Employee("Thomas", "Schmidt", 23, "thomas.schmidt@gmail.com"), 
				new Employee("Jack", "Parker", 45, "jack.parker@gmail.com"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("employeefieldfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
