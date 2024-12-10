package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;

    private String majorName;
    private Faculties faculty;
    private Map<Integer, List<Course>> semesterCourses; // Semester mapped to courses

    // Constructor
    public Curriculum(String majorName, Faculties faculty, Map<Integer, List<Course>> semesterCourses) {
        this.majorName = majorName;
        this.faculty = faculty;
        this.semesterCourses = semesterCourses;
    }

    // Getters
    public String getMajorName() {
        return majorName;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public Map<Integer, List<Course>> getSemesterCourses() {
        return semesterCourses;
    }

    public List<Course> getCoursesForSemester(int semester) {
        return semesterCourses.getOrDefault(semester, List.of());
    }

    // Setters
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public void setSemesterCourses(Map<Integer, List<Course>> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    // Add a course to a specific semester
    public void addCourseToSemester(int semester, Course course) {
        semesterCourses.computeIfAbsent(semester, k -> new ArrayList<>()).add(course);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "majorName='" + majorName + '\'' +
                ", faculty=" + faculty +
                ", semesterCourses=" + semesterCourses +
                '}';
    }
}
