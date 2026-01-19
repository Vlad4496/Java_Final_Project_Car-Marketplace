package carmarketplace.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User seller;
    private int price;
    private String description;

    public Listing(Car car, User seller, int price, String description) {
        this.car = car;
        this.seller = seller;
        this.price = price;
        this.description = description;
    }

    public Listing() {

    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
