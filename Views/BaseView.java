package Views;

import java.io.IOException;
import java.util.Scanner;

import Main.Data;

public class BaseView {
	  private static void save() throws IOException {
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
    public static void displayMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try{while (!exit) {
            System.out.println("\n=== University Management System ===");
            System.out.println("11. Manage Researchers");
            System.out.println("12. Manage Journals");
            System.out.println("13. Manage News");
            System.out.println("1. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    manageResearchers();
                    break;
                case 2:
                    manageJournals();
                    break;
                case 3:
                    manageNews();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        }
        catch (Exception e) {
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            save();
        }


        scanner.close();
    }
  
    public static void manageResearchers() {
        System.out.println("\n=== Manage Researchers ===");
        // Implement functionality for managing researchers
        System.out.println("This feature is under development.");
    }

    public static void manageJournals() {
        System.out.println("\n=== Manage Journals ===");
        // Implement functionality for managing journals
        System.out.println("This feature is under development.");
    }

    public static void manageNews() {
        System.out.println("\n=== Manage News ===");
        // Implement functionality for managing news
        System.out.println("This feature is under development.");
    }
}
