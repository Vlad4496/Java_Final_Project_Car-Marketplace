package carmarketplace.services;

import carmarketplace.model.Listing;
import org.springframework.stereotype.Component;

@Component
public class PriceFilter implements ListingFilter {
    private int maxPrice = 120000;

    public boolean matches(Listing listing) {
        var filterPrice = listing.getPrice() <= maxPrice;
        if(!filterPrice) {
            System.out.println("We don't have the price of " + listing.getPrice());
        }
        return filterPrice;
    }
}
