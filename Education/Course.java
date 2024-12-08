package Education;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import User.Student;
import User.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course {
    private String courseCode;
    private String courseName;
    private Access_Course type; 
    private SortedSet<Student> students;
    private SortedSet<Teacher> teachers;
    private Map<String, Integer> allowedSemester; 
    private Integer credit;
    private Map<Integer, Integer> studentAmount;
    private List<Lesson> lessons;
    private List<Major> accessMajor; 
    private Map<String, Vector<Map<String, String>>> teacherSchedule;
    private Integer prerequisiteCourseCode;

    // Constructor
    public Course(String courseCode, String courseName, Access_Course type, int credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.type = type;
        this.credit = credit;
        this.students = new TreeSet<>();
        this.teachers = new TreeSet<>();
        this.allowedSemester = new HashMap<>();
        this.studentAmount = new HashMap<>();
        this.lessons = new ArrayList<>();
        this.accessMajor = new ArrayList<>();
        this.teacherSchedule = new HashMap<>();
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Access_Course getType() {
        return type;
    }

    public void setType(Access_Course type) {
        this.type = type;
    }

    public SortedSet<Student> getStudents() {
        return students;
    }

    public void setStudents(SortedSet<Student> students) {
        this.students = students;
    }

    public SortedSet<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(SortedSet<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Map<String, Integer> getAllowedSemester() {
        return allowedSemester;
    }

    public void setAllowedSemester(Map<String, Integer> allowedSemester) {
        this.allowedSemester = allowedSemester;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Map<Integer, Integer> getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Map<Integer, Integer> studentAmount) {
        this.studentAmount = studentAmount;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Major> getAccessMajor() {
        return accessMajor;
    }

    public void setAccessMajor(List<Major> accessMajor) {
        this.accessMajor = accessMajor;
    }

    public Map<String, Vector<Map<String, String>>> getTeacherSchedule() {
        return teacherSchedule;
    }

    public void setTeacherSchedule(Map<String, Vector<Map<String, String>>> teacherSchedule) {
        this.teacherSchedule = teacherSchedule;
    }

    public Integer getPrerequisiteCourseCode() {
        return prerequisiteCourseCode;
    }

    public void setPrerequisiteCourseCode(Integer prerequisiteCourseCode) {
        this.prerequisiteCourseCode = prerequisiteCourseCode;
    }

    // Operations
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void declineCourse() {
        System.out.println("Course " + courseName + " has been declined.");
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", type=" + type +
                ", credit=" + credit +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}