package Main;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import Education.*;
import User.*;

import java.util.function.Consumer;
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
        if (new File("UniversityData").exists()) {
            try {
                INSTANCE = read();
            } catch (Exception e) {
                e.printStackTrace();
                INSTANCE = new Data();  
            }
        } else {
            INSTANCE = new Data();
        }
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
        requests=new Vector<>();
        researchPapers= new Vector<>();
        researchProjects= new Vector<>();
        researchers=new Vector<>();
        
        
        admins.add(new Admin("admin1", "password123", "John", "Doe", "Middle", 
                LocalDate.of(1980, 5, 15), Gender.MALE, "American", 
                1234567890, "admin1@example.com", FamilyStatuses.SINGLE, 
                "jdoe@university.edu", 5000.0, "10 years", "AdminHead", false));
        admins.add(new Admin("admin2", "pass456", "Jane", "Smith", "Middle", 
                LocalDate.of(1990, 3, 20), Gender.FEMALE, "British", 
                987654321, "admin2@example.com", FamilyStatuses.MARRIED, 
                "jsmith@university.edu", 4500.0, "5 years", "AdminAssistant", false));
        courses.add(new Course("CS101", "Introduction to Computer Science", Access_Course.MAJOR, 3, 100, null,null));
        courses.add(new Course("MATH101", "Calculus I", Access_Course.MAJOR, 4, 80, null, null));

        students.add(new Student("student2", "password2", "Bob", "Williams", "Middle", 
                LocalDate.of(1999, 9, 15), Gender.MALE, "British", 
                987654321, "student2@example.com", FamilyStatuses.MARRIED, 
                "bob.williams@university.edu", 3, null, 
                null,null, Faculties.SITE, "S67890", null, 
                new HashMap<>(), true, new Schedule("S67890",null), 3, Specialties.CS_SE, new Transcript("S67890")));
        
        teachers.add(new Teacher("T123", "password123", "Dr. Smith", "John", "M", LocalDate.of(1980, 5, 15),
                Gender.MALE, "American", 123456789, "dr.smith@example.com", FamilyStatuses.SINGLE,
                "dr.smith@university.edu", 50000, "10 years", TeacherTypes.PROFESSOR, "T1001", true));
        managers.add(new Manager(
                "manager01",                
                "securePassword",          
                "Marat",                       
                "Bystrov",                       
                "Axmetov",                      
                LocalDate.of(1985, 5, 20),    
                Gender.MALE,                 
                "American",                 
                1234567890,                  
                "john.doe@example.com",   
                FamilyStatuses.MARRIED,       
                "john.doe@corporate.com",  
                75000.0,                     
                "5 years",                  
                ManagerTypes.officeRegister, 
                "MGR12345",                   
                true                         
            ));
        librarians.add(new Librarian(
        	    "librarian01",              // Login
        	    "securePassword",           // Password
        	    "Marat",                    // First Name
        	    "Bystrov",                  // Surname
        	    "Axmetov",                  // Middle Name
        	    LocalDate.of(1985, 5, 20),  // Date of Birth
        	    Gender.MALE,                // Gender
        	    "American",                 // Nationality
        	    1234567890,                 // Phone Number
        	    "marat.bystrov@example.com",// Email
        	    FamilyStatuses.MARRIED,     // Family Status
        	    "marat.bystrov@library.com",// Corporate Email
        	    50000.0,                    // Salary
        	    "3 years",                  // Time of Experience
        	    false                       // Is Researcher
        	));
        deans.add(
        	    new Dean(
        	        "dean01",                   // Login
        	        "securePassword",           // Password
        	        "Nursultan",                // First Name
        	        "Nazarbayev",               // Surname
        	        "Amanzholovich",            // Middle Name
        	        LocalDate.of(1975, 4, 15),  // Date of Birth
        	        Gender.MALE,                // Gender
        	        "Kazakh",                   // Nationality
        	        9876,                 // Phone Number
        	        "nursultan.n@example.com",  // Email
        	        FamilyStatuses.MARRIED,     // Family Status
        	        "nursultan.n@university.com", // Corporate Email
        	        75000.0,                    // Salary
        	        "10 years",                 // Time of Experience
        	        false                        // Is Researcher
        	    ));
        deans.add(
        	    new Dean(
        	        "dean05",                   // Login
        	        "securePasswordjsdn",           // Password
        	        "Nurzhan",                // First Name
        	        "Narkomanov",               // Surname
        	        "Amanzholovich",            // Middle Name
        	        LocalDate.of(1975, 4, 15),  // Date of Birth
        	        Gender.MALE,                // Gender
        	        "Kazakh",                   // Nationality
        	        9876,                 // Phone Number
        	        "vdfjnvks.n@example.com",  // Email
        	        FamilyStatuses.MARRIED,     // Family Status
        	        "nursdjvnsktan.n@university.com", // Corporate Email
        	        75000.0,                    // Salary
        	        "10 years",                 // Time of Experience
        	           true                     // Is Researcher
        	    ));
        
        journals.add(new Journal("Robotics"));
        journals.add(new Journal("Business"));
        journals.add(new Journal("Nature"));

        

     }
     public static void saveData() {
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
    	File file = new File("UniversityData");
        if (!file.exists()) {
            System.out.println("File not found, creating new data...");
            return new Data();  // Return an empty Data object if the file doesn't exist
        }
        try (FileInputStream fis = new FileInputStream("UniversityData");
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            return (Data) oin.readObject();
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
                    Data.INSTANCE.getDeans().stream() // Assuming getDeans exists
                )
                .flatMap(stream -> stream) // Flatten the streams into a single stream
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
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


	public Vector<Curriculum> getRup() {
		return rup;
	}



	public void setRup(Vector<Curriculum> rup) {
		this.rup = rup;
	}
	public void publishNews(News news) {
	    newsList.add(news);
	}

	public Vector<News> getNewsList() {
	    return newsList;
	}
	public void resetNews() {
        newsList.clear();
        System.out.println("All news has been reset.");
    }
	
	public void resetLibrary() {
        books.clear();
        System.out.println("All library has been reset.");
    }
	
	public Vector<Book> getBooks() {
        return books;
    }
	
	public void addJournal(Journal journal) {
        journals.add(journal);
        addAndSaveWithStream(journals, journal);
    }

    public Vector<Journal> getJournals() {
    	if (journals == null) {
            journals = new Vector<>();  // Initialize if still null
        }
        return journals;
    }
    private Set<Manager> getManagers() {
		// TODO Auto-generated method stub
		return null;
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
//	public void addResearchProject(ResearchProject project) {
//		reseachProjects.add(project);
//		
//	}
}