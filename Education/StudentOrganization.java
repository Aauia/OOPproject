package Education;

import java.util.Set;

import User.Student;

import java.util.HashSet;
import java.util.Objects;

public class StudentOrganization {

    // Attributes
    private Organizations name; 
    private Integer members;
    private Integer code;
    private Set<Student> students;

    // Constructor
    public StudentOrganization(Organizations name, Integer code) {
        this.name = name;
        this.code = code;
        this.members = 0;
        this.students = new HashSet<>();
    }

    // Getters and Setters
    public Organizations getName() {
        return this.name;
    }

    public void setName(Organizations name) {
        this.name = name;
    }

    public Integer getMembers() {
        return this.members;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    // Operations

    public void addStudent(Student student) {
        if (students.add(student)) {
            members++;
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            members--;
        }
    }

    @Override
    public String toString() {
        return "StudentOrganization{" +
                "name=" + name +
                ", members=" + members +
                ", code=" + code +
                ", students=" + students.size() +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOrganization that = (StudentOrganization) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
