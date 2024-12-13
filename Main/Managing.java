package Main;

import java.io.IOException;
import java.util.Scanner;

import User.Admin;
import User.Student;
import User.Teacher;
import Views.*;

public class Managing {

    private final adminView adminView = new adminView();
    private final Scanner in = new Scanner(System.in);

    public void run() throws IOException {
        authenticateAndShowMenu();
    }

    public void authenticateAndShowMenu() throws IOException {
        System.out.println("Enter login: ");
        String login = in.next();
        System.out.println("Enter password: ");
        String password = in.next();

        // Determine user role
        String role = getRole(login, password);

        switch (role) {
            case "ADMIN":
                showAdminMenu();
                break;
            case "STUDENT":
            	BaseView.displayMenu();
                showStudentMenu();
                break;
            case "TEACHER":
            	BaseView.displayMenu();
                showTeacherMenu();
                break;
            case "UNKNOWN":
                System.out.println("Invalid login or password. Please try again.");
                break;
            default:
                System.out.println("Unhandled role. Please contact support.");
        }
    }

    private String getRole(String login, String password) {
        // Check admin list
        for (Admin admin : Data.INSTANCE.admins) {
            if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                return "ADMIN";
            }
        }

        // Check student list
        for (Student student : Data.INSTANCE.students) {
            if (student.getLogin().equals(login) && student.getPassword().equals(password)) {
                return "STUDENT";
            }
        }

        // Check teacher list
        for (Teacher teacher : Data.INSTANCE.teachers) {
            if (teacher.getLogin().equals(login) && teacher.getPassword().equals(password)) {
                return "TEACHER";
            }
        }

        return "UNKNOWN";
    }

    private void showAdminMenu() throws IOException {
        System.out.println("Welcome, Admin!");
        adminView.run();
    }

    private void showStudentMenu() {
        System.out.println("Welcome, Student!");
        // Student-specific operations
    }

    private void showTeacherMenu() {
        System.out.println("Welcome, Teacher!");
        // Teacher-specific operations
    }
    
}






