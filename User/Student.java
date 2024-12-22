package User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Set;
//import javax.swing.JTable;
import Education.*;
public class Student extends Person  {
    private double gpa;
    private StudentOrganization studentLife;
    private List<Major> majors;
    private List<Request> requests;
    private Faculties faculty;
    private String studentId;
    public StudentResearcher sr;
    private Set<Complaint> complaints;
    private Schedule schedule;
    private Schedule registratedSchedule;
    private Transcript transcript;
    private Set<StudentOrganization> studentOrganizations;
    private int semester;
    private Specialties specialty;
    private List<Course> registeredCourses;
    private int credits;
    private Curriculum curriculum;
    private boolean isResearcher;

    public Student(String login, String password, String name, String surname, String middleName,
            LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber,
            String email, FamilyStatuses familyStatus, String corporateEmail,
            double gpa, StudentOrganization studentLife, List<Major> majors,
            List<Request> requests, Faculties faculty, String studentId,
            Set<Complaint> complaints, HashMap<Course, Mark> courses, 
            boolean isResearcher,Schedule schedule, int semester, Specialties specialty,  Transcript transcript,Curriculum curriculum)
 {
			 super(login, password, name, surname, middleName, dateOfBirth, gender, nationality,
			       phoneNumber, email, familyStatus, corporateEmail);
			 this.gpa = gpa;
			 this.studentLife = studentLife;
			 this.majors = majors;
			 this.requests = requests;
			 this.faculty = faculty;
			 this.studentId = studentId;
			 this.complaints = complaints;
			 this.schedule = schedule;
			 this.registratedSchedule = new Schedule(studentId, new ArrayList<>());
			 if (isResearcher) {
		            this.setAsResearcher(true);
		        }
		        this.isResearcher = isResearcher;
			 this.semester = semester;
			 this.specialty = specialty;
			 this.transcript = transcript;
			 this.curriculum = curriculum;
			 this.registeredCourses = new ArrayList<>();
			 this.credits = 0;
			
			 generateTranscriptForCurriculum();
}
    public Student(String name) {
        super();  // Call the parent constructor, if needed.
        this.setName(name); // Or assign the name appropriately.
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
    public int getSemester() {
        return semester;
    }
    public void  setSemester(int semester) {
        this.semester = semester;
    }

    public Specialties getSpecialty() {
        return specialty;
    }
    public void setSpecialty(Specialties specialty) {
        this.specialty = specialty;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
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
    public void viewTranscript() {
        transcript.displayTranscript();
    }
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    private void generateTranscriptForCurriculum() {
        // Iterate over all semesters and add courses to the transcript
        for (Map.Entry<Integer, List<Course>> entry : curriculum.getSemesterCourses().entrySet()) {
            int semester = entry.getKey();

            // Only add courses for semesters that are less than or equal to the student's current semester
            if (semester <= this.semester) {
                List<Course> courses = entry.getValue();

                // For each course in the semester, initialize it in the transcript
                for (Course course : courses) {
                    transcript.initializeTranscriptForCourse(semester, course);
                }
            }
        }
    }


    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
    }

    public boolean isRegisteredForCourse(Course course) {
        return registeredCourses.contains(course);
    }
    public boolean hasFulfilledCredits() {
        return credits >= 7;
    }
    public Schedule getRegistratedSchedule() {
        if (this.registratedSchedule == null) {
            this.registratedSchedule  = new Schedule(this.studentId, new ArrayList<>());
        }
        return this.registratedSchedule ;
    }


    public void setRegistratedSchedule(Schedule registratedSchedule) {
        this.registratedSchedule = registratedSchedule;
    }
    public void addLesson(Lesson lesson) {
    	registratedSchedule.addLesson(lesson);
    }

    // Display student's schedule
    public void displayRegistratedSchedule() {
    	registratedSchedule.displaySchedule();
    }

    // Check if a lesson is already in the student's schedule
    public boolean hasLesson(Lesson lesson) {
        return registratedSchedule.getLessons().contains(lesson);
    }

    


	public Faculties getFaculty() {
		// TODO Auto-generated method stub
		return faculty;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student= (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
	public int getRequiredCredits() {
		return 7;
	}
	public void addCredits(Integer credit) {
		credits+=credit;
		
		
	}
	public int getTotalCredits() {
		return credits;
	}
	public Curriculum getCurriculum() {
		// TODO Auto-generated method stub
		return curriculum;
	}
	public boolean isResearcher() {
		return isResearcher;
	}
	
}
  

