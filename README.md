# dynmaic-filtering-restful-web-service

Development process:
1. We need to the method setFilters of MappingJacksonValue
2. Create simple filters by using the method addfilter() of the class simpleBeanProvider
3. Create the simple bean property filter using the filterOutAllExcept of the SimpleBeanPropertyFilter class
4. Add the Annoation JsonFilter to the bean class

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

@JsonFilter("employeefieldfilter")
public class Employee {
