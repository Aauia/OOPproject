package Views;

import java.io.IOException;
import java.util.Scanner;
import Main.Data;
import User.Person;
import Education.News;

public class ManagerView {

    private static void save() throws IOException {
        Data.write();
    }

    private void exit() {
        System.out.println("Goodbye, Manager!");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu(Person person) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
            while (!exit) {
                System.out.println("\n=== Manager Menu ===");
                System.out.println("1. Statistics (Under Development)");
                System.out.println("2. Show Requests (Under Development)");
                System.out.println("3. View Student Info (Under Development)");
                System.out.println("4. Publish News");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

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
                        viewStudentInfo();
                        break;
                    case 4:
                        publishNews();
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            save();
        } finally {
            scanner.close();
        }
    }

    // Statistics feature under development
    private static void manageStatistics() {
        System.out.println("\n=== Statistics ===");
        System.out.println("This feature is under development.");
    }

    // Show Requests feature under development
    private static void showRequests() {
        System.out.println("\n=== Show Requests ===");
        System.out.println("This feature is under development.");
    }

    // View Student Info feature under development
    private static void viewStudentInfo() {
        System.out.println("\n=== View Student Info ===");
        System.out.println("This feature is under development.");
    }

    // Functionality to publish news
    private static void publishNews() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Publish News ===");
        
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
    }
}
