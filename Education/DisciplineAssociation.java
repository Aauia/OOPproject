package Education;

import java.util.List;

/**
 * Represents discipline associations, linking a school with access conditions.
 */
public class DisciplineAssociation {

    // Attributes
    private Faculties faculty; // Custom type, assumed to exist
    private List<AccessCondition> conditions; // Custom type for access conditions

    // Constructor
    public DisciplineAssociation(Faculties faculty, List<AccessCondition> conditions) {
        this.faculty = faculty;
        this.conditions = conditions;
    }

    // Getters and Setters
    public Faculties getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public List<AccessCondition> getConditions() {
        return this.conditions;
    }

    public void setConditions(List<AccessCondition> conditions) {
        this.conditions = conditions;
    }
}
