package carmarketplace.services;

import carmarketplace.model.Listing;

public class PriceFilter implements ListingFilter {
    private final int maxPrice;

    public PriceFilter(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean matches(Listing listing) {
        var filterPrice = listing.getPrice() <= maxPrice;
        if(!filterPrice) {
            System.out.println("We don't have the price of " + listing.getPrice());
        }
        return filterPrice;
    }
}
