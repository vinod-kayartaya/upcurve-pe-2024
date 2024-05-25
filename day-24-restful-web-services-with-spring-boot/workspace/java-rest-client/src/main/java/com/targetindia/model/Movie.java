package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("imdbID")
    private String imdbId;
    @JsonProperty("Poster")
    private String posterUrl;
    @JsonProperty("Type")
    private String type;
}
