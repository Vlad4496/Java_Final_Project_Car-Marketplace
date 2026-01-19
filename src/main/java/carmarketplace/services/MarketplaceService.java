package carmarketplace.services;

import carmarketplace.model.Listing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketplaceService {
    private final List<Listing> listings = new ArrayList<>();

    public void addListing(Listing listing) {
        listings.add(listing);
    }

    @Override
    public String toString() {
        return "MarketplaceService{" +
                "listings=" + listings +
                '}';
    }

    public List<Listing> filterListings(ListingFilter filter) {
        return listings.stream()
                .filter(filter::matches)
                .toList();
    }
}
