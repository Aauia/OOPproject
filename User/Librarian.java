package Views;

import java.io.IOException;
import java.util.Scanner;
import Main.Data;
import User.Person;
import Education.Book;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public static void displayMenu(Person person) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
            while (!exit) {
                System.out.println("\n=== University Management System ===");
                System.out.println("1. Manage Researchers");
                System.out.println("2. Manage Journals");
                System.out.println("3. Manage News");
                System.out.println("4. Library");
                System.out.println("5. Exit");
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
                        libraryMenu(person); // Navigate to library menu
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

    private static void libraryMenu(Person person) {
        Scanner scanner = new Scanner(System.in);
        boolean exitLibraryMenu = false;

        while (!exitLibraryMenu) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Report Lost Book");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    borrowBook(person); // Borrow a book
                    break;
                case 2:
                    returnBook(person); // Return a book
                    break;
                case 3:
                    reportLostBook(person); // Report a lost book
                    break;
                case 4:
                    exitLibraryMenu = true; // Return to the main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void borrowBook(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book you want to borrow: ");
        String bookTitle = scanner.nextLine();

        // Find the book from Data
        Book book = findBook(bookTitle);
        if (book != null && book.getQuantity() > 0) {
            book.borrow(); // Reduce quantity of the book
            System.out.println("You have successfully borrowed the book: " + book.getTitle());
            // Add the borrowed book to the person's record (can be added to a list of borrowed books for the person)
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }

    private static void returnBook(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book you want to return: ");
        String bookTitle = scanner.nextLine();

        // Find the book from Data
        Book book = findBook(bookTitle);
        if (book != null) {
            book.returnBook(); // Increase quantity of the book
            System.out.println("You have successfully returned the book: " + book.getTitle());

            // Check if the book was returned after the due date and apply fine
            LocalDate dueDate = LocalDate.now().minusMonths(6); // assuming 6 months is the due date
            long daysLate = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            if (daysLate > 0) {
                double fine = book.getPrice() * 2; // Fine is twice the price of the book
                System.out.println("You have returned the book late. The fine is: $" + fine);
            }
        } else {
            System.out.println("Sorry, the book was not found.");
        }
    }

    private static void reportLostBook(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the lost book: ");
        String bookTitle = scanner.nextLine();

        // Find the book from Data
        Book book = findBook(bookTitle);
        if (book != null) {
            // Mark the book as lost
            book.setQuantity(0); // You can choose to reduce the quantity to zero or remove it from the inventory
            double fine = book.getPrice() * 2; // Fine is twice the price of the book
            System.out.println("The book has been marked as lost. The fine is: $" + fine);
        } else {
            System.out.println("Sorry, the book was not found.");
        }
    }

    private static Book findBook(String bookTitle) {
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public static void manageResearchers() {
        System.out.println("\n=== Manage Researchers ===");
        System.out.println("This feature is under development.");
    }

    public static void manageJournals() {
        System.out.println("\n=== Manage Journals ===");
        System.out.println("This feature is under development.");
    }

    public static void manageNews() {
        System.out.println("\n=== Manage News ===");
        System.out.println("This feature is under development.");
    }
}
