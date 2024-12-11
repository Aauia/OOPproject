package Education;

import java.util.Objects;

import User.Student;

public class Mark {
    private Student student;         
    private String courseCode;       
    private double firstAttestation; 
    private double secondAttestation;
    private double finalMark;        

    public Mark(Student student, String courseCode, double firstAttestation, double secondAttestation, double finalMark) {
        this.student = student;
        this.courseCode = courseCode;
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalMark = finalMark;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public double getFinalMark() {
        return finalMark;
    }

    // Utility methods
    public String getMarkType() {
        return "Final Mark for " + courseCode + ": " + finalMark;
    }

    public int getSum() {
        return (int) (firstAttestation + secondAttestation + finalMark);
    }

    public void updateMark(double newFinalMark) {
        this.finalMark = newFinalMark;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(student, mark.student) &&
               Objects.equals(courseCode, mark.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, courseCode);
    }

}
