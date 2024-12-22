package Education;

import java.util.Objects;

public class Major {

    private String majorName;       
    private Faculties faculty;      
    private String studentID;       
    private Integer accessCourseID; 

    // Constructor
    public Major(String majorName, Faculties faculty, String studentID, Integer accessCourseID) {
        this.majorName = majorName;
        this.faculty = faculty;
        this.studentID = studentID;
        this.accessCourseID = accessCourseID;
    }

    // Getters and Setters

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getAccessCourseID() {
        return accessCourseID;
    }

    public void setAccessCourseID(Integer accessCourseID) {
        this.accessCourseID = accessCourseID;
    }

    // Operations

    
    public String getMajor() {
        return majorName;
    }

    public Faculties getFacultyDetails() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorName='" + majorName + '\'' +
                ", faculty=" + faculty +
                ", studentID='" + studentID + '\'' +
                ", accessCourseID=" + accessCourseID +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Major that = (Major) o;
        return Objects.equals(majorName, this.majorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorName);
    }
}
