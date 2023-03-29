package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
     @Autowired
    MovieService movieService;
     @PostMapping("/add-movie")
    public ResponseEntity<String>addMovie(@RequestBody Movie movie){
         String ans= movieService.addMovie(movie);
       return  new ResponseEntity<>(ans, HttpStatus.CREATED);
     }
     @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
         String ans= movieService.addDirector(director);
         return new ResponseEntity<>(ans,HttpStatus.CREATED);
     }
     @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam ("movieName") String movieName,
                                                      @RequestParam("directorName")String directorName){
        String ans=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
     }
     @GetMapping("/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name){

        Movie movie1 =movieService.getMovieByName(name);
        return new ResponseEntity<>(movie1,HttpStatus.OK);
     }
     @GetMapping("/get-director-by-name")
    public ResponseEntity<Director>getDirectorByName(@RequestParam("name") String directorName){
         Director director=movieService.getDirectorByName(directorName);
         return new ResponseEntity<>(director,HttpStatus.OK);
     }
     @GetMapping("/get-movies-by-director-name")
     public ResponseEntity<List<String>>getMoviesByDirectorName(@RequestParam("director") String director){
         List<String>movieList=movieService.getListOfMovieNameByDirector(director);

         return new ResponseEntity<>(movieList,HttpStatus.OK);
     }
     @GetMapping("/get-all-movies")
       public ResponseEntity<List<String >> findAllMovies(){
         List<String >movieList=movieService.getAllMovies();
         return new ResponseEntity<>(movieList,HttpStatus.OK);
     }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam("directorName") String directorName){
         return new ResponseEntity<>(movieService.deleteDirectorByName(directorName),HttpStatus.OK);
    }
   @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
         return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.OK);
   }
}
