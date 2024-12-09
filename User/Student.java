package User;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import javax.swing.JTable;
import Education.*;

public class Student extends Person {

    private double gpa;
    private StudentOrganization studentLife;
    private List<Major> majors;
    private List<Request> requests;
    private Faculty faculty;
    private String studentId;
    private Set<StudentResearcher> studentResearchers;
    private Set<Complaint> complaints;
    private Set<StudentOrganization> studentOrganizations;
    private Set<Course> courses;

    // Полный конструктор для всех полей
    public Student(String login, String password, String name, String surname, String middleName, 
                   LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, 
                   String email, FamilyStatuses familyStatus, String corporateEmail, 
                   double gpa, StudentOrganization studentLife, List<Major> majors, 
                   List<Request> requests, Faculty faculty, String studentId, 
                   Set<StudentResearcher> studentResearchers, Set<Complaint> complaints, 
                   Set<StudentOrganization> studentOrganizations, Set<Course> courses) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, 
              phoneNumber, email, familyStatus, corporateEmail);
        this.gpa = gpa;
        this.studentLife = studentLife;
        this.majors = majors;
        this.requests = requests;
        this.faculty = faculty;
        this.studentId = studentId;
        this.studentResearchers = studentResearchers;
        this.complaints = complaints;
        this.studentOrganizations = studentOrganizations;
        this.courses = courses;
    }

    // Конструктор по умолчанию
    public Student() {
        super();
    }

    // Геттеры и сеттеры
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public StudentOrganization getStudentLife() {
        return studentLife;
    }

    public void setStudentLife(StudentOrganization studentLife) {
        this.studentLife = studentLife;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<StudentResearcher> getStudentResearchers() {
        return studentResearchers;
    }

    public void setStudentResearchers(Set<StudentResearcher> studentResearchers) {
        this.studentResearchers = studentResearchers;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Set<StudentOrganization> getStudentOrganizations() {
        return studentOrganizations;
    }

    public void setStudentOrganizations(Set<StudentOrganization> studentOrganizations) {
        this.studentOrganizations = studentOrganizations;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    // Бизнес-методы
    public void joinStudentOrganization(StudentOrganization organization) {
        if (studentOrganizations.add(organization)) {
            System.out.println("Successfully joined the organization: " + organization.getName());
        } else {
            System.out.println("Already a member of this organization.");
        }
    }

    public void leaveStudentOrganization(StudentOrganization organization) {
        if (studentOrganizations.remove(organization)) {
            System.out.println("Successfully left the organization: " + organization.getName());
        } else {
            System.out.println("Not a member of this organization.");
        }
    }

    public List<Course> viewCourses() {
        // Return the list of enrolled courses
        return List.copyOf(courses);
    }

    public JTable viewSchedule() {
        // Placeholder for schedule table
        return new JTable();
    }

    public JTable studentJournal() {
        // Placeholder for journal table
        return new JTable();
    }

    public String viewTeacherInfo() {
        // Placeholder for fetching teacher information
        return "Teacher information not available.";
    }

    public JTable viewMarks() {
        // Placeholder for marks table
        return new JTable();
    }

    public JTable viewTranscript() {
        // Placeholder for transcript table
        return new JTable();
    }

    public JTable rateTeacher() {
        // Placeholder for teacher rating functionality
        return new JTable();
    }

    public StudentOrganization manageStudentOrganizations() {
        // Placeholder for managing student organizations
        return new StudentOrganization();
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
