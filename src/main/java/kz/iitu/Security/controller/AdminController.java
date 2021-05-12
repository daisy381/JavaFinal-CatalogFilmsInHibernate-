package kz.iitu.Security.controller;

import kz.iitu.Security.entity.Movie;
import kz.iitu.Security.service.MovieService;
import kz.iitu.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/admin/add")
    public String openNewMoviePage(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "add";
    }

    @PostMapping("/admin/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/";
    }

    @GetMapping("/admin/update/{id}")
    public String openUpdatePage(@PathVariable(value ="id") Long id, Model model){
        Movie movie =  movieService.getMovieById(id);
        model.addAttribute("movie",movie);
        return "update";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteMovie(@PathVariable(value = "id")Long id){
        movieService.deleteMovie(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String userList(Model model,Model model2) {
        model2.addAttribute("listMovie",movieService.getAllMovies());
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }
}
