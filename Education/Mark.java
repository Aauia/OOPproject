package Education;

import java.io.Serializable;
import java.util.Objects;

public class Mark  implements Serializable {


    // Attributes
    private Integer markID;            // Unique ID for the mark
    private String studentName;        // Name of the student
    private Course course;             // Reference to the Course class
    private Integer attestation1;      // Marks for first attestation
    private Integer attestation2;      // Marks for second attestation
    private Integer finalExam;         // Marks for the final exam
    private Integer totalSum;          // Total marks or score
    private MarkType markType;
    
    // Enum for the mark range/type
	public Mark() {
		
	}

    // Constructor
    public Mark(Integer markID, String studentName, Course course, 
                Integer attestation1, Integer attestation2, Integer finalExam) {
        this.markID = markID;
        this.studentName = studentName;
        this.course = course;
        this.attestation1 = attestation1;
        this.attestation2 = attestation2;
        this.finalExam = finalExam;
        calculateTotalSumAndMarkType();
    }

    // Getters and Setters
    public Integer getMarkID() {
        return markID;
    }

    public void setMarkID(Integer markID) {
        this.markID = markID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getAttestation1() {
        return attestation1;
    }

    public void setAttestation1(Integer attestation1) {
        this.attestation1 = attestation1;
        calculateTotalSumAndMarkType();
    }

    public Integer getAttestation2() {
        return attestation2;
    }

    public void setAttestation2(Integer attestation2) {
        this.attestation2 = attestation2;
        calculateTotalSumAndMarkType();
    }

    public Integer getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Integer finalExam) {
        this.finalExam = finalExam;
        calculateTotalSumAndMarkType();
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public MarkType getMarkType() {
        return markType;
    }

    // Calculate totalSum and markType
    private void calculateTotalSumAndMarkType() {
        this.totalSum = (attestation1 != null ? attestation1 : 0)
                + (attestation2 != null ? attestation2 : 0)
                + (finalExam != null ? finalExam : 0);

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
            this.markType = MarkType.F;
        }
    }

    // Display mark details
    public void displayMarkDetails() {
        System.out.println("Mark ID: " + markID);
        System.out.println("Student: " + studentName);
        System.out.println("Course: " + (course != null ? course.getCourseName() : "N/A"));
        System.out.println("Attestation 1: " + attestation1);
        System.out.println("Attestation 2: " + attestation2);
        System.out.println("Final Exam: " + finalExam);
        System.out.println("Total Marks: " + totalSum);
        System.out.println("Mark Type: " + markType);
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


