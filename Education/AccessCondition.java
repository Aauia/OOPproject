package Education;

import java.util.Objects;

/**
 * Represents an access condition based on major, semester, and access type.
 */
public class AccessCondition {

    // Attributes
    private String major;
    private Integer semester;
    private Access_Course accessType;

    // Constructor
    public AccessCondition(String major, Integer semester, Access_Course accessType) {
        this.major = major;
        this.semester = semester;
        this.accessType = accessType;
    }

    // Getters and Setters
    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Access_Course getAccessType() {
        return this.accessType;
    }

    public void setAccessType(Access_Course accessType) {
        this.accessType = accessType;
    }

    // toString Method
    @Override
    public String toString() {
        return "AccessCondition{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", accessType=" + accessType +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessCondition that = (AccessCondition) o;
        return Objects.equals(major, that.major) &&
               Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, semester);
    }
}
