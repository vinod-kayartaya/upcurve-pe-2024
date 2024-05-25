package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieList {
    @JsonProperty("Search")
    private List<Movie> movies;
    @JsonProperty("totalResults")
    private Integer totalResults;
}
