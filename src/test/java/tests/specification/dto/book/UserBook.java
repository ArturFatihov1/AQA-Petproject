package tests.specification.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserBook(
        String userId,
        // Указываем, что в JSON это поле называется "books"
        @JsonProperty("books") List<CollectionOfIsbn> collectionOfIsbns) {
}