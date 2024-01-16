import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Class representing a buyer agent
public class BuyerAgent {
    private String targetBook;

    BuyerAgent() { }

    // Setting the target book
    public void setTargetBook(String targetBook) {
        this.targetBook = targetBook;
    }

    // Requesting offers from all sellers and buying the book from the best deal
    public void buyBook(List<SellerAgent> sellers) {
        Map<SellerAgent, Double> offers = new HashMap<>();

        for (SellerAgent seller : sellers) {
            Double price = seller.provideOffer(targetBook);
            if (price != null) {
                offers.put(seller, price);
            }
        }

        if (!offers.isEmpty()) {
            Optional<Map.Entry<SellerAgent, Double>> bestOfferOpt = offers.entrySet().stream()
                .min(Map.Entry.comparingByValue());

            if (bestOfferOpt.isPresent()) {
                Map.Entry<SellerAgent, Double> bestOffer = bestOfferOpt.get();
                SellerAgent bestSeller = bestOffer.getKey();
                double price = bestOffer.getValue();
                if (bestSeller.processPurchaseOrder(targetBook)) {
                    System.out.println("The Book '" + targetBook + "' was bought for £" + price + " from " + bestSeller.getClass().getName());
                } else {
                    System.out.println("Failed to process the purchase order for '" + targetBook + "'.");
                }
            } else {
                System.out.println("No available offers for '" + targetBook + "'.");
            }
        } else {
            System.out.println("No available offers for '" + targetBook + "'.");
        }
    }
}
