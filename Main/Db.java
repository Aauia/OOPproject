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
/*
    // Method to initialize the data (add Admins, Students, Courses, etc.)
    public static void initializeData() throws IOException {
        // Admins
        addAdmins();
        
        // Courses
        addCourses();
        
        // Students
        addStudents();
        
        // Teachers
        addTeachers();
        
        // Lessons
        addLessons();

        // Exit after adding all data
        exit();
    }

    // Method to add Admins
    private static void addAdmins() {
        Admin admin1 = new Admin(
            "admin1", "password123", "John", "Doe", "Middle",
            LocalDate.of(1980, 5, 15), Gender.MALE, "American",
            1234567890, "admin1@example.com", FamilyStatuses.SINGLE,
            "jdoe@university.edu", 5000.0, "10 years", "AdminHead", false
        );
        Admin admin2 = new Admin(
            "admin2", "pass456", "Jane", "Smith", "Middle",
            LocalDate.of(1990, 3, 20), Gender.FEMALE, "British",
            987654321, "admin2@example.com", FamilyStatuses.MARRIED,
            "jsmith@university.edu", 4500.0, "5 years", "AdminAssistant", false
        );

        Data.INSTANCE.addAdmin(admin1);
        Data.INSTANCE.addAdmin(admin2);
    }

    // Method to add Courses
    private static void addCourses() {
        Course c1 = new Course("CS101", "Introduction to Computer Science", Access_Course.MAJOR, 3, 100, null, null, 2, 2);
        Course c2 = new Course("MATH101", "Calculus I", Access_Course.MAJOR, 4, 80, null, null, 2, 1);
        Curriculum site1 = new Curriculum(Specialties.CS_SE, Faculties.SITE, Map.of(1, Arrays.asList(c1, c2)));

        Data.INSTANCE.addCourse(c1);
        Data.INSTANCE.addCourse(c2);
        
        site1.addCoursesForSemester(2, Arrays.asList(c1, c2));
        Data.INSTANCE.addRup(site1);
    }

    // Method to add Students
    private static void addStudents() {
        Student student1 = new Student(
            "student1", "pass123", "Alice", "Johnson", "Middle",
            LocalDate.of(2001, 6, 12), Gender.FEMALE, "Canadian",
            987654321, "alice.johnson@example.com", FamilyStatuses.SINGLE,
            "alice.johnson@university.edu", 3, null, null, null,
            Faculties.SITE, "S67891", null, new HashMap<>(), true,
            new Schedule("S67891", null), 1, Specialties.CS_SE,
            new Transcript("S67891"), null
        );
        
        Data.INSTANCE.addStudent(student1);
    }

    // Method to add Teachers
    private static void addTeachers() {
        Teacher teacher1 = new Teacher(
            "T123", "password123", "Dr. Smith", "John", "M",
            LocalDate.of(1980, 5, 15), Gender.MALE, "American",
            123456789, "dr.smith@example.com", FamilyStatuses.SINGLE,
            "dr.smith@university.edu", 50000, "10 years", TeacherTypes.PROFESSOR,
            "T1001", true
        );

        Data.INSTANCE.addTeacher(teacher1);
    }

    // Method to add Lessons
    private static void addLessons() {
        Course c1 = Data.INSTANCE.findCourseByCode("CS101");
        Lesson lesson1 = new Lesson("L1", "T123", c1, LessonType.LECTURE, 101, "10:00 AM - 12:00 PM", "Monday", 80);
        Data.INSTANCE.addLesson(lesson1);
    }

    // Method to exit (save data and display message)
    private static void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save data to a file or database
    private static void save() throws IOException {
        Data.write();
    }*/
}
