package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;

    private Specialties specialty;
    private Faculties faculty;
    private Map<Integer, List<Course>> semesterCourses; // Map semester to list of courses

    public Curriculum(Specialties specialty, Faculties faculty, Map<Integer, List<Course>> semesterCourses) {
        this.specialty = specialty;
        this.faculty = faculty;
        this.semesterCourses =  new HashMap<>(semesterCourses);
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
    public void addCoursesForSemester(int semester, List<Course> courses) {
        // Add or update the semester's courses in the map
    	semesterCourses.put(semester, courses);
    }
    public List<Course> getFreeCoursesForSemester(int currentSemester) {
        List<Course> freeCourses = new ArrayList<>();
        for (Map.Entry<Integer, List<Course>> entry : semesterCourses.entrySet()) {
            int semester = entry.getKey();
            if (semester <= currentSemester) { // Only allow up to current semester
                for (Course course : entry.getValue()) {
                    if (course.getType() == Access_Course.FREE) {
                        freeCourses.add(course);
                    }
                }
            }
        }
        return freeCourses;
    }

    // Get all courses for a given semester
    public List<Course> getAllCoursesForSemester(int semester) {
        return semesterCourses.getOrDefault(semester, new ArrayList<>());
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


