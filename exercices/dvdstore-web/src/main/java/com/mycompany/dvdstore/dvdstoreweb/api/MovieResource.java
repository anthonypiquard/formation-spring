package com.mycompany.dvdstore.dvdstoreweb.api;

import com.mycompany.dvdstore.dvdstoreweb.form.MovieForm;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.DefaultMovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    @GetMapping
    public Iterable<Movie> list(){
        return movieServiceInterface.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        Movie movie = movieServiceInterface.getMovieById(id);
        return movie;
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
        return movieServiceInterface.registerMovie(movie);
    }

}
