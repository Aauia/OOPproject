package User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import javax.swing.JTable;
import Education.*;
import Main.Data;

public class Teacher extends Employee {

	private static final long serialVersionUID = 1L;
	private TeacherTypes degree;
    private String teacherID;
    private Set<Complaint> complaints;
    private Set<TeacherResearcher> teacherResearchers;
    private Set<Course> courses;
    private TeacherResearcher ts; 

    public Teacher(String login, String password, String name, String surname, String middleName,
                   LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                   FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
                   TeacherTypes degree, String teacherID,boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email,
              familyStatus, corporateEmail, salary, timeOfExperience,isResearcher);
        this.degree = degree;
        this.teacherID = teacherID;
        this.complaints = new HashSet<>();
        this.teacherResearchers = new HashSet<>();
        this.courses = new HashSet<>();
        
        if (isResearcher) {
            this.setAsResearcher(true); 
        }
    }

    public void setAsResearcher(boolean isResearcher) {
    	 if (this.degree == TeacherTypes.PROFESSOR && !isResearcher) {
    	        throw new ProfessorResearcherException("A Professor must be a researcher.");
    	    }

    	    if (isResearcher) {
    	        this.ts = new TeacherResearcher(this, ts);
    	    } else {
    	        this.ts = null;
    	    }
    }
    
    
    public void putMark(int semester, String studentId, String courseCode, Mark mark) {
        // Validate if the course is taught by this teacher
        Course course = Data.INSTANCE.findCourseByCode(courseCode);
        if (course == null || !courses.contains(course)) {
            System.out.println("Error: Course not found or not assigned to this teacher.");
            return;
        }

        // Find the student
        Student student = Data.INSTANCE.findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student not found for ID: " + studentId);
            return;
        }

        // Add the mark to the student's transcript
        Transcript transcript = student.getTranscript();
        transcript.addMarksForCourse(semester, course, mark);
        System.out.println("Mark added to " + student.getName() + "'s transcript for course: " + course.getCourseName());
    }



    
    public TeacherTypes getDegree() {
        return degree;
    }
    
 
    public void setDegree(TeacherTypes degree) {
        this.degree = degree;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void addComplaint(Complaint complaint) {
        this.complaints.add(complaint);
    }

    public Set<TeacherResearcher> getTeacherResearchers() {
        return teacherResearchers;
    }

    public void addTeacherResearcher(TeacherResearcher researcher) {
        this.teacherResearchers.add(researcher);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> viewCourses() {
        return List.copyOf(courses);
    }

  
}