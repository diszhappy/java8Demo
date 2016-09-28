package in.diszhappy.pojo;
/**
 * 
 * @author Saumm Wednesday 21 09 2016
 *
 *
 */
public class Employee {
	
	private String name;
	private long empId;
	private String department;
	private String emailId;
	/**
	 * Creates a new employee with all details
	 * @param name
	 * @param empId
	 * @param department
	 * @param emailId
	 */
	public Employee(String name, long empId, String department, String emailId) {
		super();
		this.name = name;
		this.empId = empId;
		this.department = department;
		this.emailId = emailId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", department=" + department + ", emailId=" + emailId
				+ "]";
	}
	
}
