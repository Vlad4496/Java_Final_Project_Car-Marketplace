package carmarketplace.services;

import carmarketplace.entity.Car;
import carmarketplace.entity.Listing;
import carmarketplace.entity.User;
import carmarketplace.model.CarDTO;
import carmarketplace.model.CreateListingRequest;
import carmarketplace.model.ListingDTO;
import carmarketplace.model.UserDTO;
import carmarketplace.repository.CarRepository;
import carmarketplace.repository.ListingRepository;
import carmarketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    private final ListingRepository listingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public ListingService(ListingRepository repository, CarRepository carRepository, UserRepository userRepository) {
        this.listingRepository = repository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public ListingDTO getListingById(Long id) {
        return listingRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() ->
                new RuntimeException("Listing not found with id " + id)
        );
    }

    public List<ListingDTO> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(listing -> this.toDto(listing))
                .toList();
    }

    public ListingDTO createListing(CreateListingRequest request) {

        Car car = carRepository.findById(request.carId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Listing listing = new Listing();
        listing.setCar(car);
        listing.setSeller(user);
        listing.setPrice(request.price());
        listing.setDescription(request.description());

        Listing saved = listingRepository.save(listing);
        return toDto(saved);
    }

    public void deleteListingById(Long id) {
        listingRepository.deleteById(id);
    }

    private ListingDTO toDto(Listing listing) {
        return new ListingDTO(
                listing.getId(),
                new CarDTO(
                        listing.getCar().getId(),
                        listing.getCar().getBrand(),
                        listing.getCar().getModel(),
                        listing.getCar().getYear()
                ),
                new UserDTO(
                        listing.getSeller().getId(),
                        listing.getSeller().getFirstName(),
                        listing.getSeller().getLastName(),
                        listing.getSeller().getEmail()
                ),
                listing.getPrice(),
                listing.getDescription()
        );
    }
}
