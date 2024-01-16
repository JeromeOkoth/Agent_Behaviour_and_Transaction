import java.util.ArrayList;
import java.util.List;

// Creating a class representing a book
class Book {
    String title;
    double price;

    Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}

// Creating a class representing a seller agent
public class SellerAgent {
    private List<Book> catalog = new ArrayList<>();

    // Adding a book to the catalog
    public void addBook(String title, double price) {
        catalog.add(new Book(title, price));
        System.out.println("Seller added book: " + title + " costing: " + price);
    }

    // Providing an offer for a book
    public Double provideOffer(String title) {
        for (Book book : catalog) {
            if (book.title.equalsIgnoreCase(title)) {  // Using equalsIgnoreCase for case-insensitive comparison
                return book.price;
            }
        }
        return null; // when the book is not found
    }
    

    // Processing a purchase order
    public boolean processPurchaseOrder(String title) {
        return catalog.removeIf(book -> book.title.equalsIgnoreCase(title)); 
    }
    
}