package User;

import java.time.LocalDate;

public class Admin extends Employee {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin(String login, String password, String name, String surname, String middleName, 
                 LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                 FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
                 String adminAttribute,boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email,
              familyStatus, corporateEmail, salary, timeOfExperience,isResearcher);
        if (isResearcher) {
            this.setAsResearcher(true);
        }
    }

}