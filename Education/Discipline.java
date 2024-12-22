package Education;

import java.util.List;
import java.util.Objects;

/**
 * Represents a Discipline with a name, code, faculty, and associations.
 */
public class Discipline {

    // Attributes
    private String name;
    private String code;
    private Faculty primaFaculty; // Custom type, assumed to be defined elsewhere
    private List<DisciplineAssociation> associations; // List of associations

    // Constructor
    public Discipline(String name, String code, Faculty primaFaculty, List<DisciplineAssociation> associations) {
        this.name = name;
        this.code = code;
        this.primaFaculty = primaFaculty;
        this.associations = associations;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Faculty getPrimaFaculty() {
        return this.primaFaculty;
    }

    public void setPrimaFaculty(Faculty primaFaculty) {
        this.primaFaculty = primaFaculty;
    }

    public List<DisciplineAssociation> getAssociations() {
        return this.associations;
    }

    public void setAssociations(List<DisciplineAssociation> associations) {
        this.associations = associations;
    }

    // Operations
    public void displayInfo() {
        System.out.println("Discipline Name: " + name);
        System.out.println("Discipline Code: " + code);
        System.out.println("Faculty: " + (primaFaculty != null ? primaFaculty : "None"));
        System.out.println("Associations: " + (associations != null ? associations : "No associations"));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
