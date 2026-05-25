package tests.reqres.pojo.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonInfo(
        int id,
        String name,
        int year,
        String color,
        @JsonProperty("pantone_value") String pantoneValue
) {
}
