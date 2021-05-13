package kz.iitu.Security.controller;

import kz.iitu.Security.repository.MovieRepository;
import kz.iitu.Security.service.MovieService;
import kz.iitu.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("movies",movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/home/{id}")
    public String getMovie(Model model, @PathVariable("id") Long id){
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie"; //создаем новый homeAdmin.html
    }

    @GetMapping("/profile")
    public String profileById(){
        return "profile";
    }

}