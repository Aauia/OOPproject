package Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import Education.*;
import User.*;

public class Tester {
    public static void main(String[] args) {
    	Data data = Data.INSTANCE;
    	
    	Course p1 = new Course("CS201", "PP1", Access_Course.MAJOR, 3, 100, null,null,2,2);
    	Vector<Course> pre = new Vector<>();
    	pre.add(p1);
        Course p2 = new Course("CS202", "PP2", Access_Course.MAJOR, 4, 80, pre, null,2,1);
        Curriculum site2 = new Curriculum(Specialties.CS_SE, Faculties.SITE, Map.of(1, Arrays.asList(p1)));
        site2.addCoursesForSemester(2, Arrays.asList(p2));
        
        Student s4 = new Student("s4", "p4", "Aizere", "Nuraly", "Middle", 
                LocalDate.of(1999, 9, 15), Gender.MALE, "British", 
                987654321, "s4@example.com", FamilyStatuses.SINGLE, 
                "bob.williams@university.edu", 3, null, 
                null,null, Faculties.SITE, "S20890", null, 
                new HashMap<>(), true, new Schedule("S20890",null), 1, Specialties.CS_SE, new Transcript("S67890"),site2);
        Teacher teacher4 = new Teacher("T4", "p4", "Dr.Pakita", "Pakizar", "M", LocalDate.of(1980, 5, 15),
                Gender.FEMALE, "American", 123456789, "dr.smith@example.com", FamilyStatuses.MARRIED,
                "dr.smith@university.edu", 50000, "10 years", TeacherTypes.PROFESSOR, "T1002", true);
        Request request = new Request(0, null, null, null, null, null);
        
        
      
        
    
      
        try {
            (new Managing()).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
