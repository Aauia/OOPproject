package Views;

import java.io.IOException;
import java.util.Scanner;
import Main.Data;
import Education.News;

public class ManagerView {

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
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) { // Infinite loop until exit
                // Display the manager menu
                System.out.println("\n=== Manager Menu ===");
                System.out.println("1. Statistics (Under Development)");
                System.out.println("2. Show Requests (Under Development)");
                System.out.println("3. View Student Info (Under Development)");
                System.out.println("4. Publish News");
                System.out.println("5. Exit");
                System.out.println();
                
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
                        exit(); // Call exit method to clean up before exiting
                        return; // Exit the loop and terminate the program
                    case 6: 
                    	resetNews();
                    	break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            save(); // Ensure data is saved if an error occurs
        } finally {
            scanner.close(); // Close scanner to avoid resource leak
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
