package Education;

import java.io.Serializable;
import java.util.*;

public class Transcript implements Serializable {
    private String studentId;
    private Map<Integer, Map<Course, ArrayList<Mark>>> semesterData; // Nested map to store marks by semester and course
    private Set<Course> registeredCourses;

    public Transcript(String studentId) {
        this.studentId = studentId;
        this.semesterData = new HashMap<>();
        this.registeredCourses = new HashSet<>();
    }

    public void addMarksForCourse(int semester, Course course, Mark mark) {
        // Initialize semester and course data if missing
        semesterData.computeIfAbsent(semester, k -> new HashMap<>())
                    .computeIfAbsent(course, k -> new ArrayList<>())
                    .add(mark);
    }

    public List<Mark> getMarksForCourse(int semester, Course course) {
        return semesterData.getOrDefault(semester, Collections.emptyMap())
                           .getOrDefault(course, new ArrayList<>());
    }

    public boolean hasPassedCourse(String courseCode) {
        for (Map<Course, ArrayList<Mark>> semesterCourses : semesterData.values()) {
            for (Course course : semesterCourses.keySet()) {
                if (course.getCourseCode().equals(courseCode)) {
                    for (Mark mark : semesterCourses.get(course)) {
                        if (mark.getSum() >= 50) return true;
                    }
                }
            }
        }
        return false;
    }

    public void displayTranscript() {
        System.out.println("Transcript for Student ID: " + studentId);
        for (Map.Entry<Integer, Map<Course, ArrayList<Mark>>> semesterEntry : semesterData.entrySet()) {
            int semester = semesterEntry.getKey();
            System.out.println("Semester: " + semester);
            for (Map.Entry<Course, ArrayList<Mark>> courseEntry : semesterEntry.getValue().entrySet()) {
                Course course = courseEntry.getKey();
                List<Mark> marks = courseEntry.getValue();
                System.out.println("  Course: " + course);
                for (Mark mark : marks) {
                    System.out.println("    - Marks: " + mark.getSum() + " | Status: " + mark.getStatus());
                }
            }
        }
    }

	public Map<Integer, Map<Course, ArrayList<Mark>>> getSemesterData() {
		return semesterData;
	}
}

