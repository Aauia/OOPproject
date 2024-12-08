package Education;

import java.util.Objects;

/**
 * Class representing a student's mark.
 */
public class Mark {
    
    // Attributes
    private MarkType markType;  // Enum for the mark range/type
    private String studentName; // Name of the student
    private Integer markID;     // Unique ID for the mark
    private String courseCode;  // Code of the related course
    private Integer lessonID;   // ID of the lesson
    private Integer totalSum;   // Total marks or score

    private Lesson lesson;      // Reference to the Lesson class

    // Constructors
    public Mark(Integer markID, String studentName, String courseCode, MarkType markType, Lesson lesson, Integer totalSum) {
        this.markID = markID;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.markType = markType;
        this.lesson = lesson;
        this.totalSum = totalSum;
    }

    // Getters and Setters
    public MarkType getMarkType() {
        return markType;
    }

    public void setMarkType(MarkType markType) {
        this.markType = markType;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getMarkID() {
        return markID;
    }

    public void setMarkID(Integer markID) {
        this.markID = markID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    // Operations

    /**
     * Update the mark type based on the total score.
     */
    public void updateMarkType() {
        if (totalSum >= 95) {
            this.markType = MarkType.A_PLUS;
        } else if (totalSum >= 90) {
            this.markType = MarkType.A;
        } else if (totalSum >= 80) {
            this.markType = MarkType.B_PLUS;
        } else if (totalSum >= 70) {
            this.markType = MarkType.B;
        } else if (totalSum >= 65) {
            this.markType = MarkType.D_PLUS;
        } else if (totalSum >= 60) {
            this.markType = MarkType.D;
        } else if (totalSum >= 50) {
            this.markType = MarkType.C_MINUS;
        } else {
            this.markType = MarkType.F; // Below 50
        }
    }

    /**
     * Display mark details.
     */
    public void displayMarkDetails() {
        System.out.println("Mark ID: " + markID);
        System.out.println("Student: " + studentName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Total Marks: " + totalSum);
        System.out.println("Mark Type: " + markType);
        System.out.println("Lesson: " + (lesson != null ? lesson.getLessonID() : "N/A"));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(markID, mark.markID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markID);
    }
}
