package com.targetindia;

import com.targetindia.model.MovieList;
import com.targetindia.utils.KeyboardUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SearchMovies {
    public static void main(String[] args) {
        String searchText = KeyboardUtil.getString("Enter movie name to search: ");
        String apikey = "aa9e49f";
        String url = String.format("https://www.omdbapi.com/?apikey=%s&s=%s", apikey, searchText);

        RestTemplate template = new RestTemplate();
        var movieList = template.getForObject(url, MovieList.class);
        System.out.println("Total results = " + movieList.getTotalResults());
        System.out.println("Movie titles: ");
        movieList.getMovies()
                .stream()
                .map(m -> m.getTitle() + " (" + m.getYear() + ")")
                .forEach(System.out::println);
    }
}
