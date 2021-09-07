package ardi.springintro.service;

import ardi.springintro.model.Movie;

import java.util.List;

public interface MovieProvider {

    public List<Movie> getMovies();

    public Movie getMovie(int index);

    public boolean saveMovie(Movie movie);

    public boolean deleteMovie();

}
