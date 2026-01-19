package carmarketplace.controller;

import carmarketplace.model.CreateListingRequest;
import carmarketplace.model.ListingDTO;
import carmarketplace.services.ListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    // GET /api/listings
    @GetMapping
    public List<ListingDTO> getAllListings() {
        return listingService.getAllListings();
    }

    // GET /api/listings/{id}
    @GetMapping("/{id}")
    public ListingDTO getListingById(@PathVariable long id) {
        return listingService.getListingById(id);
    }

    // POST /api/listings
    @PostMapping
    public ListingDTO createListing(@RequestBody CreateListingRequest request) {
        return listingService.createListing(request);
    }

    // DELETE /api/listings/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListingById(@PathVariable long id) {
        listingService.deleteListingById(id);
        return ResponseEntity.noContent().build();
    }
}

