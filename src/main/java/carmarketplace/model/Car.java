package carmarketplace.model;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final long kilometers;
    private final Transmission transmission;
    private final FuelType fuelType;
    private final BodyType bodyType;

    public Car(String brand, String model, int year, long kilometers, Transmission transmission, FuelType fuelType, BodyType bodyType) {
        this.brand = Objects.requireNonNull(brand);
        this.model = Objects.requireNonNull(model);

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
        this.transmission = Objects.requireNonNull(transmission);
        this.fuelType = Objects.requireNonNull(fuelType);
        this.bodyType = Objects.requireNonNull(bodyType);
    }

    public String getModel() {
        return model;
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
