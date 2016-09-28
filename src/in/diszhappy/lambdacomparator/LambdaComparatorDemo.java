package in.diszhappy.lambdacomparator;

import java.util.Comparator;
import java.util.List;

import in.diszhappy.pojo.Employee;
import in.diszhappy.util.EmployeeUtil;

/**
 * 
 * @author Saumm Wednesday 21 09 2016
 *
 *
 */
public class LambdaComparatorDemo {
	static EmployeeUtil employeeUtil = new EmployeeUtil();
	public static void main(String[] args) {
		List<Employee> employeeLists = employeeUtil.listEmployess();
		employeeLists.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
		employeeLists.forEach(System.out::println);
		System.out.println("------------------------------------------------------------"+"\n\t\tNow by descending\n"+"-------------------------------------------------------");
		employeeLists.sort((o1, o2)->o2.getName().compareTo(o1.getName()));
		employeeLists.forEach(System.out::println);
	}
}
