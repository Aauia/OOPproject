package User;
import java.util.HashMap;
import Education.Transcript;


import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.Set;
//import javax.swing.JTable;
import Education.*;
public class Student extends Person  {
    private double gpa;
    private StudentOrganization studentLife;
    private List<Major> majors;
    private List<Request> requests;
    private Faculty faculty;
    private String studentId;
    public StudentResearcher sr;
    private Set<Complaint> complaints;
    private Schedule schedule;
    private Transcript transcript;
    private Set<StudentOrganization> studentOrganizations;

    public Student(String login, String password, String name, String surname, String middleName,
            LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber,
            String email, FamilyStatuses familyStatus, String corporateEmail,
            double gpa, StudentOrganization studentLife, List<Major> majors,
            List<Request> requests, Faculty faculty, String studentId,
            Set<Complaint> complaints, Set<StudentOrganization> studentOrganizations,
            HashMap<Course,Mark> courses, boolean isResearcher) {
			 super(login, password, name, surname, middleName, dateOfBirth, gender, nationality,
			       phoneNumber, email, familyStatus, corporateEmail);
			 this.gpa = gpa;
			 this.studentLife = studentLife;
			 this.majors = majors;
			 this.requests = requests;
			 this.faculty = faculty;
			 this.studentId = studentId;
			 this.complaints = complaints;
			 this.studentOrganizations = studentOrganizations;			 
			 if (isResearcher) {
		            this.setAsResearcher(true);
		        }
}
    public Student(String name) {
        super();  // Call the parent constructor, if needed.
        this.setName(name); // Or assign the name appropriately.
    }
     
    public Student() {
        super();
    }
    public void setAsResearcher(boolean isResearcher) {
        if (isResearcher) {
            this.sr = new StudentResearcher(this,sr); 
        } else {
            this.sr = null; 
        }
    }

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

   


    public String viewTeacherInfo() {
        // Placeholder for fetching teacher information
        return "Teacher information not available.";
    }
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
  
