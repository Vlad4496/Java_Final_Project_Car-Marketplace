package services;

import model.Listing;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceService {
    private final List<Listing> listing = new ArrayList<>();

    public void addListing(Listing listing) {
        this.listing.add(listing);
    }

    public List<Listing> getListing() {
        return new ArrayList<>(listing);
    }

    public List<Listing> filterListings(ListingFilter filter) {
        List<Listing> filteredList = new ArrayList<>();

        for(Listing list : this.listing) {
            if(filter.matches(list)) {
                filteredList.add(list);
            }
        }

        return filteredList;
    }
}
