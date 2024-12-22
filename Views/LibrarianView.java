package Views;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import Education.*;
import Main.*;
import User.*;

public class LibrarianView {
    private final Scanner in = new Scanner(System.in);

    private static void save() throws IOException {
        Data.write(); // Save the data to the file
    }

    private void exit() {
        System.out.println("Goodbye, Librarian!");
        try {
            save(); // Save the data before exiting
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Display the librarian menu
                System.out.println("\n=== Librarian Menu ===");
                System.out.println("1. View Available Books");
                System.out.println("2. Add New Book");
                System.out.println("3. Exit");
                System.out.println("4. Reset Library");
                System.out.println("5. View Borrowed Books Records");  // New option for borrowed books records
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer

                switch (choice) {
                    case 1:
                        viewAvailableBooks();
                        break;
                    case 2:
                        addNewBook();
                        break;
                    case 3:
                        System.out.println("Exiting the Librarian Menu...");
                        exit(); // Exit the menu and save data
                        return; // Exit the loop
                    case 4:
                        resetLibrary();
                        break;
                    case 5:
                        viewBorrowedBooksRecords();  // Call the new method to view borrowed books records
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong... \nSaving resources...");
            e.printStackTrace();
            save(); // Ensure data is saved if an error occurs
        }
    }


    // View Available Books
    private void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getQuantity() > 0) {
                System.out.println(book);  // Print the book details if available
            }
        }
    }
    
    private void viewBorrowedBooksRecords() {
        System.out.println("\n=== Borrowed Books Records ===");

        
        // Iterate through all the different collections of people (e.g., students, teachers)
        viewBorrowedBooksForPeople(Data.INSTANCE.getAdmins());
        viewBorrowedBooksForPeople(Data.INSTANCE.getStudents());
        viewBorrowedBooksForPeople(Data.INSTANCE.getTeachers());
        viewBorrowedBooksForPeople(Data.INSTANCE.getLibrarians());
        
        // Add more collections if needed (e.g., researchers, etc.)
    }

    private void viewBorrowedBooksForPeople(Vector<? extends Person> people) {
        for (Person person : people) {
            Map<Book, LocalDate> borrowedBooks = person.getBorrowedBooks();
            if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
                System.out.println("Name: " + person.getName() + " " + person.getSurname());
                for (Map.Entry<Book, LocalDate> entry : borrowedBooks.entrySet()) {
                    Book book = entry.getKey();
                    LocalDate dueDate = entry.getValue();
                    System.out.println("  Book: " + book.getTitle() + " | Due Date: " + dueDate);
                }
            }
        }
    }



    
    private static void resetLibrary() {
        
    	Data.INSTANCE.resetLibrary(); // Call reset method from Data class
    }


    // Add a New Book to the Library
    private void addNewBook() {
        System.out.println("\nEnter book details to add:");

        System.out.print("Title: ");
        String title = in.nextLine();  // Use nextLine() for the title, as it's a string with spaces

        System.out.print("Genre: ");
        String genre = in.nextLine();  // Use nextLine() to get the genre

        System.out.print("Author: ");
        String author = in.nextLine();  // Use nextLine() to get the author name

        System.out.print("Price: ");
        double price = in.nextDouble();  // Get the price as a double

        System.out.print("Quantity: ");
        int quantity = in.nextInt();  // Get the quantity as an integer
        in.nextLine(); // Consume newline character after reading the integer

        Book newBook = new Book(title, genre, author, price, quantity);  // Create a new book object
        Data.INSTANCE.getBooks().add(newBook);  // Add the new book to the list
        System.out.println("Book added: " + title);  // Confirm the book has been added
    }
}