import model.*;
import services.MarketplaceService;
import services.PriceFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MarketplaceService service = new MarketplaceService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your preferred car (BMW / MERCEDES / ALL): ");
        String userInputValue = scanner.nextLine();

        String cmd = userInputValue == null ? "" : userInputValue.trim().toUpperCase();

        Listing l1 = new Listing(1, new Car("BMW", "M4", 2020, 50000, Transmission.AUTOMATE, FuelType.GASOLINE,BodyType.SEDAN), new User("Raul Vlad", "Merisor", "vlad_4496@yahoo.com", 29, "0799335599"), 54000, "Great competition car!");
        Listing l2 = new Listing(2, new Car("MERCEDES", "GLA", 2022, 64000, Transmission.MANUAl, FuelType.HYBRID,BodyType.SUV), new User("JON", "SNOW", "jon_snow@gmail.com", 47, "0723882322"), 120000, "Great family car!");

        List<Listing> listings = List.of(l1, l2);
        addListings(service, listings);

        switch (cmd) {
            case "BMW": {
                List<Listing> result = service.filterListings(l -> l.getCar().getBrand().equalsIgnoreCase("BMW"));
                result.forEach(System.out::println);
                break;

            }
            case "MERCEDES": {
                List<Listing> result = service.filterListings(l -> l.getCar().getBrand().equalsIgnoreCase("MERCEDES"));
                result.forEach(System.out::println);
                break;
            }
            case "ALL":
            case "": { // empty input = ALL
                System.out.println("All listings:");
                for (Listing l : service.getListing()) {   // or service.getListing() if that's your method
                    System.out.println(l);
                }
                break;
            }
            default:
                System.out.println("Invalid input");
                break;
        }

        PriceFilter pf = new PriceFilter(120000);
        List<Listing> byPrice = service.filterListings(pf);
        System.out.println("Filtered by price (<= 120000):");
        byPrice.forEach(System.out::println);
    }

    public static void addListings(MarketplaceService service, List<Listing> list) {
        for(Listing listing : list) {
            service.addListing(listing);
        }
    }
}