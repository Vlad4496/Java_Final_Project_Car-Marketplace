package carmarketplace;

import carmarketplace.builder.ListingBuilder;
import carmarketplace.services.MarketplaceService;
import carmarketplace.services.PriceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        MarketplaceService service = context.getBean(MarketplaceService.class);
        ListingBuilder builder = context.getBean(ListingBuilder.class);
        PriceFilter priceFilter = context.getBean(PriceFilter.class);

        var listing = builder.fromConsole();
        service.addListing(listing);

        service.filterListings(priceFilter).forEach(System.out::println);
    }
}
