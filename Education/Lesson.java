package Education;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import User.Student;
import User.Teacher;

import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Lesson {

    private Teacher teacher;
    private SortedSet<Student> students;
    private int lessonID;
    private Course course;
    private LessonType lessonType; // Enum for lesson types (e.g., Lecture, Practice)
    private Map<Student, MarkType> marks;

    // Constructor
    public Lesson(int lessonID, Teacher teacher, Course course, LessonType lessonType) {
        this.lessonID = lessonID;
        this.teacher = teacher;
        this.course = course;
        this.lessonType = lessonType;
        this.students = new TreeSet<>();
        this.marks = new HashMap<>();
    }

    // Getters and Setters
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Map<Student, MarkType> getMarks() {
        return marks;
    }

    public void addMark(Student student, MarkType mark) {
        if (student != null && mark != null) {
            marks.put(student, mark);
        }
    }

    // Operations
    public String getCourseCode() {
        return course != null ? course.getCourseCode() : "N/A";
    }

    public void displayLessonInfo() {
        System.out.println("Lesson ID: " + lessonID);
        System.out.println("Course: " + getCourseCode());
        System.out.println("Teacher: " + (teacher != null ? teacher.getTeacherID() : "No teacher assigned"));
        System.out.println("Lesson Type: " + lessonType);
        System.out.println("Number of Students: " + students.size());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(lessonID, lesson.lessonID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonID);
    }
}
