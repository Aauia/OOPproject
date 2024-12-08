package Education;

/**
 * Enumeration representing different mark ranges and their associated grades.
 */
public enum MarkType {
    A_PLUS(95, 100, "A+"),
    A(90, 94, "A"),
    B_PLUS(80, 89, "B+"),
    B(70, 79, "B"),
    D_PLUS(65, 69, "D+"),
    D(60, 64, "D"),
    C_MINUS(50, 59, "C-"),
    F(0, 49, "F"); // Added failing grade for marks below 50

    private final int minRange; // Minimum range for the grade
    private final int maxRange; // Maximum range for the grade
    private final String grade; // Grade label

    // Constructor to initialize the enum constants
    MarkType(int minRange, int maxRange, String grade) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.grade = grade;
    }

    // Getter for the grade
    public String getGrade() {
        return grade;
    }

    // Static method to find the grade based on marks
    public static MarkType getMarkType(int marks) {
        for (MarkType markType : MarkType.values()) {
            if (marks >= markType.minRange && marks <= markType.maxRange) {
                return markType;
            }
        }
        throw new IllegalArgumentException("Invalid marks: " + marks + ". Marks must be between 0 and 100.");
    }

    @Override
    public String toString() {
        return grade + " (" + minRange + "-" + maxRange + ")";
    }
}
