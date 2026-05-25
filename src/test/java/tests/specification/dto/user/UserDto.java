package tests.specification.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import tests.specification.dto.book.Book;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDto(
        @JsonProperty("userID") String userID,
        @JsonProperty("username") String username,
        List<Book> books,
        String code,
        String message) {
}