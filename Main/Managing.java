package Main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import Education.*;
import User.*;


public class Managing {
    Scanner in = new Scanner(System.in);

    private void printList(List list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + 1 + ")" + list.get(i));
    }

    public boolean showStudents() {
        if (Data.INSTANCE.students.isEmpty()) {
            System.out.println("No students yet...Try adding one");
            return false;
        }
        printList(Data.INSTANCE.students);
        return true;
    }

    public boolean showCourses() {
        if (Data.INSTANCE.courses.isEmpty()) {
            System.out.println("No courses yet...");
            return false;
        }
        printList(Data.INSTANCE.courses);
        return true;
    }

    public boolean showCurriculums() {
        if (Data.INSTANCE.rup.isEmpty()) {
            System.out.println("No curriculums yet...");
            return false;
        }
        printList(Data.INSTANCE.rup);
        return true;
    }

    public boolean showCurriculumsForFaculty() {
        System.out.println("Enter the faculty name: ");
        String facultyName = in.next();

        Faculties faculty;
        try {
            faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid faculty name. Please try again.");
            return false;
        }

        List<Curriculum> filteredCurriculums = new ArrayList<>();
        for (Curriculum curriculum : Data.INSTANCE.rup) {
            if (curriculum.getFaculty() == faculty) {
                filteredCurriculums.add(curriculum);
            }
        }

        if (filteredCurriculums.isEmpty()) {
            System.out.println("No curriculums found for faculty: " + facultyName);
            return false;
        }

        System.out.println("Curriculums for faculty: " + facultyName);
        printList(filteredCurriculums);
        return true;
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

    private void addStudent() {
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

        // Create the new Student object
        Student newStudent = new Student(login, password, name, surname, middleName, dateOfBirth, gender, 
                                          nationality, phoneNumber, email, familyStatus, corporateEmail, 
                                          gpa, null, null, null, null, studentId, null, null, null, false);

        Data.INSTANCE.students.add(newStudent);  // Add the new student to the list
        System.out.println("Student added! ");
    }

    private void addCourse() {
        System.out.println("Enter name of the course: ");
        String courseName = in.next();
        System.out.println("Enter course code: ");
        String courseCode = in.next();
        System.out.println("Enter the course type (MAJOR, FREE, ELECTIVE): ");
        String typeInput = in.next().toUpperCase();
        Access_Course type = Access_Course.valueOf(typeInput);
        System.out.println("Enter the credit value: ");
        int credit = getValidIntegerInput("");

        Course newCourse = new Course(courseCode, courseName, type, credit);
        Data.INSTANCE.courses.add(newCourse);
        System.out.println("Course added! ");
    }

    private void addCurriculum() {
        System.out.println("Enter the major name: ");
        String majorName = in.next();
        System.out.println("Enter the faculty for the major: ");
        String facultyName = in.next();

        Faculties faculty;
        try {
            faculty = Faculties.valueOf(facultyName.toUpperCase().replace(" ", "_"));
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
                Course course = new Course(courseCode, courseName, type, credit);
                coursesForSemester.add(course);
            }
            // Add the list of courses for this semester to the map
            semesterCourses.put(i, coursesForSemester);
        }

        // Create the new curriculum and add it to the Data
        Data.INSTANCE.rup.add(new Curriculum(majorName, faculty, semesterCourses));
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
            System.out.println("Welcome!");
            menu: while (true) {
                System.out.println("What do you want to do?\n 1) Add student \n 2) Add course \n 3) Add course to a Student \n 4) View students \n 5) Add Curriculum \n 6) Exit \n 7) Show Cources");
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
                            Student s = Data.INSTANCE.students.get(in.nextInt() - 1);
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

