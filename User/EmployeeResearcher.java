package User;

public class EmployeeResearcher extends ResearcherDecorator {
	private Employee employee;
    public EmployeeResearcher(Employee employee,Researchable researcher) {
        super(researcher);
        this.employee=employee;
    }
    
}
