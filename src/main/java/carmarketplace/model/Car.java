package carmarketplace.model;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private long kilometers;
    private Transmission transmission;
    private FuelType fuelType;
    private BodyType bodyType;

    public Car(String brand, String model, int year, long kilometers, Transmission transmission, FuelType fuelType, BodyType bodyType) {
        this.brand = brand;
        this.model = model;

        int currentYear = LocalDate.now().getYear();
        if(year <= currentYear && year > 2005) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year out of range");
        }

        if(kilometers > 0) {
            this.kilometers = kilometers;
        } else {
            throw new IllegalArgumentException("Kilometers cannot be negative");
        }
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
    }

    public String getBrand() {
        return brand;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", kilometers=" + kilometers +
                ", transmission=" + transmission +
                ", fuelType=" + fuelType +
                ", bodyType=" + bodyType +
                '}';
    }
}
