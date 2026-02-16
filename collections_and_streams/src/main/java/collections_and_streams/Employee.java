package collections_and_streams;

public class Employee {
		private int employeeId;
		private String name;
		private int departmentNo;
		private String departmentName;
		private String job;
		private double salary;
		private int yearsOfExperience;
		
		
		public Employee() {
			super();
			
		}

		public Employee(Integer employeeId, String name, int departmentNo, String departmentName, String job, double salary,
				int yearsOfExperience) {
			super();
			this.employeeId = employeeId;
			this.name = name;
			this.departmentNo = departmentNo;
			this.departmentName = departmentName;
			this.job = job;
			this.salary = salary;
			this.yearsOfExperience = yearsOfExperience;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDepartmentNo() {
			return departmentNo;
		}

		public void setDepartmentNo(int departmentNo) {
			this.departmentNo = departmentNo;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		
		public String getJob() {
			return job;
		}
		
		public void setJob(String job) {
			this.job = job;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public int getYearsOfExperience() {
			return yearsOfExperience;
		}

		public void setYearsOfExperience(int yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}

		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentNo=" + departmentNo
					+ ", departmentName=" + departmentName + ", job=" + job + ", salary=" + salary + ", yearsOfExperience="
					+ yearsOfExperience + "]";
		}
		
		
		
}
