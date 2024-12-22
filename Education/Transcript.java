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

    // Initialize the transcript for the given course and semester, with null marks
    public void initializeTranscriptForCourse(int semester, Course course) {
        semesterData.computeIfAbsent(semester, k -> new HashMap<>())
                    .computeIfAbsent(course, k -> {
                        ArrayList<Mark> marks = new ArrayList<>();
                        marks.add(new Mark(0, 0, 0)); // Placeholder marks
                        return marks;
                    });
    }


    // Add marks for a specific course in a specific semester
    public void addMarksForCourse(int semester, Course course, Mark mark) {
        semesterData.computeIfAbsent(semester, k -> new HashMap<>())
                    .computeIfAbsent(course, k -> new ArrayList<>())
                    .add(mark);
    }

    public void addMark(Course course, Mark mark, int semester) {
        Map<Course, ArrayList<Mark>> semesterCourses = semesterData.get(semester);
        if (semesterCourses == null) {
            semesterCourses = new HashMap<>();
            semesterData.put(semester, semesterCourses);
        }
        semesterCourses.computeIfAbsent(course, k -> new ArrayList<>()).add(mark);
    }
    public void addOrUpdateMark(int semester, Course course, Mark mark) {
        // Get the map of courses for the given semester
        Map<Course, ArrayList<Mark>> semesterCourses = semesterData.get(semester);
        
        if (semesterCourses == null) {
            semesterCourses = new HashMap<>();
            semesterData.put(semester, semesterCourses);
        }

        // Check if the course already exists in the semester
        if (semesterCourses.containsKey(course)) {
            // If the course already exists, update the marks
            ArrayList<Mark> marks = semesterCourses.get(course);
            if (!marks.isEmpty()) {
                // Update the first mark (assuming we only want one set of marks per course per semester)
                marks.set(0, mark); // If there are multiple marks, you can decide how to replace them
            }
        } else {
            // If the course doesn't exist, add a new entry
            ArrayList<Mark> marks = new ArrayList<>();
            marks.add(mark);
            semesterCourses.put(course, marks);
        }
    }


    // Get marks for a specific course in a specific semester
    public List<Mark> getMarksForCourse(int semester, Course course) {
        return semesterData.getOrDefault(semester, Collections.emptyMap())
                           .getOrDefault(course, new ArrayList<>());
    }
 // Get the first mark for a specific course in a specific semester
    public Mark getMarkForCourses(int semester, Course course) {
        List<Mark> marks = getMarksForCourse(semester, course);
        return marks.isEmpty() ? null : marks.get(0);  // Return the first mark if exists, otherwise return null
    }


    public void displayTranscript() {
        System.out.println("Transcript for Student ID: " + studentId);
        for (Map.Entry<Integer, Map<Course, ArrayList<Mark>>> semesterEntry : semesterData.entrySet()) {
            int semester = semesterEntry.getKey();
            System.out.println("Semester: " + semester);
            for (Map.Entry<Course, ArrayList<Mark>> courseEntry : semesterEntry.getValue().entrySet()) {
                Course course = courseEntry.getKey();
                List<Mark> marks = courseEntry.getValue();
                System.out.println("  Course: " + course.getCourseCode() + " - " + course.getCourseName());
                if (marks.isEmpty()) {
                    System.out.println("    - Marks: Pending");
                } else {
                    for (Mark mark : marks) {
                        System.out.println("    - Marks: " + mark.getSum() + " | Status: " + mark.getStatus());
                    }
                }
            }
        }
    }

    public Map<Integer, Map<Course, ArrayList<Mark>>> getSemesterData() {
        return semesterData;
    }

}




