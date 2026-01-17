package carmarketplace.services;

import carmarketplace.model.Listing;

public interface ListingFilter {
    boolean matches(Listing listing);
}
