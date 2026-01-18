package carmarketplace.builder;

import carmarketplace.model.*;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ListingBuilder {

    private final Scanner scanner;

    public ListingBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    public Listing fromConsole() {

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Km: ");
        int km = Integer.parseInt(scanner.nextLine());

        System.out.print("Transmission (AUTOMATE / MANUAL): ");
        Transmission transmission =
                Transmission.valueOf(scanner.nextLine().trim().toUpperCase());

        System.out.print("Fuel (GASOLINE / DIESEL / HYBRID): ");
        FuelType fuel =
                FuelType.valueOf(scanner.nextLine().trim().toUpperCase());

        System.out.print("Body (SEDAN / SUV): ");
        BodyType body =
                BodyType.valueOf(scanner.nextLine().trim().toUpperCase());

        Car car = new Car(brand, model, year, km, transmission, fuel, body);

        System.out.print("Seller name: ");
        String firstName = scanner.nextLine();

        System.out.print("Seller last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        User user = new User(firstName, lastName, email, age, phone);

        System.out.print("Price: ");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        return new Listing(0, car, user, price, desc);
    }
}
