package Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import Education.*;
import User.*;

public class Tester {
    public static void main(String[] args) {
    	Data data = Data.INSTANCE;
        Course c11 = new Course("CSCI1103", "Programming Principles I", Access_Course.MAJOR, 4,  null, null, 2, 2);
        Course c12 = new Course("MATH1102", "Calculus I", Access_Course.MAJOR, 4,  null, null, 2, 1);
        Course c13 = new Course("CSCI1102", "Discrete Structures", Access_Course.MAJOR, 4,  null, null, 2, 1);
        Course c14= new Course("LAN1180", "English ", Access_Course.FREE, 3,  null, null, 0, 0);
       
        

        // Define prerequisites for later courses
        Vector<Course> prereqCSCI1204 = new Vector<>(Arrays.asList(c11));
        Course c21 = new Course("CSCI1204", "Programming Principles II", Access_Course.MAJOR, 4,  prereqCSCI1204, null, 2, 2);
        Vector<Course> prereqMATH1202 = new Vector<>(Arrays.asList(c12));
        Course c22 = new Course("MATH1202", "Calculus II", Access_Course.MAJOR, 4,  prereqMATH1202, null, 2, 2);
        Vector<Course> prereqCSCI1207 = new Vector<>(Arrays.asList(c13));
        Course c23 = new Course("MATH1203", "Linear Algebra for Engineers", Access_Course.MAJOR, 5,  prereqCSCI1207, null, 2, 1);
        Course c24= new Course("FUN1105", "Physics I", Access_Course.MAJOR, 3,  null, null, 2, 1);
        Course c25 = new Course("LAN1280", "English II ", Access_Course.FREE, 4, new Vector<>(Arrays.asList(c14)), null, 0, 0);
        Course c26 = new Course("STAT2201", "Statistics", Access_Course.MAJOR, 3,  new Vector<>(Arrays.asList(c12)), null, 0, 0);

        

        // More courses with prerequisites
        Course c31 = new Course("CSCI2104", "Databases", Access_Course.MAJOR, 3, new Vector<>(Arrays.asList(c26)), null, 2, 1);
        Course c32 = new Course("CSCI2106", "Object-Oriented Programming and Design", Access_Course.MAJOR, 3,  new Vector<>(Arrays.asList(c21)), null, 2, 1);
        Course c33 = new Course("CSCI2105", "Algorithms and Data Structures", Access_Course.MAJOR, 3,  new Vector<>(Arrays.asList(c23)), null, 2, 1);
        Course c34 = new Course("PHE101", "Physical Education I", Access_Course.FREE, 2,  null, null, 2, 1);
        Course c35 = new Course("HIST1101", "History of Kazakhstan", Access_Course.FREE, 4,  null, null, 0, 0);
        
        
        Course c41 = new Course("PHE102", "Physical Education II", Access_Course.FREE, 2,  null, null, 2, 1);
        Course c42 = new Course("CSCI2204", "Operating Systems", Access_Course.MAJOR, 4,  new Vector<>(Arrays.asList(c13)), null, 2, 2);
        Course c43 = new Course("CSCI2206", "Computer Networks", Access_Course.MAJOR, 4,  new Vector<>(Arrays.asList(c12)), null, 2, 2);
        Course c44 = new Course("INFT2205", "Web Development", Access_Course.MAJOR, 4,  new Vector<>(Arrays.asList(c32)), null, 2, 1);



        // Define Curriculum with Semesters
        Curriculum site = new Curriculum(Specialties.IS, Faculties.SITE, Map.of(
                1, Arrays.asList(c11, c12, c13, c14), // First semester courses
                2, Arrays.asList(c21,c22,c23,c24,c25,c26),     // Second semester courses
                3, Arrays.asList(c31,c32,c33,c34,c35),    // Third semester courses
                4, Arrays.asList(c41, c42, c43,c44)  // Fourth semester courses
            ));
        
        Teacher T1 = new Teacher("eng123", "password123", "Dr. Johnson", "Emily", "F", LocalDate.of(1975, 8, 22),
                Gender.FEMALE, "Canadian", 987654321, "dr.johnson@example.com", FamilyStatuses.MARRIED,
                "dr.johnson@university.edu", 55000, "15 years", TeacherTypes.PROFESSOR, "T1002", true);
        Teacher T2 = new Teacher("bio234", "password456", "Dr. Smith", "James", "M", LocalDate.of(1980, 5, 14),
                Gender.MALE, "American", 123456789, "dr.smith@example.com", FamilyStatuses.SINGLE,
                "dr.smith@university.edu", 60000, "12 years", TeacherTypes.PROFESSOR, "T1003", false);

        Teacher T3 = new Teacher("chem345", "chem345", "Dr. Lee", "Sophie", "F", LocalDate.of(1985, 11, 5),
			                Gender.FEMALE, "British", 112233445, "dr.lee@example.com", FamilyStatuses.MARRIED,
			                "dr.lee@university.edu", 65000, "10 years", TeacherTypes.SENIORLECTURER, "T1004", true);
        Teacher T6 = new Teacher("phys666", "password666", "Dr. Watson", "Soora", "F", LocalDate.of(1985, 11, 5),
                Gender.FEMALE, "Mexican", 112233445, "dr.lee@example.com", FamilyStatuses.MARRIED,
                "dr.lee@university.edu", 65000, "10 years", TeacherTypes.SENIORLECTURER, "T1006", true);
        
     // Define lessons for Teacher 1 (Dr. Johnson)
     // Define lessons for Teacher 1 (Dr. Johnson)
        Lesson lesson1 = new Lesson("L1", "T1002", c14, LessonType.LECTURE, 101, "10:00 AM - 12:00 PM", "Monday", 80);  // c14 is for Dr. Johnson
        Lesson lesson2 = new Lesson("L2", "T1002", c25, LessonType.LECTURE, 102, "1:00 PM - 3:00 PM", "Wednesday", 80);  // c25 is for Dr. Johnson
        Lesson lesson9 = new Lesson("L9", "T1002", c25, LessonType.LECTURE, 103, "9:00 AM - 11:00 AM", "Friday", 80);  // c21 is for Dr. Johnson

        // Define lessons for Teacher 2 (Dr. Smith)
        Lesson lesson3 = new Lesson("L3", "T1003", c21, LessonType.LECTURE, 104, "9:00 AM - 11:00 AM", "Monday", 80);  // c21 is for Dr. Smith
        Lesson lesson4 = new Lesson("L4", "T1003", c21, LessonType.LECTURE, 105, "2:00 PM - 4:00 PM", "Wednesday", 80);  // c22 is for Dr. Smith
        Lesson lesson10 = new Lesson("L10", "T1003", c11, LessonType.LECTURE, 106, "11:00 AM - 1:00 PM", "Friday", 80);


        // Define lessons for Teacher 3 (Dr. Lee)
        Lesson lesson5 = new Lesson("L5", "T1004", c12, LessonType.LECTURE, 107, "10:00 AM - 12:00 PM", "Tuesday", 80);  // c12 is for Dr. Lee
        Lesson lesson6 = new Lesson("L6", "T1004", c13, LessonType.LECTURE, 108, "1:00 PM - 3:00 PM", "Thursday", 80);  // c13 is for Dr. Lee
        Lesson lesson11 = new Lesson("L11", "T1004", c22, LessonType.LECTURE, 109, "3:00 PM - 5:00 PM", "Friday", 80);  // c42 is for Dr. Lee
        Lesson lesson13 = new Lesson("L12", "T1004", c26, LessonType.LECTURE, 109, "3:00 PM - 5:00 PM", "Tuesday", 80);  // c42 is for Dr. Lee
        Lesson lesson14 = new Lesson("L13", "T1004", c23, LessonType.LECTURE, 109, "3:00 PM - 5:00 PM", "Saturday", 80);  // c42 is for Dr. Lee


        // Define lessons for Teacher 6 (Dr. Watson)
        Lesson lesson7 = new Lesson("L7", "T1006", c24, LessonType.LECTURE, 110, "9:00 AM - 11:00 AM", "Monday", 80);  // c24 is for Dr. Watson
        Lesson lesson8 = new Lesson("L8", "T1006", c24, LessonType.LECTURE, 111, "1:00 PM - 3:00 PM", "Wednesday", 80);  // c43 is for Dr. Watson
        Lesson lesson12 = new Lesson("L12", "T1006", c24, LessonType.LECTURE, 112, "10:00 AM - 12:00 PM", "Friday", 80);  // c44 is for Dr. Watson
        
     // Creating the first student object (Student 1)
        Student student1 = new Student(
            "student1", "password1", "Alice", "Johnson", "North",
            LocalDate.of(1998, 5, 20), Gender.FEMALE, "American",
            123456789, "student1@example.com", FamilyStatuses.SINGLE,
            "alice.johnson@university.edu", 2, null,
            null, null, Faculties.SITE, "S111", null,
            new HashMap<>(), true, new Schedule("S111", Arrays.asList(lesson1 ,lesson10,lesson5,lesson6)), 1, Specialties.IS, new Transcript("S111"), site
        );

        // Creating the second student object (Student 2)
        Student student2 = new Student(
            "student22", "password22", "Bob", "Williams", "Middle",
            LocalDate.of(1999, 9, 15), Gender.MALE, "British",
            987654321, "student2@example.com", FamilyStatuses.MARRIED,
            "bob.williams@university.edu", 3, null,
            null, null, Faculties.SITE, "S222", null,
            new HashMap<>(), true, new Schedule("S222", Arrays.asList(lesson1 ,lesson10,lesson5,lesson6)), 1, Specialties.IS, new Transcript("S222"), site
        );
        Student student3 = new Student(
                "student33", "password33", "Will", "Williams", "Middle",
                LocalDate.of(1999, 9, 15), Gender.MALE, "Irish",
                987654321, "student2@example.com", FamilyStatuses.SINGLE,
                "bob.williams@university.edu", 3, null,
                null, null, Faculties.SITE, "S333", null,
                new HashMap<>(), true, new Schedule("S333", Arrays.asList(lesson1 ,lesson10,lesson5,lesson6)), 1, Specialties.IS, new Transcript("S333"), site
            );
        Student student4 = new Student(
                "student444", "password44", "Joona", "Williams", "Middle",
                LocalDate.of(2005, 9, 15), Gender.MALE, "Kazakh",
                987654321, "student2@example.com", FamilyStatuses.SINGLE,
                "joona.williams@university.edu", 3, null,
                null, null, Faculties.SITE, "S444", null,
                new HashMap<>(), false, new Schedule("S444", Arrays.asList(lesson1 ,lesson10,lesson5,lesson6)), 1, Specialties.IS, new Transcript("S444"), site
            );
        Student student5 = new Student(
                "student555", "password555", "Moana", "Ahana", "Middle",
                LocalDate.of(2005, 9, 15), Gender.FEMALE, "Kazakh",
                987654321, "student2@example.com", FamilyStatuses.SINGLE,
                "moana.williams@university.edu", 3, null,
                null, null, Faculties.SITE, "S555", null,
                new HashMap<>(), false, new Schedule("S555", Arrays.asList(lesson1 ,lesson10,lesson5,lesson6)), 1, Specialties.IS, new Transcript("S555"), site
            );




        
        // Now, you can continue adding more lessons for each teacher as required.


        // You can continue to add more lessons for each teacher based on the corresponding course assignments.

        
        /*T2.addCourse(c11);
        T2.addCourse(c21);
        T2.addCourse(c33);
        
        T3.addCourse(c12);
        T3.addCourse(c13 );
        T3.addCourse(c22);
        T3.addCourse(c23);
        T3.addCourse(c26);*/
        
        //T6.addCourse(c24);
    
 

        

        //data.resetTeachers();
        //data.addStudent(student5);
       

        
    	
        if (Data.INSTANCE == null) {


        } else {
            System.out.println("Data.INSTANCE is initialized.");
        }
        
        try {
        	(new Managing()).run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
