package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.dvdstoreweb.form.MovieForm;
import com.mycompany.dvdstore.entity.Actor;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.DefaultMovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private DefaultMovieService movieService = new DefaultMovieService();
    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        Movie movie = movieServiceInterface.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-details";
    }*/

    @PostMapping("/add")
    @Transactional
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){
        if (results.hasErrors()){
            return "add-movie-form";
        }else{
            Movie movie = new Movie();
            Actor actor = new Actor(movieForm.getPrenom(), movieForm.getNom());
            movie.setTitle(movieForm.getTitle());
            movie.setGenre(movieForm.getGenre());
            movie.setDescription(movieForm.getDescription());
            movie.setMainActor(actor);
            movieServiceInterface.registerMovie(movie);
            return "movie-added";
        }
    }

}
