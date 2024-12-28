package Views;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

import Education.*;
import Main.Data;
import User.*;

public class adminView {
    private final Scanner in = new Scanner(System.in);



    private void printList(List list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + 1 + ")" + list.get(i));
    }
    public boolean showStudents() {
        if (Data.INSTANCE.getStudents().isEmpty()) {
            System.out.println("No students yet...Try adding one");
            return false;
        }
        printList(Data.INSTANCE.getStudents());
        return true;
    }

    public boolean showCourses() {
        if (Data.INSTANCE.getCourses().isEmpty()) {
            System.out.println("No courses yet...");
            return false;
        }
        printList(Data.INSTANCE.getCourses());
        return true;
    }
    public List<Lesson> createLessonsForCourse(int numLessons ) {
        Scanner scanner = new Scanner(System.in);
        List<Lesson> lessons = new ArrayList<>();
       

        for (int i = 0; i < numLessons; i++) {
            System.out.println("Enter the course code:  ");
            String courseCode = scanner.nextLine();
            Course course = Data.findCourseByCode(courseCode);
            
            System.out.println("Enter lesson ID: ");
            String lessonID = scanner.nextLine();
            
            System.out.println("Enter teacher for lesson: ");
            String teacher = scanner.nextLine();
            
            System.out.println("Enter lesson type (e.g., LECTURE, PRACTICAL): ");
            String lessonTypeStr = scanner.nextLine();
            LessonType lessonType = LessonType.valueOf(lessonTypeStr.toUpperCase());

            System.out.println("Enter room number: ");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter time: ");
            String time = scanner.nextLine();
            System.out.println("Enter day: ");
            String day = scanner.nextLine();

            // Create a new lesson for this course
            Lesson lesson = new Lesson(lessonID, teacher, course, lessonType, room,time , day, room);
            lessons.add(lesson);
        }

        return lessons;
    }





    public boolean showCurriculums(Faculties faculty, Specialties specialty, Integer semester) {
        // Filter curriculums based on provided parameters
        List<Curriculum> filteredCurriculums = Data.INSTANCE.getRup().stream()
                .filter(curriculum -> (faculty == null || curriculum.getFaculty() == faculty) &&
                        (specialty == null || curriculum.getSpecialty() == specialty) &&
                        (semester == null || curriculum.getSemesterCourses().containsKey(semester)))
                .collect(Collectors.toList());

        if (filteredCurriculums.isEmpty()) {
            System.out.println("No curriculums found with the provided filters.");
            return false;
        }

        // Display the filtered curriculums
        printList(filteredCurriculums);
        return true;
    }


    public boolean showCurriculumsByFilter() {
        System.out.println("Select a filter to apply:\n1) By Faculty\n2) By Specialization\n3) By Semester\n4) Show All");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                // Ask for faculty
                System.out.println("Enter the faculty name: ");
                String facultyName = in.next();
                Faculties faculty = null;
                try {
                    faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid faculty name. Please try again.");
                    return false;
                }
                return showCurriculums(faculty, null, null);

            case 2:
                // Ask for specialization (major)
                System.out.println("Enter the specialization: ");
                String specializationName = in.next();
                Specialties specialty = null;
                try {
                    specialty = Specialties.valueOf(specializationName.toUpperCase().replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid specialization name. Please try again.");
                    return false;
                }
                return showCurriculums(null, specialty, null);

            case 3:
                // Ask for semester
                System.out.println("Enter the semester number: ");
                int semesterNumber = in.nextInt();
                return showCurriculums(null, null, semesterNumber);

            case 4:
                // Show all curriculums
                return showCurriculums(null, null, null);

            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }


    private void save() throws IOException {
        Data.write();
    }

    private void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        // Basic Student Information
        System.out.println("Enter login: ");
        String login = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        System.out.println("Enter name: ");
        String name = in.next();
        System.out.println("Enter surname: ");
        String surname = in.next();
        System.out.println("Enter middle name: ");
        String middleName = in.next();
        System.out.println("Enter date of birth (YYYY-MM-DD): ");
        String dateString = in.next();
        LocalDate dateOfBirth = LocalDate.parse(dateString);
        System.out.println("Enter gender: ");
        String genderInput = in.next();
        Gender gender = Gender.valueOf(genderInput.toUpperCase());
        System.out.println("Enter nationality: ");
        String nationality = in.next();
        System.out.println("Enter phone number: ");
        Integer phoneNumber = in.nextInt();
        System.out.println("Enter email: ");
        String email = in.next();
        System.out.println("Enter family status: ");
        String familyStatusInput = in.next();
        FamilyStatuses familyStatus = FamilyStatuses.valueOf(familyStatusInput.toUpperCase());
        System.out.println("Enter corporate email: ");
        String corporateEmail = in.next();

        // Additional Student-specific fields
        System.out.println("Enter GPA: ");
        double gpa = in.nextDouble();
        System.out.println("Enter student ID: ");
        String studentId = in.next();

        // Ask if the student is a researcher
        System.out.println("Is the student a researcher (yes/no)? ");
        String isResearcherInput = in.next().toLowerCase();
        boolean isResearcher = isResearcherInput.equals("yes");

        // Ask for Faculty
        System.out.println("Enter faculty: ");
        String facultyInput = in.next();
        Faculties faculty = Faculties.valueOf(facultyInput.toUpperCase());

        // Ask for Student's Specialty
        System.out.println("Enter student's specialty: ");
        String specialtyInput = in.next();
        Specialties specialty = Specialties.valueOf(specialtyInput.toUpperCase());
        

        // Ask for Semester
        System.out.println("Enter current semester: ");
        int semester = in.nextInt();
        System.out.println("Enter number of lessons for course ");
        int numLessons = in.nextInt();
        List<Lesson> lessons = new ArrayList<>();
        lessons = createLessonsForCourse(numLessons);
        Schedule schedule = new Schedule(studentId,lessons);
       Curriculum curriculum = new Curriculum(specialty, faculty, null);
        Student newStudent = new Student(
                login, password, name, surname, middleName, dateOfBirth, gender,
                nationality, phoneNumber, email, familyStatus, corporateEmail, gpa,
                null, null, null, faculty, studentId, null, null, isResearcher, schedule, semester, specialty, null,curriculum
            );

            Data.INSTANCE.addStudent(newStudent);



    }



    public void addCourse() {
        System.out.println("Enter name of the course: ");
        String courseName = in.next();
        
        System.out.println("Enter course code: ");
        String courseCode = in.next();
        
        System.out.println("Enter the course type (MAJOR, FREE, ELECTIVE, SHARED): ");
        String typeInput = in.next().toUpperCase();
        Access_Course type = Access_Course.valueOf(typeInput);
        
        System.out.println("Enter the credit value: ");
        int credit = getValidIntegerInput("Enter course credit: ");
        
        // Initialize all required attributes based on the user input
        Integer  studentAmount = null;
        Vector<String> prerequisiteCourses = new Vector<>();
        Vector<Faculties> sharedFaculties = null;

        // Handling accessMajor (example)
  
        
        // Handling prerequisites
        System.out.println("Enter the number of prerequisite courses: ");
        int numPrereqs = getValidIntegerInput("Enter number of prerequisites: ");
        for (int i1 = 0; i1 < numPrereqs; i1++) {
            System.out.println("Enter prerequisite course code for course " + (i1 + 1) + ": ");
            String prereqCourseCode = in.next();
            prerequisiteCourses.add(prereqCourseCode);
        }
        
        // Handling shared faculties only for SHARED type
        if (type == Access_Course.SHARED) {
            sharedFaculties = new Vector<>();
            System.out.println("Enter the number of shared faculties: ");
            int numFaculties = getValidIntegerInput("Enter number of shared faculties: ");
            for (int i1 = 0; i1 < numFaculties; i1++) {
                System.out.println("Enter shared faculty name for faculty " + (i1 + 1) + ": ");
                String facultyName = in.next();
                Faculties faculty;
                faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
                sharedFaculties.add(faculty); // Assuming Faculties class has this constructor
            }
        }

        // Create a new Course object
        Course newCourse = new Course(courseCode, courseName, type, credit,  null, sharedFaculties, numPrereqs, numPrereqs);
        
        // Add the course to your course list (assuming Data.INSTANCE.getCourses() is your course list)
        Data.INSTANCE.getCourses().add(newCourse);
        System.out.println("Course added successfully!");
        }
        
        
        

    
 
    public void addCurriculum() {
        System.out.println("Enter the major name: ");
        String majorName = in.next();
        System.out.println("Enter the faculty for the major: ");
        String facultyName = in.next();

        Faculties faculty;
        Specialties specialty;
        try {
            faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
            specialty= Specialties.valueOf(majorName.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid faculty name. Please try again.");
            return;
        }

        Map<Integer, List<Course>> semesterCourses = new HashMap<>();
        int numSemesters = getValidIntegerInput("Enter number of semesters: ");
        for (int i = 1; i <= numSemesters; i++) {
            System.out.println("Enter number of courses for semester " + i + ": ");
            int numCourses = getValidIntegerInput("");
            List<Course> coursesForSemester = new ArrayList<>();
            for (int j = 0; j < numCourses; j++) {
                System.out.println("Enter the course name for semester " + i + ": ");
                String courseName = in.next();
                System.out.println("Enter the course code: ");
                String courseCode = in.next();
                System.out.println("Enter course type (MAJOR, FREE, ELECTIVE): ");
                String typeInput = in.next().toUpperCase();
                Access_Course type = Access_Course.valueOf(typeInput);
                System.out.println("Enter the credit value: ");
                int credit = getValidIntegerInput("");

                // Create the course and add it to the list for this semester
                Course course = Data.findCourseByCode(courseCode);
                
                
                coursesForSemester.add(course);
            }
            // Add the list of courses for this semester to the map
            semesterCourses.put(i, coursesForSemester);
        }

        // Create the new curriculum and add it to the Data
        Data.INSTANCE.getRup().add(new Curriculum(specialty, faculty, semesterCourses));
        System.out.println("Curriculum added!");
    }

    private int getValidIntegerInput(String prompt) {
        int input = -1;
        while (input == -1) {
            try {
                if (!prompt.isEmpty()) {
                    System.out.println(prompt);
                }
                input = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.next();
            }
        }
        return input;
    }

    public void run() throws IOException {
        try {
            System.out.println("Welcome admin!");

            menu: while (true) {
                System.out.println("What do you want to do?\n 1) Add student \n 2) Add course \n 3) Add course to a Student \n 4) View students \n 5) Add Curriculum \n 6) Exit \n 7) Show Courses \n 8)Show curriculum");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        addStudent: while (true) {
                            addStudent();
                            System.out.println("\n 1) Add another student \n 2) Return back \n 3) Exit");
                            choice = in.nextInt();
                            if (choice == 1) continue addStudent;
                            if (choice == 2) continue menu;
                            if (choice == 3) {
                                exit();
                                break menu;
                            }
                            break;
                        }
                        break;
                    case 2:
                        addCourse: while (true) {
                            addCourse();
                            System.out.println("\n 1) Add another course \n 2) Return back \n 3) Exit");
                            choice = in.nextInt();
                            if (choice == 1) continue addCourse;
                            if (choice == 2) continue menu;
                            if (choice == 3) {
                                exit();
                                break menu;
                            }
                            break;
                        }
                        break;
                    case 3:
                        addCourseToStudent: while (true) {
                            System.out.println("Choose student to which you want to add course: (Enter number)");
                            if (!showStudents()) continue menu;
                            Student s = Data.INSTANCE.getStudents().get(in.nextInt() - 1);
                            System.out.println("Choose course: (Enter number)");
                            if (!showCourses()) continue menu;
                            /*addCourseToStudent(s);*/
                            System.out.println("\n 1) Add another course to some student \n 2) Return back \n 3) Exit");
                            choice = in.nextInt();
                            if (choice == 1) continue addCourseToStudent;
                            if (choice == 2) continue menu;
                            if (choice == 3) {
                                exit();
                                break menu;
                            }
                            break;
                        }
                        break;
                    case 4:
                        if (!showStudents()) continue menu;
                        System.out.println("\n 1) Return back \n 2) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue menu;
                        if (choice == 2) {
                            exit();
                            break menu;
                        }
                        break;
                    case 5:
                        addCurriculum();
                        continue menu;
                    case 6:
                        exit();
                        break menu;
                    case 7:
                        showCourses();
                        continue menu;
                    case 8:	
                        System.out.println("Enter the major name: ");
                        String majorName = in.next();
                        System.out.println("Enter the faculty for the major: ");
                        String facultyName = in.next();

                        Faculties faculty;
                        Specialties specialty;
                        try {
                            faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
                            specialty= Specialties.valueOf(majorName.toUpperCase().replace(" ", "_"));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid faculty name. Please try again.");
                            return;
                        }
                        System.out.println("Enter semester: ");
                        Integer sem = in.nextInt();
                        if (!showCurriculums(faculty, specialty, sem)) continue menu;
                        System.out.println("\n 1) Return back \n 2) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue menu;
                        if (choice == 2) {
                            exit();
                            break menu;
                        }
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            save();
        }
    }

}
