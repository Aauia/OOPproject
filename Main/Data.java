package Main;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import Education.*;
import User.*;



public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Vector<Student> students;         // List of students
    protected Vector<Teacher> teachers;         // List of teachers
    protected Vector<Course> courses;           // List of courses
    protected Vector<Lesson> lessons;
    protected Vector<Curriculum> rup;
    
    public static Data INSTANCE;              // Singleton instance

    // Static initializer block to load data or create a new instance
    static {
        if (new File("UniversityData").exists()) {
            try {
                INSTANCE = read();
            } catch (Exception e) {
                e.printStackTrace();
                INSTANCE = new Data();  // Fallback to new instance if read fails
            }
        } else {
            INSTANCE = new Data();
        }
    }

    // Private constructor to enforce singleton pattern
     Data() {
        students = new Vector<>();
        teachers = new Vector<>();
        courses = new Vector<>();
        lessons = new Vector<>();
            rup = new Vector<>();
        
    }

    // Serialize the INSTANCE to file
    public static void write() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("UniversityData");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(INSTANCE);
            System.out.println("Data has been written to file 'UniversityData'.");
        }
    }

    // Deserialize the INSTANCE from file
    public static Data read() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("UniversityData");
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            return (Data) oin.readObject();
        }
    }

    // Utility to generate unique student IDs
    public static int nextStudentId() {
        return INSTANCE.students.size() + 1;
    }

    // Utility to generate unique teacher IDs
    public static int nextTeacherId() {
        return INSTANCE.teachers.size() + 1;
    }

    // Add methods for managing entities
    
    
    public void addCurriculum(Curriculum curriculum) {
    	rup.add(curriculum);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
    
    public Vector<Curriculum> getCurriculum(){
    	return rup;
    }
    public Vector<Student> getStudents() {
        return students;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public Vector<Lesson> getLessons() {
        return lessons;
    }

    // Display all stored entities for debugging
    public void displayData() {
        System.out.println("Students:");
        students.forEach(System.out::println);
        System.out.println("Teachers:");
        teachers.forEach(System.out::println);
        System.out.println("Courses:");
        courses.forEach(System.out::println);
        System.out.println("Lessons:");
        lessons.forEach(System.out::println);
        System.out.println("Rups:");
        rup.forEach(System.out::println);
    }
}
