package tests.specification.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserProfileBook(
        String userId,
        String username,
        List<Book> books,
        String code,
        String message
) {
}
