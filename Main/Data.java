package Main;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import Education.*;
import User.*;

import java.util.stream.Stream;
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    

    protected Vector<Student> students;
    protected Vector<Employee> employees;
    protected Vector<Dean> deans;
    protected Vector<Teacher> teachers;  
    protected Vector<Manager> managers;
    public Vector<Course> courses;        
    protected Vector<Lesson> lessons;
    private Vector<Curriculum> rup;
    private Vector<String> specialty;
    protected Vector<Admin> admins;
    protected Vector<News> newsList;
    protected Vector<Librarian> librarians;; 
    private Vector<Book> books;
    private Vector<Journal> journals;
    protected Vector<Complaint> complaints;
    protected Vector<Request> requests;
    protected Vector<Researcher> researchers;
    protected Vector<ResearchPaper> researchPapers;
    protected Vector<ResearchProject> researchProjects;

    
    public static Data INSTANCE;

    static {
        try {
            if (new File("UniversityData").exists()) {
                INSTANCE = read();
            }
            if (INSTANCE == null) {
                INSTANCE = new Data();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log exception details
            INSTANCE = new Data(); // Fallback to a new instance
        }
        
        // Ensure all critical fields are initialized
        if (INSTANCE.requests == null) INSTANCE.requests = new Vector<>();
        if (INSTANCE.complaints == null) INSTANCE.complaints = new Vector<>();
    }

     private Data() {
    	 deans = new Vector<>();
        students = new Vector<>();
        teachers = new Vector<>();
        managers= new Vector<>();
        courses = new Vector<>();
        lessons = new Vector<>();
        specialty = new Vector<>();
        admins = new Vector<>();
        rup = new Vector<>();
        newsList = new Vector<>();
        librarians = new Vector<>();
        books = new Vector<>();
        journals = new Vector<>();
    	complaints=new Vector<>();
        requests = new Vector<>();
        researchPapers= new Vector<>();
        researchProjects= new Vector<>();
        researchers=new Vector<>();
     }
        

     private static void saveData() {
         try {
             Data.write();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    
     
     
     

    public static void write() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("UniversityData");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(INSTANCE);
            System.out.println("Data has been written to file 'UniversityData'.");
        }
    }


    public static Data read() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UniversityData"))) {
            return (Data) ois.readObject();
        }
    }


    private <T> void addAndSaveWithStream(Vector<T> collection, T data) {
        Stream.of(data).forEach(collection::add);
        saveData();  // Save after the addition
    }
    
    public static int nextStudentId() {
        return INSTANCE.students.size() + 1;
    }


    public static int nextTeacherId() {
        return INSTANCE.teachers.size() + 1;
    }

      
    public void addCurriculum(Curriculum curriculum) {
        addAndSaveWithStream(rup, curriculum);
    }

    public void addStudent(Student student) {
        addAndSaveWithStream(students, student);
    }
    public void addAdmin(Admin admin) {
    	addAndSaveWithStream(admins, admin);
    }
    public void addTeacher(Teacher teacher) {
    	addAndSaveWithStream(teachers, teacher);
    }

    public void addCourse(Course course) {
    	addAndSaveWithStream(courses, course);
    }
    public void addRequest(Request request) {
    	addAndSaveWithStream(requests, request);
    }
	public void addManagers(Manager manager) {
		addAndSaveWithStream(managers, manager);
		
	}


    public void addLesson(Lesson lesson) {
    	addAndSaveWithStream(lessons, lesson);
    }
    public void addSpecialty(String spe) {
        specialty.add(spe);
    }
    public Vector<String> getSpecialty(){
    	return specialty;
    }
    
    public Vector<Curriculum> getCurriculum(){
    	return rup;
    }
    public Vector<Student> getStudents() {
        return students;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }
    public Vector<Dean> getDeans() {
        return deans;
    }
    public Vector<Admin> getAdmins() {
        return admins;
    }

    public Vector<Course> getCourses() {
        return courses;
    }
    public Vector<Librarian> getLibrarians() {
        return librarians;
    }

    public Vector<Lesson> getLessons() {
        return lessons;
    }

     public Vector<Request> getRequests() {
	 return requests;
     }
     public Vector<Curriculum> getRup() {
 		return rup;
 	}
     public Vector<News> getNewsList() {
 	    return newsList;
 	}
     public Vector<Journal> getJournals() {
     	if (journals == null) {
             journals = new Vector<>();  // Initialize if still null
         }
         return journals;
     }
     public Vector<Manager> getManagers() {
 		// TODO Auto-generated method stub
 		return managers;
 	}

     
     
     public void updateCurriculumCourses(int semester, Specialties specialty, Faculties faculty, List<Course> newCourses) {
    	    // Find the curriculum for the given specialty and faculty
    	    Curriculum curriculum = getCurriculumByFacultyAndSpecialty(faculty, specialty);

    	    if (curriculum != null) {
    	        // Add courses for the given semester
    	        curriculum.addCoursesForSemester(semester, newCourses);
    	        // Optionally, save the data after modification
    	        saveData();
    	    } else {
    	        System.out.println("Curriculum not found for the given specialty and faculty.");
    	    }
    	}

    
    public static Course findCourseByCode(String courseCode) {
        return Data.INSTANCE.getCourses().stream()  // Access courses from the singleton instance
                              .filter(course -> course.getCourseCode().equals(courseCode))  // Filter by course code
                              .findFirst()  // Get the first match
                              .orElse(null);  // Return null if no match is found
    }
    public static Student findStudentById(String studentId) {
        return Data.INSTANCE.getStudents().stream()  // Access courses from the singleton instance
                              .filter(student -> student.getStudentId().equals(studentId))  // Filter by course code
                              .findFirst()  // Get the first match
                              .orElse(null);  // Return null if no match is found
    }
    public static Person findUserByLoginAndPassword(String login, String password) {
        // Combine all user streams and search for the matching user
        return Stream.of(
                    Data.INSTANCE.getStudents().stream(),
                    Data.INSTANCE.getTeachers().stream(),
                    Data.INSTANCE.getAdmins().stream(),
                    Data.INSTANCE.getLibrarians().stream(),
                    Data.INSTANCE.getDeans().stream(), // Assuming getDeans exists
                    Data.INSTANCE.getManagers().stream()
                )
                .flatMap(stream -> stream) // Flatten the streams into a single stream
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private Curriculum getCurriculumByFacultyAndSpecialty(Faculties faculty, Specialties specialty) {
        return rup.stream()
                  .filter(c -> c.getFaculty() == faculty && c.getSpecialty() == specialty)
                  .findFirst()
                  .orElse(null);  // Return null if no curriculum matches
    }


   
    public void displayData() {
        System.out.println("Students:");
        students.forEach(System.out::println);
        System.out.println("Teachers:");
        teachers.forEach(System.out::println);
        System.out.println("Courses:");
        courses.forEach(System.out::println);
        System.out.println("Lessons:");
        lessons.forEach(System.out::println);
        System.out.println("Rups:");
        getRup().forEach(System.out::println);
    }


	

	public void setRup(Vector<Curriculum> rup) {
		this.rup = rup;
	}
	public void publishNews(News news) {
	    newsList.add(news);
	}

	
	public Vector<Book> getBooks() {
        return books;
    }
	
	public void addJournal(Journal journal) {
        addAndSaveWithStream(journals, journal);
    }
	    
	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}

	public Vector<ResearchProject> getResearchProjects() {
		return researchProjects;
	}

	public void setResearchProjects(Vector<ResearchProject> researchProjects) {
		this.researchProjects = researchProjects;
	}

	public void setResearchPapers(Vector<ResearchPaper> researchPapers) {
		this.researchPapers = researchPapers;
	}

	public Vector<ResearchProject> getReseachProjects() {
		return researchProjects;
	}

	public void setReseachProjects(Vector<ResearchProject> reseachProjects) {
		this.researchProjects = reseachProjects;
	}

	public Vector<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(Vector<Researcher> researchers) {
		this.researchers = researchers;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}

	private static int currentComplaintID = 0; // Хранит последний сгенерированный ID

	public Integer generateComplaintID() {
	    currentComplaintID++; // Увеличиваем текущий ID
	    return currentComplaintID; // Возвращаем новый уникальный ID
	}
	public void addResearchPaper(ResearchPaper paper) {
        if (researchPapers == null) {
            researchPapers = new Vector<>();  // Fallback initialization
        }
        researchPapers.add(paper);
    }
    public void addResearchProject(ResearchProject project) {
        if (researchProjects == null) {
        	researchProjects = new Vector<>();  // Fallback initialization
        }
        researchProjects.add(project);
    }

	public void resetNews() {
        newsList.clear();
        System.out.println("All news has been reset.");
    }
	
	public void resetLibrary() {
        books.clear();
        System.out.println("All library has been reset.");
    }
	
	
	public void resetJournal() {
        journals.clear();
    }
	public void resetPapers() {
        researchPapers.clear();
    }
	public void resetDeans() {
        deans.clear();
    }

    public void resetStudents() {
        students.clear();
    }

    public void resetTeachers() {
        Data.INSTANCE.teachers.clear();
    }

    public void resetManagers() {
        managers.clear();
    }

    public void resetCourses() {
        courses.clear();
    }

    public void resetLessons() {
        lessons.clear();
    }

    public void resetSpecialty() {
        specialty.clear();
    }

    public void resetAdmins() {
        admins.clear();
    }

    public void resetRup() {
        rup.clear();
    }

    public void resetLibrarians() {
        librarians.clear();
    }

    public void resetComplaints() {
        complaints.clear();
    }

    public void resetRequests() {
        requests.clear();
    }

    public void resetResearchProjects() {
        researchProjects.clear();
    }

    public void resetResearchers() {
        researchers.clear();
    }



	}

