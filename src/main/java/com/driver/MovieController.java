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
     @PostMapping("/addMovie")
    public ResponseEntity<String>addMovie(@RequestBody Movie movie){
         String ans= movieService.addMovie(movie);
       return  new ResponseEntity<>(ans, HttpStatus.CREATED);
     }
     @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
         String ans= movieService.addDirector(director);
         return new ResponseEntity<>(ans,HttpStatus.CREATED);
     }
     @PostMapping("/addMovieDirectorPair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam ("movieName") String movieName,
                                                      @RequestParam("directorName")String directorName){
        String ans=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
     }
     @GetMapping("/getMovieByName")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("movieName") String movieName){

        Movie movie1 =movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie1,HttpStatus.OK);
     }
     @GetMapping("/getDirectorByName")
    public ResponseEntity<Director>getDirectorByName(@RequestParam("directorName") String directorName){
         Director director=movieService.getDirectorByName(directorName);
         return new ResponseEntity<>(director,HttpStatus.OK);
     }
     @GetMapping("/getListMovieName")
     public ResponseEntity<List<String>>getListOfMovieNameByDirector(@RequestParam("directorName") String directorname){
         List<String>movieList=movieService.getListOfMovieNameByDirector(directorname);

         return new ResponseEntity<>(movieList,HttpStatus.OK);
     }
     @GetMapping("/findAllMovies")
       public ResponseEntity<List<String >> getAllMovies(){
         List<String >movieList=movieService.getAllMovies();
         return new ResponseEntity<>(movieList,HttpStatus.OK);
     }
    @DeleteMapping("/deleteDirectorByName")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam("directorName") String directorName){
         return new ResponseEntity<>(movieService.deleteDirectorByName(directorName),HttpStatus.OK);
    }
   @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors(){
         return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.OK);
   }
}
