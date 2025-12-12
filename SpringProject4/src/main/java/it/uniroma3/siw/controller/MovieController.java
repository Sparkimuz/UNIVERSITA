package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.service.MovieService;

@Controller 
public class MovieController {
	
	
  @Autowired MovieService movieService;
  
  @GetMapping("/movie/{id}")
  public String getMovie(@PathVariable("id") Long id, Model model) {
    model.addAttribute("movie", this.movieService.findById(id));
    return "movie.html";
  }

  
  @GetMapping("/formNewMovie")
  public String formNewMovie(Model model) {
  model.addAttribute("movie", new Movie());
  return "formNewMovie.html";
}

@PostMapping("/movie")
public String newMovie(@ModelAttribute("movie") Movie movie, Model model) {
	this.movieService.save(movie);
  model.addAttribute("movie", movie);
    return "movie.html";
}


  
  @GetMapping("/movie")
  public String showMovies1(Model model) {
    model.addAttribute("movies", this.movieService.findAll());
    return "movies.html";
  }
  
  @GetMapping("/movies/{id}")
  public String getMovie1(@PathVariable("id") Long id, Model model) {
    model.addAttribute("movie", this.movieService.findById(id).getId());
    return "movie.html";
  }

  @GetMapping("/movies")
  public String showMovies(Model model) {
    model.addAttribute("movies", this.movieService.findAll());
    return "movies.html";
  }

}

