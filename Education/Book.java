package Education;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String genre;
    private String author;
    private double price;
    private int quantity;

    // Constructor
    public Book(String title, String genre, String author, double price, int quantity) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Reduce quantity when borrowed
    public void borrow() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("No copies available to borrow.");
        }
    }

    // Increase quantity when returned
    public void returnBook() {
        quantity++;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Genre=" + genre +
               ", Price=" + price + ", Quantity=" + quantity + "]";
    }
}
