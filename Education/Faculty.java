package Education;
import java.util.Set;

import User.Student;

import java.util.HashSet;
import java.util.Objects;

public class Faculty {

    // Attributes
    private Faculties faculty;        
    private Integer studentAmount;    
    private Integer teacherAmount;    
    private Integer courseCode;       
    private Set<Student> students;    

    // Constructor
    public Faculty(Faculties faculty, Integer studentAmount, Integer teacherAmount, Integer courseCode) {
        this.faculty = faculty;
        this.studentAmount = studentAmount;
        this.teacherAmount = teacherAmount;
        this.courseCode = courseCode;
        this.students = new HashSet<>();
    }

    // Getters and Setters

    public Faculties getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public Integer getStudentAmount() {
        return this.studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }

    public Integer getTeacherAmount() {
        return this.teacherAmount;
    }

    public void setTeacherAmount(Integer teacherAmount) {
        this.teacherAmount = teacherAmount;
    }

    public Integer getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        this.studentAmount = this.students.size(); // Update student amount dynamically
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        this.studentAmount = this.students.size(); // Update student amount dynamically
    }

    // Operations

    public int getCode() {
        return this.courseCode;
    }

    public int getStudentCount() {
        return this.studentAmount != null ? this.studentAmount : 0;
    }

    public int getTeacherCount() {
        return this.teacherAmount != null ? this.teacherAmount : 0;
    }

    public int fetchCourseCode() {
        return this.courseCode;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "faculty=" + faculty +
                ", studentAmount=" + studentAmount +
                ", teacherAmount=" + teacherAmount +
                ", courseCode=" + courseCode +
                ", students=" + students +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(faculty, faculty.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty);
    }
}
