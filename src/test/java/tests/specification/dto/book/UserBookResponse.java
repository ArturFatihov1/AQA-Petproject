package tests.specification.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserBookResponse(
        @JsonProperty("books") List<CollectionOfIsbn> books) {
}
