package tests.reqres.pojo.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResourcesRoot(
        int page,
        @JsonProperty("per_page") int perPage,
        int total,
        @JsonProperty("total_pages") int totalPages,
        ArrayList<PersonInfo> data
) {
}
