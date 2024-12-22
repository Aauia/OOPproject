package Views;

import java.io.IOException;
import java.util.Scanner;
import Education.*;
import Main.Data;
import User.*;

public class TeacherView {
    private final Scanner in = new Scanner(System.in);

    // Constructor
    public TeacherView() {
    }

    // Menu for the teacher
    public void menu(Teacher teacher) throws IOException {
        try {
            while (true) {
                System.out.println("\nTeacher Menu:");
                System.out.println("1) View Courses");
                System.out.println("2) Assign Marks to Students");
                System.out.println("3) View Student Transcript");
                System.out.println("4) Exit");

                System.out.print("Enter your choice: ");
                String choice = in.nextLine();

                switch (choice) {
                    case "1":
                        viewCourses();
                        break;
                    case "2":
                        assignMarks(teacher);
                        break;
                    case "3":
                        viewStudentTranscript(teacher);
                        break;
                    case "4":
                        System.out.println("Exiting Teacher Menu.");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong... Saving resources...");
            e.printStackTrace();
            save();
        }
    }

    // View available courses
    public void viewCourses() {
        if (Data.INSTANCE.getCourses().isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("Available Courses:");
        Data.INSTANCE.getCourses().forEach(course -> System.out.println(course.getCourseCode() + ": " + course.getCourseName()));
    }

    // Assign marks to students
    public void assignMarks(Teacher teacher) {
        System.out.print("Enter student ID: ");
        String studentId = in.nextLine();

        Student student = Data.INSTANCE.findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = in.nextLine();

        Course course = Data.INSTANCE.findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter semester: ");
        int semester = in.nextInt();

        // Consume the newline character left by nextInt
        in.nextLine();

        System.out.print("Enter first attestation mark: ");
        double firstAttestation = Double.parseDouble(in.nextLine());

        System.out.print("Enter second attestation mark: ");
        double secondAttestation = Double.parseDouble(in.nextLine());

        System.out.print("Enter final mark: ");
        double finalMark = Double.parseDouble(in.nextLine());

        // Create the Mark and add it to the student's transcript
        Mark mark = new Mark(firstAttestation, secondAttestation, finalMark);

        Transcript transcript = student.getTranscript();
        transcript.addMarksForCourse(semester, course, mark);

        System.out.println("Mark assigned for " + student.getName() + " in " + course.getCourseName() + ". Status: " + mark.getStatus());
    }

    // View a student's transcript
    public void viewStudentTranscript(Teacher teacher) {
        System.out.print("Enter student ID to view transcript: ");
        String studentId = in.nextLine();

        Student student = Data.INSTANCE.findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Transcript transcript = student.getTranscript();
        System.out.println("Transcript for " + student.getName() + ":");

        // Display the marks for each course in the transcript
        transcript.displayTranscript();
    }
    // Save data
    private void save() throws IOException {
        Data.write();
    }
}