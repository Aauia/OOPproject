package Views;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Collections;
import java.io.IOException;
import java.util.Scanner;
import Education.*;
import Main.Data;
import User.*;

public class StudentView {
    private final Scanner in = new Scanner(System.in);

    // Show curriculum for the student's specialty and faculty
    public void showCurriculum(Student student) throws IOException {
        System.out.println("Curriculum:");
        Data.INSTANCE.getRup().stream()
                .filter(c -> c.getFaculty() == student.getFaculty() && c.getSpecialty() == student.getSpecialty())
                .forEach(System.out::println);
        save();
    }

    // Show student's schedule
    public void showSchedule(Student student) throws IOException {
        if (student.getSchedule() == null) {
            System.out.println("Your schedule is empty.");
            return;
        }

        System.out.println("Your schedule:" + student.getSchedule());
        save();
    }

    // Show transcript for the student
    public void showTranscript(Student student) throws IOException {
        Transcript transcript = student.getTranscript();
        if (transcript == null || transcript.getSemesterData().isEmpty()) {
            System.out.println("No transcript available.");
            return;
        }

        System.out.println("Transcript for " + student.getName() + ":");

        for (Map.Entry<Integer, Map<Course, ArrayList<Mark>>> semesterEntry : transcript.getSemesterData().entrySet()) {
            int semester = semesterEntry.getKey();
            System.out.println("Semester: " + semester);

            for (Map.Entry<Course, ArrayList<Mark>> courseEntry : semesterEntry.getValue().entrySet()) {
                Course course = courseEntry.getKey();
                List<Mark> marks = courseEntry.getValue();

                System.out.println("  Course: " + course.getCourseCode() + " - " + course.getCourseName());
                for (Mark mark : marks) {
                    String firstAttestation = mark.getFirstAttestation() == 0 ? "Not yet assigned" : String.valueOf(mark.getFirstAttestation());
                    String secondAttestation = mark.getSecondAttestation() == 0 ? "Not yet assigned" : String.valueOf(mark.getSecondAttestation());
                    String finalMark = mark.getSum() == 0? "Not yet assigned" : String.valueOf(mark.getSum());

                    System.out.println("    - First Attestation: " + firstAttestation);
                    System.out.println("    - Second Attestation: " + secondAttestation);
                    System.out.println("    - Final Mark: " + finalMark);
                    System.out.println("    - Status: " + (mark.getStatus() == null ? "Not yet assigned" : mark.getStatus()));
                    System.out.println("-----------------------------------");
                }
            }
        }
        save();
    }

