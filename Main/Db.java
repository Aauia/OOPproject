package Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Education.*;
import User.*;

public class Db {

    protected Vector<Student> students;
    protected Vector<Employee> employees;
    protected Vector<Dean> deans;
    protected Vector<Teacher> teachers;  
    protected Vector<Manager> managers;
    public Vector<Course> courses;        
    protected Vector<Lesson> lessons;
    private Vector<Curriculum> rup;
    private Vector<String> specialty;
    protected Vector<Admin> admins;
    protected Vector<News> newsList;
    protected Vector<Librarian> librarians;; 
    private Vector<Book> books;
    private Vector<Journal> journals;
    protected Vector<Complaint> complaints;
    protected Vector<Request> requests;
    protected Vector<Researcher> researchers;
    protected Vector<ResearchPaper> researchPapers;
    protected Vector<ResearchProject> researchProjects;

    private Db() {
   	 deans = new Vector<>();
       students = new Vector<>();
       teachers = new Vector<>();
       managers= new Vector<>();
       courses = new Vector<>();
       lessons = new Vector<>();
       specialty = new Vector<>();
       admins = new Vector<>();
       rup = new Vector<>();
       newsList = new Vector<>();
       librarians = new Vector<>();
       books = new Vector<>();
       journals = new Vector<>();
   	complaints=new Vector<>();
       requests = new Vector<>();
       researchPapers= new Vector<>();
       researchProjects= new Vector<>();
       researchers=new Vector<>();
       

    
    admins.add(new Admin("admin1", "password123", "John", "Doe", "Middle", 
            LocalDate.of(1980, 5, 15), Gender.MALE, "American", 
            1234567890, "admin1@example.com", FamilyStatuses.SINGLE, 
            "jdoe@university.edu", 5000.0, "10 years", "AdminHead", false));
    admins.add(new Admin("admin2", "pass456", "Jane", "Smith", "Middle", 
            LocalDate.of(1990, 3, 20), Gender.FEMALE, "British", 
            987654321, "admin2@example.com", FamilyStatuses.MARRIED, 
            "jsmith@university.edu", 4500.0, "5 years", "AdminAssistant", false));

    /*Course c1 = new Course("CS101", "Introduction to Computer Science", Access_Course.MAJOR, 3, 100, null,null,2,2);
    Course c2 = new Course("MATH101", "Calculus I", Access_Course.MAJOR, 4, 80, null, null,2,1);
    Curriculum site1 = new Curriculum(Specialties.CS_SE, Faculties.SITE, Map.of(1, Arrays.asList(c1,c2)));
    Vector<String> co1 = new Vector<>();
    co1.add(c2.getCourseCode());
    Course c3 = new Course("CS102", "Data Structures", Access_Course.MAJOR, 3, 100, null, null,2,2);
    Course c4 = new Course("MATH102", "Calculus II", Access_Course.MAJOR, 4, 80, null, null,2,2);
    Course c5 = new Course("CS1021", "Data StructuresII", Access_Course.MAJOR, 3, 100, null, null,2,2);*/

   
    


    students.add(new Student("student2", "password2", "Bob", "Williams", "Middle", 
            LocalDate.of(1999, 9, 15), Gender.MALE, "British", 
            987654321, "student2@example.com", FamilyStatuses.MARRIED, 
            "bob.williams@university.edu", 3, null, 
            null,null, Faculties.SITE, "S67890", null, 
            new HashMap<>(), true, new Schedule("S67890",null), 1, Specialties.CS_SE, new Transcript("S67890"),null));
    students.add(new Student("student3", "password3", "Robert", "Williams", "Middle", 
            LocalDate.of(1999, 9, 15), Gender.MALE, "British", 
            987654321, "student2@example.com", FamilyStatuses.MARRIED, 
            "bob.williams@university.edu", 3, null, 
            null,null, Faculties.SITE, "S67888", null, 
            new HashMap<>(), true, new Schedule("S67890",null), 1, Specialties.CS_SE, new Transcript("S67888"),null));
    Teacher teacher1 = new Teacher("T123", "password123", "Dr. Smith", "John", "M", LocalDate.of(1980, 5, 15),
            Gender.MALE, "American", 123456789, "dr.smith@example.com", FamilyStatuses.SINGLE,
            "dr.smith@university.edu", 50000, "10 years", TeacherTypes.PROFESSOR, "T1001", true);





    // Add Teacher to List
    teachers.add(teacher1);
    Teacher teacher2 = new Teacher("T124", "password456", "Dr. Johnson", "Emily", "F", LocalDate.of(1975, 8, 22),
            Gender.FEMALE, "Canadian", 987654321, "dr.johnson@example.com", FamilyStatuses.MARRIED,
            "dr.johnson@university.edu", 55000, "15 years", TeacherTypes.PROFESSOR, "T1002", true);
    Teacher teacher3 = new Teacher("T125", "password567", "Dr. Johnson", "Emily", "F", LocalDate.of(1975, 8, 22),
            Gender.FEMALE, "Canadian", 987654321, "dr.johnson@example.com", FamilyStatuses.MARRIED,
            "dr.johnson@university.edu", 55000, "15 years", TeacherTypes.PROFESSOR, "T1002", true);
    
    
	 teachers.add(teacher3);

	Lesson lesson1 = new Lesson("L1", "T123", null, LessonType.LECTURE, 101, "10:00 AM - 12:00 PM", "Monday", 80);
	Lesson lesson2 = new Lesson("L2", "T124", null, LessonType.LECTURE, 102, "1:00 PM - 3:00 PM", "Wednesday", 80);

	lessons.add(lesson1);
	lessons.add(lesson2);


 
    librarians.add(new Librarian(
    	    "librarian01",              // Login
    	    "securePassword",           // Password
    	    "Marat",                    // First Name
    	    "Bystrov",                  // Surname
    	    "Axmetov",                  // Middle Name
    	    LocalDate.of(1985, 5, 20),  // Date of Birth
    	    Gender.MALE,                // Gender
    	    "American",                 // Nationality
    	    1234567890,                 // Phone Number
    	    "marat.bystrov@example.com",// Email
    	    FamilyStatuses.MARRIED,     // Family Status
    	    "marat.bystrov@library.com",// Corporate Email
    	    50000.0,                    // Salary
    	    "3 years",                  // Time of Experience
    	    true                        // Is Researcher
    	));
    deans.add(
    	    new Dean(
    	        "dean01",                   // Login
    	        "securePassword",           // Password
    	        "Nursultan",                // First Name
    	        "Nazarbayev",               // Surname
    	        "Amanzholovich",            // Middle Name
    	        LocalDate.of(1975, 4, 15),  // Date of Birth
    	        Gender.MALE,                // Gender
    	        "Kazakh",                   // Nationality
    	        9876,                 // Phone Number
    	        "nursultan.n@example.com",  // Email
    	        FamilyStatuses.MARRIED,     // Family Status
    	        "nursultan.n@university.com", // Corporate Email
    	        75000.0,                    // Salary
    	        "10 years",                 // Time of Experience
    	        true                        // Is Researcher
    	    ));
    }
    


    

 }

