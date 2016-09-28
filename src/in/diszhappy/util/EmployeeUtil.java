package in.diszhappy.util;

import java.util.ArrayList;
import java.util.List;

import in.diszhappy.pojo.Employee;

/**
 * 
 * @author Saumm Wednesday 28 09 2016
 *
 *
 */
public class EmployeeUtil {
	private List<Employee> employeeList;
	
	public List<Employee> listEmployess(){
		if(employeeList == null){
			employeeList = new ArrayList<>();
		}
		Employee employee = null;
		for(int counter = 1; counter < 6; counter++){
			employee = new Employee("employee"+counter, counter, "department"+counter, "Emlpoyee Mail"+counter);
			employeeList.add(employee);
		}
		return employeeList;
	}

}
