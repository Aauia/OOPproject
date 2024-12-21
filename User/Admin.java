package User;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;

public class Admin extends Employee {

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
