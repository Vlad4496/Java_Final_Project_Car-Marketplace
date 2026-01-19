package carmarketplace.model;

public record CarDTO(
        Long id,
        String brand,
        String model,
        int year
) {}