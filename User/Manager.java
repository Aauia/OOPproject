package User;

import java.util.Vector;
import java.util.Set;

import Education.Complaint;
import Education.Course;
import Education.Request;
import Education.ResearchPaper;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Manager extends Employee implements Subject {

    private ManagerTypes managerType;
    private String managerId;

    public Manager(String login, String password, String name, String surname, String middleName,
                   LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                   FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
                   ManagerTypes managerType, String manager, boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email,
              familyStatus, corporateEmail, salary, timeOfExperience, isResearcher);
        this.managerType = managerType;
        this.managerId = manager;
        if (isResearcher) {
            this.setAsResearcher(true);
        }
    }

    // Getters and setters
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
    
    public boolean approveStudentsRegistration() {
        // TODO: Implement approval logic
        return true;
    }

    public boolean approveComplaint() {
        // TODO: Implement complaint approval logic
        return true;
    }
    public boolean disapproveComplaint() {
        // TODO: Implement complaint approval logic
        return true;
    }

	@Override
	public void subscribe(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribe(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publish(ResearchPaper paper) {
		// TODO Auto-generated method stub
		
	}
}

//	@Override
//	public void notifySubs(String news, List<UserType> targetGroups) {
//		// TODO Auto-generated method stub
//		
//	