    public void showRegisteredCourse(Student student) throws IOException {
        List<Course> registeredCourses = student.getRegisteredCourses();

        if (registeredCourses.isEmpty()) {
            System.out.println("You are not registered for any courses.");
        } else {
            System.out.println("Registered courses:");
            for (Course course : registeredCourses) {
                System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseCode() + ") - Credits: " + course.getCredit());
            }
        }
        save();
    }
    public void showRegisteredLessons(Student student) throws IOException {
        System.out.println("Next semester schedule Schedule:");
        if (student.getRegistratedSchedule() != null) {
            student.getRegistratedSchedule().displaySchedule();
        } else {
            System.out.println("No schedule available.");
        }
        save();
    }


    public void registerForCourse(Student student) throws IOException {
        // Fetch the specific curriculum for the student
        Curriculum studentCurriculum = student.getCurriculum(); // Assuming 'getCurriculum()' is a method in 'Student'

        // Lists to hold available and future free courses
        List<Course> availableCourses = new ArrayList<>();
        List<Course> futureFreeCourses = new ArrayList<>();

        // Get the courses based on the student's curriculum and semester
        if (studentCurriculum != null) {
            // Get courses for the student's current semester
            List<Course> currentSemesterCourses = studentCurriculum.getSemesterCourses().get(student.getSemester() + 1);
            if (currentSemesterCourses != null && !currentSemesterCourses.isEmpty()) {
                availableCourses.addAll(currentSemesterCourses);
            }

            // Get future free courses based on the student's current semester
            List<Course> freeCourses = studentCurriculum.getFreeCoursesForSemester(student.getSemester() + 1);
            futureFreeCourses.addAll(freeCourses);
        }

        // Display available courses for the current semester
        if (!availableCourses.isEmpty()) {
            System.out.println("Available courses for semester " + (student.getSemester() + 1) + ":");
            for (int i = 0; i < availableCourses.size(); i++) {
                Course course = availableCourses.get(i);
                System.out.println((i + 1) + ") " + course.getCourseName() + " (" + course.getCourseCode() + ") - Credits: " + course.getCredit());
            }
        } else {
            System.out.println("No courses available for this semester.");
        }

        // Display future free courses if credit requirements are not met
        int totalCredits = student.getTotalCredits();
        if (totalCredits < student.getRequiredCredits()) {
            int requiredCredits = student.getRequiredCredits() - totalCredits;
            System.out.println("You need " + requiredCredits + " more credits. You can register for the following FREE courses:");

            if (!futureFreeCourses.isEmpty()) {
                for (int i = 0; i < futureFreeCourses.size(); i++) {
                    Course course = futureFreeCourses.get(i);
                    System.out.println((i + 1) + ") " + course.getCourseName() + " (" + course.getCourseCode() + ") - Credits: " + course.getCredit());
                }
            }
        }

        // Allow the student to register for courses (both available and free courses) if credits are insufficient
        while (student.getTotalCredits() < student.getRequiredCredits()) {
            System.out.print("Enter the number of the course you would like to register for (or 0 to exit to free courses): ");
            int courseNumber = in.nextInt();
            in.nextLine(); // consume the newline character left by nextInt()

            if (courseNumber == 0 && totalCredits < student.getRequiredCredits()) {
                // If the student hasn't met the required credits, they can register for free courses
                if (!futureFreeCourses.isEmpty()) {
                    System.out.println("Registering for free courses...");
                    System.out.println("Choose a free course to register for:");
                    for (int i = 0; i < futureFreeCourses.size(); i++) {
                        Course course = futureFreeCourses.get(i);
                        System.out.println((i + 1) + ") " + course.getCourseName() + " (" + course.getCourseCode() + ") - Credits: " + course.getCredit());
                    }

                    System.out.print("Enter the number of the free course you would like to register for: ");
                    int freeCourseChoice = in.nextInt();
                    in.nextLine(); // consume the newline character left by nextInt()

                    if (freeCourseChoice > 0 && freeCourseChoice <= futureFreeCourses.size()) {
                        Course selectedFreeCourse = futureFreeCourses.get(freeCourseChoice - 1);
                        // Register the student for the free course
                        student.registerForCourse(selectedFreeCourse);
                        student.addCredits(selectedFreeCourse.getCredit());
                        System.out.println("Successfully registered for free course: " + selectedFreeCourse.getCourseName());
                        System.out.println("Your current total credits are: " + student.getTotalCredits());
                    } else {
                        System.out.println("Invalid free course selection.");
                    }
                } else {
                    System.out.println("No free courses available for registration.");
                    break;
                }
            } else if (courseNumber > 0 && courseNumber <= availableCourses.size()) {
                // Process registration for the available course
                Course selectedCourse = availableCourses.get(courseNumber - 1);

                // Check if prerequisites are met
                if (!hasPrerequisitesPassed(student, selectedCourse)) {
                    System.out.println("You have not passed the prerequisites for this course.");
                    continue;
                }

                // Check if the student is already registered for this course
                if (student.getRegisteredCourses().contains(selectedCourse)) {
                    System.out.println("You are already registered for this course.");
                } else {
                    // Register the student for the selected course
                    student.registerForCourse(selectedCourse);
                    System.out.println("You have successfully registered for: " + selectedCourse.getCourseName());

                    // Add the course's credits to the student's total credits for this registration
                    student.addCredits(selectedCourse.getCredit());
                    System.out.println("Your current total credits are: " + student.getTotalCredits());
                }

            } else {
                System.out.println("Invalid course selection.");
            }

            // Check if the student has met the required credits
            if (student.getTotalCredits() < student.getRequiredCredits()) {
                System.out.println("You need more credits. Required credits: " + student.getRequiredCredits());
            }
        }

        // Once the student has fulfilled the required credits, allow them to exit
        System.out.println("You have registered for enough courses. Your total credits: " + student.getTotalCredits());
        save();
    }


    public boolean hasPrerequisitesPassed(Student student, Course selectedCourse) {
        // Check if the student has passed all prerequisites for the selected course
        List<Course> prerequisites = selectedCourse.getPrerequisiteCourses();
        Transcript transcript = student.getTranscript();

        for (Course prerequisite : prerequisites) {
            boolean prerequisitePassed = false;

            // Loop through all semesters in the transcript
            for (Map.Entry<Integer, Map<Course, ArrayList<Mark>>> semesterEntry : transcript.getSemesterData().entrySet()) {
                for (Map.Entry<Course, ArrayList<Mark>> courseEntry : semesterEntry.getValue().entrySet()) {
                    Course course = courseEntry.getKey();
                    if (course.equals(prerequisite)) {
                        // Check if the student passed the prerequisite course
                        List<Mark> marks = courseEntry.getValue();
                        for (Mark mark : marks) {
                            if (mark.getStatus() != null && !mark.getStatus().equals("Failed")) {
                                prerequisitePassed = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!prerequisitePassed) {
                System.out.println("You cannot register for this course because you have not passed the prerequisite.");
                return false; // Student has not passed the prerequisite
            }
        }

        return true; // All prerequisites are passed
    }


    public void registerForLesson(Student student, Vector<Lesson> availableLessons) throws IOException {
        List<Course> registeredCourses = student.getRegisteredCourses();

        // Filter lessons to only those related to registered courses
        List<Lesson> eligibleLessons = availableLessons.stream()
                .filter(lesson -> registeredCourses.contains(lesson.getCourse()))
                .collect(Collectors.toList());

        if (eligibleLessons.isEmpty()) {
            System.out.println("No eligible lessons available for your registered courses.");
            return;
        }

        System.out.println("Eligible Lessons for Registration:");
        for (int i = 0; i < eligibleLessons.size(); i++) {
            Lesson lesson = eligibleLessons.get(i);
            System.out.println((i + 1) + ". " + lesson.getCourse().getCourseName() + " - " + lesson.getDay() + " "
                    + lesson.getTime() + " - Teacher: " + lesson.getTeacherID() + " (" + lesson.getLessonType()
                    + ") - Remaining Seats: " + lesson.getNumberOfStudents());
        }

        while (true) {
            System.out.print("Enter the number of the lesson to register (or 0 to finish): ");
            int lessonChoice = in.nextInt();
            in.nextLine(); // Consume newline

            if (lessonChoice == 0) {
                break;
            }

            if (lessonChoice > 0 && lessonChoice <= eligibleLessons.size()) {
                Lesson selectedLesson = eligibleLessons.get(lessonChoice - 1);

                // Check if the student has already registered for this course's lesson
                if (student.hasLesson(selectedLesson)) {
                    System.out.println("You have already registered for this lesson.");
                    continue;
                }

                // Ensure the student doesn't have another lesson at the same time
                boolean timeConflict = false;
                for (Lesson registeredLesson : student.getRegistratedSchedule().getLessons()) {
                    if (selectedLesson.getDay().equals(registeredLesson.getDay()) &&
                            selectedLesson.getTime().equals(registeredLesson.getTime())) {
                        timeConflict = true;
                        break;
                    }
                }

                if (timeConflict) {
                    System.out.println("You already have another lesson at this time. Please choose a different one.");
                    continue;
                }

                // Ensure the student registers only one lesson per course
                if (student.getRegistratedSchedule().getLessons().stream()
                        .anyMatch(lesson -> lesson.getCourse().equals(selectedLesson.getCourse()))) {
                    System.out.println("You can only register for one lesson per course.");
                    continue;
                }

                // Check if the lesson is full
                if (selectedLesson.getNumberOfStudents() <= 0) {
                    System.out.println("This lesson is already full.");
                    continue;
                }

                // Register the lesson
                student.getRegistratedSchedule().addLesson(selectedLesson);
                selectedLesson.setNumberOfStudents(selectedLesson.getNumberOfStudents() - 1); // Decrease student capacity
                System.out.println("Successfully registered for: " + selectedLesson.getCourse().getCourseName()
                        + " (" + selectedLesson.getLessonType() + ")");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        save();
    }


 void save() throws IOException {
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

    // Menu for student
    public void menu(Student student) throws IOException {
        try {
            while (true) {
                System.out.println("\nStudent Menu:");
                System.out.println("1) Show Curriculum");
                System.out.println("2) Show Schedule");
                System.out.println("3) Show Transcript");
                System.out.println("4) Register for cources");
                System.out.println("5) Show registrated cources");
                System.out.println("6) Register for lesson");
                System.out.println("7) Show registrated lesson schedule");
                System.out.println("8) Exit");

                System.out.print("Enter your choice: ");
                String choice = in.nextLine();

                switch (choice) {
                    case "1":
                        showCurriculum(student);
                        break;
                    case "2":
                        showSchedule(student);
                        break;
                    case "3":
                        showTranscript(student);
                        break;
                    case "4":
                    	registerForCourse(student);
                        break;
                    case "5":
                    	showRegisteredCourse(student);
                        break;
                    case "6":
                    	registerForLesson(student, Data.INSTANCE.getLessons());
                        break;
                    case "7":
                    	showRegisteredLessons(student); // Incorrectly modifies lessons during loading
                   break;
                    case "8":
                    	exit();
                        System.out.println("Exiting Student Menu.");
                        return;
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

