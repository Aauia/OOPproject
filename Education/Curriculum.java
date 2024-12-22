package Education;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;

    private Specialties specialty;
    private Faculties faculty;
    private Map<Integer, List<Course>> semesterCourses; // Map semester to list of courses

    public Curriculum(Specialties specialty, Faculties faculty, Map<Integer, List<Course>> semesterCourses) {
        this.specialty = specialty;
        this.faculty = faculty;
        this.semesterCourses = semesterCourses;
    }

    public Specialties getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialties specialty) {
        this.specialty = specialty;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public Map<Integer, List<Course>> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Map<Integer, List<Course>> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "specialty=" + specialty +
                ", faculty=" + faculty +
                ", semesterCourses=" + semesterCourses +
                '}';
    }
}