package kz.iitu.Security.controller;

import kz.iitu.Security.entity.Movie;
import kz.iitu.Security.service.MovieService;
import kz.iitu.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class MainController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getMovie/{id}")
    public String getMovie(Model model, @PathVariable("id") Long id){
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie"; //создаем новый homeAdmin.html
    }

    @GetMapping("/")
    public String getAllMovies(Model model){
        model.addAttribute("movies",movieService.getAllMovies());
        return "movies";
    }
}
