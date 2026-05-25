package tests.specification.dto.user;

public record TokenDto(
        String token,
        String expires,
        String status,
        String result
) {
}
