
package Views;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
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
    public void showCurriculum(Student student) {
        System.out.println("Curriculum:");
        Data.INSTANCE.getRup().stream()
                .filter(c -> c.getFaculty() == student.getFaculty() && c.getSpecialty() == student.getSpecialty())
                .forEach(System.out::println);
    }

    // Show student's schedule
    public void showSchedule(Student student) {
        if (student.getSchedule() == null) {
            System.out.println("Your schedule is empty.");
            return;
        }

        System.out.println("Your schedule:" + student.getSchedule());
    }

    // Show transcript for the student
    public void showTranscript(Student student) {
        Transcript transcript = student.getTranscript();
        if (transcript == null || transcript.getMarksForCourse(0, null).isEmpty()) {
            System.out.println("No transcript available.");
            return;
        }

        System.out.println("Transcript for " + student.getName() + ":");

        // Iterate through semesters and courses
        for (Map.Entry<Integer, Map<Course, ArrayList<Mark>>> semesterEntry : transcript.getSemesterData().entrySet()) {
            int semester = semesterEntry.getKey();
            System.out.println("Semester: " + semester);

            // Iterate through courses in each semester
            for (Map.Entry<Course, ArrayList<Mark>> courseEntry : semesterEntry.getValue().entrySet()) {
                Course course = courseEntry.getKey();
                List<Mark> marks = courseEntry.getValue();

                System.out.println("  Course: " + course.getCourseCode() + " - " + course.getCourseName());
                for (Mark mark : marks) {
                    System.out.println("    - First Attestation: " + mark.getFirstAttestation());
                    System.out.println("    - Second Attestation: " + mark.getSecondAttestation());
                    System.out.println("    - Final Mark: " + mark.getSum());
                    System.out.println("    - Status: " + mark.getStatus());
                    System.out.println("-----------------------------------");
                }
            }
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

    // Menu for student
    public void menu(Student student) throws IOException {
        try {
            while (true) {
                System.out.println("\nStudent Menu:");
                System.out.println("1) Show Curriculum");
                System.out.println("2) Show Schedule");
                System.out.println("3) Show Transcript");
                System.out.println("4) Exit");

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
