package carmarketplace;

import carmarketplace.model.*;
import carmarketplace.builder.ListingBuilder;
import carmarketplace.services.MarketplaceService;
import carmarketplace.services.PriceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);

        MarketplaceService service =
                context.getBean(MarketplaceService.class);
        Scanner scanner = new Scanner(System.in);

        Listing listing = ListingBuilder.fromConsole(scanner);
        service.addListing(listing);

        PriceFilter pf = new PriceFilter(120000);
        service.filterListings(pf)
                .forEach(System.out::println);
    }
}
