package carmarketplace.builder;

import carmarketplace.model.*;

import java.util.Scanner;

public class ListingBuilder {

    public static Listing fromConsole(Scanner sc) {
        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Model: ");
        String model = sc.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Km: ");
        int km = Integer.parseInt(sc.nextLine());

        System.out.print("Transmission (AUTOMATE / MANUAL): ");
        Transmission transmission =
                Transmission.valueOf(sc.nextLine().trim().toUpperCase());

        System.out.print("Fuel (GASOLINE / DIESEL / HYBRID): ");
        FuelType fuel =
                FuelType.valueOf(sc.nextLine().trim().toUpperCase());

        System.out.print("Body (SEDAN / SUV): ");
        BodyType body =
                BodyType.valueOf(sc.nextLine().trim().toUpperCase());

        Car car = new Car(brand, model, year, km, transmission, fuel, body);

        System.out.print("Seller name: ");
        String firstName = sc.nextLine();

        System.out.print("Seller last name: ");
        String lastName = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        User user = new User(firstName, lastName, email, age, phone);

        System.out.print("Price: ");
        int price = Integer.parseInt(sc.nextLine());

        System.out.print("Description: ");
        String desc = sc.nextLine();

        return new Listing(0, car, user, price, desc);
    }
}
