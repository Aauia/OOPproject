package Main;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import Education.*;
import User.*;


public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Vector<Student> students;
    protected Vector<Employee> employees;
    protected Vector<Teacher> teachers;         
    protected Vector<Course> courses;        
    protected Vector<Lesson> lessons;
    private Vector<Curriculum> rup;
    protected Vector<Admin> admins;
  
    public static Data INSTANCE; 
    

    
    static {
        if (new File("UniversityData").exists()) {
            try {
                INSTANCE = read();
            } catch (Exception e) {
                e.printStackTrace();
                INSTANCE = new Data();  
            }
        } else {
            INSTANCE = new Data();
        }
    }

     private Data() {
        students = new Vector<>();
        teachers = new Vector<>();
        courses = new Vector<>();
        lessons = new Vector<>();
            setRup(new Vector<>());
            admins = new Vector<>();
            admins.add(new Admin("admin1", "password123", "John", "Doe", "Middle", 
                    LocalDate.of(1980, 5, 15), Gender.MALE, "American", 
                    1234567890, "admin1@example.com", FamilyStatuses.SINGLE, 
                    "jdoe@university.edu", 5000.0, "10 years", "AdminHead", false));
            admins.add(new Admin("admin2", "pass456", "Jane", "Smith", "Middle", 
                    LocalDate.of(1990, 3, 20), Gender.FEMALE, "British", 
                    987654321, "admin2@example.com", FamilyStatuses.MARRIED, 
                    "jsmith@university.edu", 4500.0, "5 years", "AdminAssistant", false));
            
        
    }
     


    public static void write() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("UniversityData");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(INSTANCE);
            System.out.println("Data has been written to file 'UniversityData'.");
        }
    }


    public static Data read() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("UniversityData");
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            return (Data) oin.readObject();
        }
    }

   
    public static int nextStudentId() {
        return INSTANCE.students.size() + 1;
    }


    public static int nextTeacherId() {
        return INSTANCE.teachers.size() + 1;
    }

   
    
    
    public void addCurriculum(Curriculum curriculum) {
    	getRup().add(curriculum);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void addAdmin(Admin admin) {
        admins.add(admin);
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
    	return getRup();
    }
    public Vector<Student> getStudents() {
        return students;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }
    public Vector<Admin> getAdmins() {
        return admins;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public Vector<Lesson> getLessons() {
        return lessons;
    }

   
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
        getRup().forEach(System.out::println);
    }


	public Vector<Curriculum> getRup() {
		return rup;
	}



	public void setRup(Vector<Curriculum> rup) {
		this.rup = rup;
	}
}
