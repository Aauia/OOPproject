package User;

public class EmployeeResearcher extends ResearcherDecorator {
	private Employee employee;
    public EmployeeResearcher(Employee employee,EmployeeResearcher researcher) {
        super(researcher);
        this.employee=employee;
    }
    
}