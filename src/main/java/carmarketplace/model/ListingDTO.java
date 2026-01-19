package carmarketplace.model;

public record ListingDTO(Long id, CarDTO car, UserDTO user, Integer price, String description) {

}
