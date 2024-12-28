package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentID;
    private List<Lesson> lessons;

    // Constructor
    public Schedule(String studentID,List<Lesson> lessons) {
        this.studentID = studentID;
        this.lessons = lessons;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    // Add a single lesson to the schedule
    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    // Remove a single lesson from the schedule
    public void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }

    // Display all lessons for the student
    public void displaySchedule() {
        System.out.println("Schedule for student ID: " + studentID);
        if (lessons.isEmpty()) {
            System.out.println("No lessons assigned.");
        } else {
            for (Lesson lesson : lessons) {
                System.out.println(lesson);
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Schedule{\n");
        sb.append("  studentID='").append(studentID).append("',\n");
        sb.append("  lessons=\n");
        for (Lesson lesson : lessons) {
            sb.append("    ").append(lesson).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
