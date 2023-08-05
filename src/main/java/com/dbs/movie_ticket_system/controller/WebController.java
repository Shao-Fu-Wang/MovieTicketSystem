package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.Movie;
import com.dbs.movie_ticket_system.entity.Showtime;
import com.dbs.movie_ticket_system.repository.MovieRepository;
import com.dbs.movie_ticket_system.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowtimeRepository showtimeRepository;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/test")
    public String test() {
        return "customer_booking";
    }



    @GetMapping("/customer/{username}/home")
    public String customer_boarding(Principal principal, Model model) {
        model.addAttribute("home_url", "/customer/" + principal.getName() + "home");
        model.addAttribute("username", principal.getName());
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute("username", principal.getName());
        model.addAttribute("movies", movieList);
        List<Showtime> showtimeList = showtimeRepository.findAll();
        model.addAttribute("showtimes", showtimeList);
        return "customer_home";
    }
    @GetMapping("/customer/{username}/amend")
    public String amend(Principal principal, Model model) {
        model.addAttribute("home_url", "/customer/" + principal.getName() + "home");
        model.addAttribute("username", principal.getName());
        return "amend";
    }
    @GetMapping("/customer/{username}/about")
    public String about(Principal principal, Model model) {
        model.addAttribute("home_url", "/customer/" + principal.getName() + "home");
        model.addAttribute("username", principal.getName());
        return "about";
    }
    @GetMapping("/customer/{username}/{movieId}/{date}/{timeslot}/seatbooking")
    public String seatbooking(Principal principal, Model model) {
//        model.addAttribute("home_url", "/customer/" + principal.getName() + "home");
//        model.addAttribute("username", principal.getName());
        return "customer_booking";
    }


}
