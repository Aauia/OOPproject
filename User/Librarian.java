package User;

import java.time.LocalDate;
import java.util.HashMap;

public class Librarian extends Employee {
    private static final long serialVersionUID = 1L;
    public Librarian(String login, String password, String name, String surname, String middleName,
                     LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                     FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
                     boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email, familyStatus,
                corporateEmail, salary, timeOfExperience, isResearcher);
        new HashMap<>();
    }

   
}