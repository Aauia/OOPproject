package Education;

import java.util.*;

import User.Librarian;

public class Library {
    private List<Book> books;
    private Map<Book, Integer> bookQuantities; // Book -> Quantity mapping
    private List<Librarian> librarians;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.bookQuantities = new HashMap<>();
        this.librarians = new ArrayList<>();
    }

    // Add a librarian
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    // Add a book with quantity
    public void addBook(Book book, int quantity) {
        books.add(book);
        bookQuantities.put(book, quantity);
    }

    // Remove a book
    public void removeBook(Book book) {
        books.remove(book);
        bookQuantities.remove(book);
    }

    // List all books
    public void listBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            int quantity = bookQuantities.getOrDefault(book, 0);
            System.out.println(book + ", Quantity: " + quantity);
        }
    }

    // List all librarians
    public void listLibrarians() {
        System.out.println("Librarians in Library:");
        for (Librarian librarian : librarians) {
            System.out.println(librarian);
        }
    }

    // Getters
    public List<Book> getBooks() {
        return books;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public Map<Book, Integer> getBookQuantities() {
        return bookQuantities;
    }
}