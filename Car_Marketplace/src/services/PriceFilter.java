package services;

import model.Listing;

public class PriceFilter implements ListingFilter {
    private final int maxPrice;

    public PriceFilter(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean matches(Listing listing) {
        return listing.getPrice() <= maxPrice;
    }
}
