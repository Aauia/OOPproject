package Views;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import Main.*;
import User.*;
import Education.*;

public class BaseView {
    private static final Scanner scanner = new Scanner(System.in); // Single Scanner instance

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

    public static void run(Person loggedInUser) throws IOException {
        System.out.println("Welcome, " + loggedInUser.getName());
        BaseView baseView = new BaseView();

        try {
            while (true) {
                System.out.println("\n=== University Management System ===");
                System.out.println("1. Manage Researchers");
                System.out.println("2. Manage Journals");
                System.out.println("3. News");
                System.out.println("4. Library");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        manageResearchers();
                        break;
                    case 2:
                        manageJournals();
                        break;
                    case 3:
                        viewNews();
                        break;
                    case 4:
                        libraryMenu(loggedInUser);
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        baseView.exit();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something bad happened... \nSaving resources...");
            e.printStackTrace();
            save();
        }
    }


    private static void libraryMenu(Person loggedInPerson) {
        boolean exitLibraryMenu = false;

        while (!exitLibraryMenu) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Library");
            System.out.println("2. My Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Report Lost Book");
            System.out.println("6. Back to Main Menu");
            System.out.println();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewLibrary();
                    break;
                case 2:
                    myBooks(loggedInPerson);
                    break;
                case 3:
                    borrowBook(loggedInPerson);
                    break;
                case 4:
                    returnBook(loggedInPerson);
                    break;
                case 5:
                    reportLostBook(loggedInPerson);
                    break;
                case 6:
                    exitLibraryMenu = true;
                    break;
                case 7:
                	resetLibrary(loggedInPerson);
                	break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewLibrary() {
        System.out.println("\n=== Library Books ===");
        Vector<Book> books = Data.INSTANCE.getBooks();

        if (books.isEmpty()) {
            System.out.println("No books are available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    private static void myBooks(Person loggedInPerson) {
        System.out.println("\n=== My Borrowed Books ===");
        if (loggedInPerson.getBorrowedBooks() == null || loggedInPerson.getBorrowedBooks().isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            loggedInPerson.viewBorrowedBooks();
        }
    }
    private static void resetLibrary(Person loggedInPerson) {
            loggedInPerson.resetBorrowedBooks();
        
    }

    private static void borrowBook(Person loggedInPerson) { 
        System.out.print("Enter the title of the book you want to borrow: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && book.getQuantity() > 0) {
        	loggedInPerson.borrowBook(book);
            book.borrow();

            System.out.println("You have successfully borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }


    private static void returnBook(Person loggedInPerson) {
        System.out.print("Enter the title of the book you want to return: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && loggedInPerson.getBorrowedBooks().containsKey(book)) {
            loggedInPerson.returnBook(book);
            book.returnBook();
            System.out.println("You have successfully returned the book: " + book.getTitle());
        } else {
            System.out.println("You do not have this book.");
        }
    }

    private static void reportLostBook(Person loggedInPerson) {
        System.out.print("Enter the title of the lost book: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && loggedInPerson.getBorrowedBooks().containsKey(book)) {
            loggedInPerson.returnBook(book);
            double fine = book.getPrice() * 2;
            System.out.println("The book has been marked as lost. Fine: $" + fine);
        } else {
            System.out.println("You do not have this book.");
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

    public static void viewNews() {
        System.out.println("\n=== News ===");
        Vector<News> newsList = Data.INSTANCE.getNewsList();

        if (newsList.isEmpty()) {
            System.out.println("No news available.");
        } else {
            for (News news : newsList) {
                System.out.println(news.toString());
            }
        }
    }
}
