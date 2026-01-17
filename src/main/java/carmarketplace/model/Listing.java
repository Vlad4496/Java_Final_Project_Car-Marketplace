package carmarketplace.model;

import java.util.Objects;

public class Listing {
    private final int id;
    private final Car car;
    private final User seller;
    private final int price;
    private final String description;
    private final ListingStatus status;

    public Listing(int id, Car car, User seller, int price, String description) {
        this.id = id;
        this.car = Objects.requireNonNull(car);
        this.seller = Objects.requireNonNull(seller);
        this.price = price;
        this.description = Objects.requireNonNull(description);
        this.status = ListingStatus.ACTIVE;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", car=" + car +
                ", seller=" + seller +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
