package User;

import Education.Book;
import Main.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Librarian extends Employee {
    private static final long serialVersionUID = 1L;
    private Map<Person, List<Book>> borrowedBooks;
    private Map<Book, LocalDate> dueDates;

    // Constructor
    public Librarian(String login, String password, String name, String surname, String middleName,
    	      LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
    	      FamilyStatuses familyStatus, String corporateEmail, double salary, String timeOfExperience,
    	      boolean isResearcher) {
    	    super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email, familyStatus,
    	        corporateEmail, salary, timeOfExperience, isResearcher);
    	    this.borrowedBooks = new HashMap<>();
    	    this.dueDates = new HashMap<>();
    	    }

    public void addBook(String title, String genre, String author, double price, int quantity) {
        Book newBook = new Book(title, genre, author, price, quantity);
        Data.INSTANCE.getBooks().add(newBook);
        System.out.println("Book added: " + title);
    }


    // View all available books
    public void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getQuantity() > 0) {
                System.out.println(book);
            }
        }
    }

    // Borrow a book for a person
    public void borrowBook(Person person, String bookTitle) {
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                if (book.getQuantity() > 0) {
                    book.borrow(); 
                    borrowedBooks.computeIfAbsent(person, k -> new ArrayList<>()).add(book);
                    dueDates.put(book, LocalDate.now().plusMonths(6));
                    System.out.println(person.getName() + " borrowed: " + bookTitle);
                } else {
                    System.out.println("Sorry, the book is out of stock: " + bookTitle);
                }
                return;
            }
        }
        System.out.println("Book not found: " + bookTitle);
    }

    // Report a lost book and fine the person
    public void reportLostBook(Person person, String bookTitle) {
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                if (borrowedBooks.containsKey(person) && borrowedBooks.get(person).contains(book)) {
                    // Calculate fine (2 times the book price)
                    double fine = 2 * book.getPrice();
                    System.out.println(person.getName() + " reported the book '" + bookTitle + "' as lost.");
                    System.out.println("Fine for the lost book: $" + fine);
                    borrowedBooks.get(person).remove(book);  // Remove the book from borrowed list
                    return;
                } else {
                    System.out.println("The person has not borrowed this book.");
                }
            }
        }
        System.out.println("Book not found in the library: " + bookTitle);
    }

    // Return a borrowed book
    public void returnBook(Person person, String bookTitle) {
        if (borrowedBooks.containsKey(person)) {
            List<Book> borrowed = borrowedBooks.get(person);
            Iterator<Book> iterator = borrowed.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                    // Check if the book is being returned after the due date
                    if (LocalDate.now().isAfter(dueDates.get(book))) {
                        double fine = 2 * book.getPrice();
                        System.out.println(person.getName() + " returned the book '" + bookTitle + "' after the due date.");
                        System.out.println("Late return fine: $" + fine);
                    }
                    book.returnBook(); // Increment quantity in the book
                    iterator.remove(); // Remove book from borrowed list
                    System.out.println(person.getName() + " returned: " + bookTitle);
                    return;
                }
            }
        }
        System.out.println("Book not found in borrowed list: " + bookTitle);
    }

    // View borrowed books
    public void viewBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Map.Entry<Person, List<Book>> entry : borrowedBooks.entrySet()) {
            System.out.println(entry.getKey().getName() + " has borrowed:");
            for (Book book : entry.getValue()) {
                System.out.println(" - " + book.getTitle());
            }
        }
    }
}

