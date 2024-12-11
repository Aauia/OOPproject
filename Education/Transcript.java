package Education;

import java.util.*;

import User.Student;

public class Transcript {
    private Student student;                                           
    private int semester;                                              
    private Map<Course, ArrayList<Mark>> studentMarks;                 

    public Transcript(Student student, int semester) {
        this.student = student;
        this.semester = semester;
        this.studentMarks = new HashMap<>();
    }

    public Student getStudent() {
        return student;
    }

    public int getSemester() {
        return semester;
    }

    public void addMarksForCourse(Course course, Mark mark) {
       //
    }

    public void viewStudentMarks() {
        //
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transcript that = (Transcript) o;
        return Objects.equals(student, that.student) &&
               Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, semester);
    }

}
