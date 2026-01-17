package services;

import model.Listing;

import java.math.BigDecimal;

public interface ListingFilter {
    boolean matches(Listing listing);
}
