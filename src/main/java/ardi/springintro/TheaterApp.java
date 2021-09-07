package ardi.springintro;

import ardi.springintro.service.MovieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TheaterApp {

    /*
    * Munculkan list of movies dari episode starwars
    *
    * */

    @Value("${theaterapp.host}")
    private String domain;

    @Autowired
    private MovieProvider starwarsMovie;

    public void playTheater(){

        // title
        System.out.println("Starwars Theater");
        System.out.println("=================");

        System.out.println("App running in : " + domain);


        // munculkan daftar movie starwars
        starwarsMovie.getMovies()
                .forEach(movie -> System.out.println(movie));

    }

}
