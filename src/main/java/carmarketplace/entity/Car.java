package carmarketplace.entity;

import carmarketplace.model.BodyType;
import carmarketplace.model.FuelType;
import carmarketplace.model.Transmission;
import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private int year;
    private long kilometers;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    protected Car() {}

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public long getKilometers() {
        return kilometers;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }
}
