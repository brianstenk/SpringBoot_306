package com.example.springboot_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    @RequestMapping("/")
    public String index(Model model){
        Director director= new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars...");

        Set<Movie> movieSet = new HashSet<Movie>();
        movieSet.add(movie);

        movie = new Movie();
        movie.setTitle("DeathStar Eworks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on DeathStars...");
        movieSet.add(movie);

        //Add the list of movies to teh director
        director.setMovies(movieSet);

        //save the Director
        directorRepository.save(director);

        //Grab all the directors and send them to the template
        model.addAttribute("directors", directorRepository.findAll());


        return "index";
    }
}
