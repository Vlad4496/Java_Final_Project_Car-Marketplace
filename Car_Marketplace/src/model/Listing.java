package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Listing {
    private final int id;
    private final Car car;
    private final User seller;
    private int price;
    private final String description;
    private ListingStatus status;

    public Listing(int id, Car car, User seller, int price, String description) {
        this.id = id;
        this.car = Objects.requireNonNull(car);
        this.seller = Objects.requireNonNull(seller);
        this.price = price;
        this.description = Objects.requireNonNull(description);
        this.status = ListingStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public User getSeller() {
        return seller;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ListingStatus getStatus() {
        return status;
    }

    public void markAsSold() {
        if(this.status == ListingStatus.SOLD) {
            throw new IllegalArgumentException("Car is already sold");
        }
        if(this.status == ListingStatus.REMOVED) {
            throw new IllegalArgumentException("Car is already removed");
        }
        this.status = ListingStatus.SOLD;
    }

    public void changePrice(int price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
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
