package Education;

import java.io.Serializable;
import java.util.Objects;

public class Lesson implements Serializable{
	private static final long serialVersionUID = 1L;
	private String teacherID;
    private String lessonID;
    private Course course;
    private LessonType lessonType;
    private int room;
    private String time; // Format: "10:00 AM - 12:00 PM"
    private String day;  // Format: "Monday"
    private int numberOfStudents;

    // Constructor
    public Lesson(String lessonID, String teacherID, Course course, LessonType lessonType, int room, String time, String day,int numberOfStudents) {
        this.lessonID = lessonID;
        this.teacherID = teacherID;
        this.course = course;
        this.lessonType = lessonType;
        this.room = room;
        this.time = time;
        this.day = day;
        this.numberOfStudents = numberOfStudents;
    }

    // Getters and Setters
    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacher(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
    	this.day = day;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    // Display Lesson Information
    public void displayLessonInfo() {
        System.out.println("Lesson ID: " + lessonID);
        System.out.println("Course: " + (course != null ? course.getCourseCode() : "N/A"));
        System.out.println("Lesson Type: " + lessonType);
        System.out.println("Room: " + room);
        System.out.println("Time: " + time);
        System.out.println("Day: " + day);
    }


    public String toString() {
        return "Lesson{" +
                "lessonID='" + lessonID + '\'' +
                ", teacher='" + teacherID + '\'' +
                ", course=" + (course != null ? course.getCourseCode() : "N/A") +
                ", lessonType=" + lessonType +
                ", room=" + room +
                ", time='" + time + '\'' +
                ", day='" + day + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(lessonID, lesson.lessonID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonID);
    }
}


