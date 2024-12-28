package Views;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Education.News;
import Education.Request;
import Education.RequestType;
import Education.StatusInfo;
import Main.Data;
import Main.UserSession;
//import Education.News;
import User.Student;

public class ManagerView {
    Scanner scanner = new Scanner(System.in);


    private static void save() throws IOException {
        Data.write(); // Save the data
    }
    
    private void exit() {
        System.out.println("Goodbye, Manager!");
        try {
            save(); // Save before exiting
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public void run() throws IOException {
        try {
            while (true) { // Infinite loop until exit
                System.out.println("\n=== Manager Menu ===");
                System.out.println("1. Statistics (Under Development)");
                System.out.println("2. Show Requests (Under Development)");
                System.out.println("3. View Student Info (Under Development)");
                System.out.println("4. Publish News");
                System.out.println("5. Exit");
                System.out.println("6. Reset News");
                System.out.println("7. Add request");
                System.out.print("Enter your choice: ");

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                    continue; // Restart loop for a valid input
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        manageStatistics();
                        break;
                    case 2:
                        showRequests();
                        break;
                    case 3:
                        viewStudentsInfo();
                        break;
                    case 4:
                        publishNews();
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        exit();
                        return; // Exit the loop and terminate the program
                    case 6:
                        resetNews();
                        break;
                    case 7:
                        String currentUserEmail = UserSession.getInstance().getLoggedInEmail();
                        if (currentUserEmail != null) {
                            addRequest(currentUserEmail);
                        } else {
                            System.out.println("Error: No user is logged in. Cannot create a request.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Saving resources...");
            e.printStackTrace();
            save();
        }
        // Removed scanner.close() to avoid closing the input stream
    }

    public void addRequest(String currentUserEmail) {
        System.out.println("Enter request details:");

        String managerName = "Manager";
        System.out.println("Enter request type (e.g., DORM_REQUEST, FX_REQUEST, INQUIRY):");
        String requestTypeInput = scanner.nextLine();
        RequestType requestType = RequestType.valueOf(requestTypeInput.toUpperCase());

        System.out.println("Enter additional attribute for the request:");
        String additionalAttribute = scanner.nextLine();

        System.out.println("Enter request ID:");
        int requestID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (currentUserEmail == null || currentUserEmail.isEmpty()) {
            System.out.println("Error: No user is logged in. Cannot create request.");
            return;
        }

        StatusInfo status = StatusInfo.IN_PROGRESS;

        Request newRequest = new Request(requestID, status, managerName, requestType, additionalAttribute, currentUserEmail);
        Data.INSTANCE.getRequests().add(newRequest);
        System.out.println("Request added and status set to IN_PROGRESS!");
    }
    // Statistics feature under development
 // Manage statistics: Calculate and display average GPA of all students
    private static void manageStatistics() {
        System.out.println("\n=== Statistics ===");
        
        List<Student> students = Data.INSTANCE.getStudents(); // Получаем всех студентов
        if (students.isEmpty()) {
            System.out.println("No students available to calculate statistics.");
            return;
        }
        
        double totalGPA = 0.0;
        for (Student student : students) {
            totalGPA += student.getGpa(); // Суммируем GPA студентов
        }
        double averageGPA = totalGPA / students.size(); // Рассчитываем среднее значение
        
        System.out.println("Total Students: " + students.size());
        System.out.printf("Average GPA: %.2f%n", averageGPA);
    }

    // Show requests: Display list of pending requests
    private static void showRequests() {
        System.out.println("\n=== Show Requests ===");

        List<Request> requests = Data.INSTANCE.getRequests(); // Получаем список запросов
        if (requests.isEmpty()) {
            System.out.println("No requests to show.");
            return;
        }

        for (int i = 0; i < requests.size(); i++) {
            Request request = requests.get(i);
            System.out.println((i + 1) + ") " + request);
        }
    }

    // View student info: Display detailed information about all students
    private static void viewStudentsInfo() {
        System.out.println("\n=== View Student Info ===");

        List<Student> students = Data.INSTANCE.getStudents(); // Получаем список студентов
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        for (Student student : students) {
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("Email: " + student.getEmail());
            System.out.println("------------------------------");
        }
    }

   private static void resetNews() {
        Data.INSTANCE.resetNews(); // Call reset method from Data class
    } 
    
    private static void publishNews() {
        System.out.println("\n=== Publish News ===");

        try (// Create a scanner only here and don't close it in this method
		Scanner scanner = new Scanner(System.in)) {
			try {
			    // Getting the news details from the manager
			    System.out.print("Enter the title of the news: ");
			    String title = scanner.nextLine();

			    System.out.print("Enter the content of the news: ");
			    String content = scanner.nextLine();

			    // Create a new news instance
			    News news = new News(title, content);

			    // Publish the news
			    Data.INSTANCE.publishNews(news);
			    System.out.println("News has been successfully published.");
			} catch (Exception e) {
			    System.out.println("An error occurred while publishing news.");
			    e.printStackTrace();
			}
		}
    }

}
