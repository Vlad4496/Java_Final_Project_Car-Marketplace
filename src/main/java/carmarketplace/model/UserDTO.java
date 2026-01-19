package carmarketplace.model;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email
) {}