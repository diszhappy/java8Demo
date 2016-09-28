package in.diszhappy.javacomparator;

import java.util.Comparator;
import java.util.List;

import in.diszhappy.pojo.Employee;
import in.diszhappy.util.EmployeeUtil;

/**
 * 
 * @author Saumm Wednesday 28 09 2016
 *
 *
 */
public class JavaComparatorDemo {
	static EmployeeUtil employeeUtil = new EmployeeUtil();

	public static void main(String[] args) {
		Comparator<Employee> byName = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Comparator<Employee> byNameDesc = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};
		List<Employee> employeeLists = employeeUtil.listEmployess();
		employeeLists.sort(byName);
		employeeLists.forEach(System.out::println);
		System.out.println("------------------------------------------------------------" + "\n\t\tNow by descending\n"
				+ "-------------------------------------------------------");
		employeeLists.sort(byNameDesc);
		employeeLists.forEach(System.out::println);
	}
}
