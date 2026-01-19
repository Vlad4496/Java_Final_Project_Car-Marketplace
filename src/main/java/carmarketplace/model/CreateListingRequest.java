package carmarketplace.model;

public record CreateListingRequest(
        Long carId,
        Long userId,
        Integer price,
        String description
) {

}
