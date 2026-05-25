package tests.specification.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserBookRequest(
        String userId,
        @JsonProperty("collectionOfIsbns") List<CollectionOfIsbn> collectionOfIsbns) {
}
