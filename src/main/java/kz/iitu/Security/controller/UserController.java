package kz.iitu.Security.controller;

import kz.iitu.Security.repository.MovieRepository;
import kz.iitu.Security.service.MovieService;
import kz.iitu.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("movies",movieService.getAllMovies());
        return "home";
    }
}