package kz.iitu.Security.controller;

import kz.iitu.Security.entity.User;
import kz.iitu.Security.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private  MovieRepository movieRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "home";
    }
}
