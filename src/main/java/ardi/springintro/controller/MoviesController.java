package ardi.springintro.controller;

import ardi.springintro.model.Movie;
import ardi.springintro.service.MovieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class MoviesController {

  @Autowired
  private MovieProvider starwarsMovie;

  @GetMapping("/movies")
  public List<Movie> getMovies() {
    List<Movie> movies = starwarsMovie.getMovies();

    return movies;
  }

  @GetMapping("/movies/{index}")
  public Movie getMovie(@PathVariable(name = "index") int urutan) {
    Movie movie = starwarsMovie.getMovie(urutan);

    return movie;
  }

  @PostMapping("/movies")
  public boolean saveMovies(@RequestBody Movie movie) {
    boolean status = starwarsMovie.saveMovie(movie);

    return status;
  }

  @DeleteMapping("/movies")
  public boolean deleteMovies() {
    boolean status = starwarsMovie.deleteMovie();

    return status;
  }

  @GetMapping("/movies-episode")
  public Movie getMovieEpisode(@RequestParam(name = "episode") int index) {
    Movie movie = starwarsMovie.getMovies().get(index-1);

    return movie;
  }

}
