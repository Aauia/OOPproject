package Main;

import java.io.IOException;
import java.util.Scanner;

import User.*;
import Views.BaseView;

public class Managing {
    private final Scanner in = new Scanner(System.in);

    public void run() throws IOException {
        authenticateAndShowMenu();
    }

    public void authenticateAndShowMenu() throws IOException {
        System.out.println("Enter login: ");
        String login = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        Person user = Data.findUserByLoginAndPassword(login, password);

        if (user == null) {
            System.out.println("Invalid login or password. Please try again.");
            return;
        }

        // Определяем роль и статус исследователя
        String role = getRole(login, password);
        boolean isResearcher = checkResearcherStatus(login, role);

        if (role.equals("UNKNOWN")) {
            System.out.println("Invalid login or password. Please try again.");
            return;
        }

        String email = getEmail(login, role);
        if (email == null) {
            System.out.println("Error: Unable to retrieve email for the user.");
            return;
        }

        // Логин в UserSession
        UserSession.getInstance().login(email, isResearcher);

        // Показ меню на основе роли
        BaseView baseView = new BaseView(login, password);

        switch (role) {
            case "ADMIN":
                System.out.println("Welcome, Admin!");
                baseView.showAdmin(user);
                break;
            case "STUDENT":
                System.out.println("Welcome, Student!");
                baseView.showStudent(user);
                break;
            case "TEACHER":
                System.out.println("Welcome, Teacher!");
                baseView.showTeacher(user);
                break;
            case "LIBRARIAN":
                System.out.println("Welcome, Librarian!");
                baseView.showLibrarian(user);
                break;
            case "DEAN":
                System.out.println("Welcome, Dean!");
                baseView.showDean(user);
                break;
            case "MANAGER":
                System.out.println("Welcome, DeaManagern!");
                baseView.showManager(user);
                break;
            default:
                System.out.println("Unhandled role. Please contact support.");
        }
    }

    private String getRole(String login, String password) {
        for (Admin admin : Data.INSTANCE.admins) {
            if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                return "ADMIN";
            }
        }
        for (Student student : Data.INSTANCE.students) {
            if (student.getLogin().equals(login) && student.getPassword().equals(password)) {
                return "STUDENT";
            }
        }
        for (Teacher teacher : Data.INSTANCE.teachers) {
            if (teacher.getLogin().equals(login) && teacher.getPassword().equals(password)) {
                return "TEACHER";
            }
        }
        for (Librarian lib : Data.INSTANCE.librarians) {
            if (lib.getLogin().equals(login) && lib.getPassword().equals(password)) {
                return "LIBRARIAN";
            }
        }
        for (Dean dean : Data.INSTANCE.deans) {
            if (dean.getLogin().equals(login) && dean.getPassword().equals(password)) {
                return "DEAN";
            }
        }
        for (Manager manager : Data.INSTANCE.managers) {
            if (manager.getLogin().equals(login) && manager.getPassword().equals(password)) {
                return "MANAGER";
            }
        }
        return "UNKNOWN";
    }

    private String getEmail(String login, String role) {
        switch (role) {
            case "ADMIN":
                for (Admin admin : Data.INSTANCE.admins) {
                    if (admin.getLogin().equals(login)) {
                        return admin.getCorporateEmail();
                    }
                }
                break;
            case "STUDENT":
                for (Student student : Data.INSTANCE.students) {
                    if (student.getLogin().equals(login)) {
                        return student.getCorporateEmail();
                    }
                }
                break;
            case "TEACHER":
                for (Teacher teacher : Data.INSTANCE.teachers) {
                    if (teacher.getLogin().equals(login)) {
                        return teacher.getCorporateEmail();
                    }
                }
                break;
            case "LIBRARIAN":
                for (Librarian lib : Data.INSTANCE.librarians) {
                    if (lib.getLogin().equals(login)) {
                        return lib.getCorporateEmail();
                    }
                }
                break;
            case "DEAN":
                for (Dean dean : Data.INSTANCE.deans) {
                    if (dean.getLogin().equals(login)) {
                        return dean.getCorporateEmail();
                    }
                }
                break;
            case "MANAGER":
                for (Manager manager : Data.INSTANCE.managers) {
                    if (manager.getLogin().equals(login)) {
                        return manager.getCorporateEmail();
                    }
                }
                break;
        }
        return null;
    }

    private boolean checkResearcherStatus(String login, String role) {
        switch (role) {
            case "DEAN":
                for (Dean dean : Data.INSTANCE.deans) {
                    if (dean.getLogin().equals(login)) {
                        return dean.isResearcher();
                    }
                }
                break;
            case "ADMIN":
                for (Admin admin : Data.INSTANCE.admins) {
                    if (admin.getLogin().equals(login)) {
                    	return admin.isResearcher();                    }
                }
                break;
            case "STUDENT":
                for (Student student : Data.INSTANCE.students) {
                    if (student.getLogin().equals(login)) {
                    	return student.isResearcher();                    }
                }
                break;
            case "TEACHER":
                for (Teacher teacher : Data.INSTANCE.teachers) {
                    if (teacher.getLogin().equals(login)) {
                    	return teacher.isResearcher();                    
                    	}
                }
                break;
            case "LIBRARIAN":
                for (Librarian lib : Data.INSTANCE.librarians) {
                    if (lib.getLogin().equals(login)) {
                    	return lib.isResearcher();                    }
                }
                break;
            case "MANAGER":
                for (Manager manager : Data.INSTANCE.managers) {
                    if (manager.getLogin().equals(login)) {
                    	return manager.isResearcher();                    }
                }
                break;
           
        }
        return false;
    }
}