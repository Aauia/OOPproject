package Education;

import java.util.SortedSet;

import java.util.TreeSet;
import java.util.Vector;
import User.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.io.Serializable;

import java.util.*;
import java.io.Serializable;


public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
    private String courseCode;
    private String courseName;
    private Access_Course type;
    private Integer credit;
    private Integer  studentAmount;
    private Vector<String> prerequisiteCourses; 
    private Vector<Faculties> sharedFaculties;

    // Constructor
    public Course(String courseCode, String courseName, Access_Course type, int credit, 
    		Integer  studentAmount,  
                  Vector<String> prerequisiteCourses, Vector<Faculties> sharedFaculties) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.type = type;
        this.credit = credit;
        this.studentAmount = studentAmount ;
        this.prerequisiteCourses = prerequisiteCourses != null ? prerequisiteCourses : new Vector<>();
        
        // Initialize sharedFaculties if the type is SHARED
        if (type == Access_Course.SHARED) {
            this.sharedFaculties = sharedFaculties != null ? sharedFaculties : new Vector<>();
        } else {
            this.sharedFaculties = null;
        }
    }


    public Course(String courseName) {
        super();
        this.setCourseName(courseName);
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

        // Initialize sharedFaculties if type is set to SHARED
        if (type == Access_Course.SHARED && this.sharedFaculties == null) {
            this.sharedFaculties = new Vector<>();
        } else if (type != Access_Course.SHARED) {
            this.sharedFaculties = null; // Clear sharedFaculties if not SHARED
        }
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }


    public Vector<String> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(Vector<String> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public void addPrerequisiteCourse(String course) {
        this.prerequisiteCourses.add(course);
    }

    public void removePrerequisiteCourse(Course course) {
        this.prerequisiteCourses.remove(course);
    }

    public Vector<Faculties> getSharedFaculties() {
        return sharedFaculties;
    }

    public void addSharedFaculty(Faculties faculty) {
        if (this.type == Access_Course.SHARED && sharedFaculties != null) {
            sharedFaculties.add(faculty);
        } else {
            throw new UnsupportedOperationException("Cannot add faculties to a non-SHARED course.");
        }
    }

    public void removeSharedFaculty(Faculties faculty) {
        if (this.type == Access_Course.SHARED && sharedFaculties != null) {
            sharedFaculties.remove(faculty);
        } else {
            throw new UnsupportedOperationException("Cannot remove faculties from a non-SHARED course.");
        }
    }

    // Operations
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
                (sharedFaculties != null ? ", sharedFaculties=" + sharedFaculties : "") +
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

