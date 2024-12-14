package Views;

import java.util.Scanner;

import User.Librarian;

public class LibrarianView {

    private final Librarian librarian;
    private final Scanner scanner;

    public LibrarianView(Librarian librarian) {
        this.librarian = librarian;
        this.scanner = new Scanner(System.in);
    }

    // Method to show the menu and handle user choices
    public void showMenu() {
        while (true) {
            System.out.println("\n=== Librarian Menu ===");
            System.out.println("1. View Available Books");
            System.out.println("2. View Borrowed Books");
            System.out.println("3. Add New Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    viewBorrowedBooks();
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    System.out.println("Exiting Librarian Menu...");
                    return; // Exit the menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // View Available Books
    private void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        librarian.viewAvailableBooks();
    }

    // View Borrowed Books
    private void viewBorrowedBooks() {
        System.out.println("\nBorrowed Books:");
        librarian.viewBorrowedBooks();
    }

    // Add a New Book
    private void addNewBook() {
        System.out.println("\nEnter book details to add:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        librarian.addBook(title, genre, author, price, quantity);
    }
}
