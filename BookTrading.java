import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for the book trading application
public class BookTrading {
    public static void main(String[] args) {
        // Creating seller agents and adding books to their catalogs
        SellerAgent seller1 = new SellerAgent();
        seller1.addBook("The Hobbit", 75.0);
        seller1.addBook("The Silmarillion", 60.0);
        seller1.addBook("Fellowship of the Ring", 45.0);
        seller1.addBook("Unfinished Tales", 65.0);
        seller1.addBook("On Stranger Tides", 55.0);
        seller1.addBook("The Children of Hurin", 70.0);

        SellerAgent seller2 = new SellerAgent();
        seller2.addBook("The Silmarillion", 75.0);
        seller2.addBook("Unfinished Tales", 55.0);
        seller2.addBook("Curse of the black pearl", 70.0);
        seller2.addBook("On Stranger Tides", 65.0);
        seller2.addBook("Dead Mans Chest", 60.0);
        seller2.addBook("Fellowship of the Rings", 50.0);

        // Creating a list to store all seller agents
        List<SellerAgent> sellers = new ArrayList<>();
        sellers.add(seller1);
        sellers.add(seller2);

        // Creating a scanner object for user input and an instance of BuyerAgent
        Scanner scanner = new Scanner(System.in);
        BuyerAgent buyer = new BuyerAgent();

        System.out.print("Enter the Title of the book you want to buy: ");
        String title = scanner.nextLine();
        buyer.setTargetBook(title);

        // Invoking the buyBook method to attempt purchasing the book
        buyer.buyBook(sellers);
    }
}