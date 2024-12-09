package User;

package OOp1;

import java.util.Set;

import Education.Course;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Observable;

//import javax.swing.JTable;

public class Manager extends Employee implements Subject {

    private ManagerTypes managerType;
    private String managerId;
    private Set<Course> courses;

    public Manager(String login, String password, String name, String surname, String middleName, 
                   LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                   FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
                   ManagerTypes managerType, String manager,boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email,
              familyStatus, corporateEmail, salary, timeOfExperience,isResearcher);
        this.managerType = managerType;
        this.managerId = managerId;
        this.courses = new HashSet<>();
        if (isResearcher) {
            this.setAsResearcher(true);
        }
    }

    // Getters and setters
   
    // Methods
    public boolean approveStudentsRegistration() {
        // TODO: Implement approval logic
        return true; // Example return value
    }

    public ManagerTypes getManagerType() {
		return managerType;
	}

	public void setManagerType(ManagerTypes managerType) {
		this.managerType = managerType;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public JTable viewStudentInfo() {
        // TODO: Implement logic to view student info
        return new JTable(); // Example placeholder
    }

    public JTable viewRequests() {
        // TODO: Implement logic to view requests
        return new JTable(); // Example placeholder
    }

    public boolean approveOrNotComplaint() {
        // TODO: Implement complaint approval logic
        return true; // Example return value
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

