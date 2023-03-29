package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
   @Autowired
    MovieRepository movieRepository;
   public String addMovie(Movie movie){
       String ans=movieRepository.addMovie(movie);
       return ans;
   }
   public String addDirector(Director director){
       String ans =movieRepository.addDirector(director);
       return ans;
    }
    public String addMovieDirectorPair(String movieName ,String directorName){
       String ans=movieRepository.addMovieDirectorPair(movieName,directorName);
       return  ans;
    }
    public  Movie getMovieByName(String movieName){
      Movie movie1=movieRepository.getMovieByName(movieName);

      return movie1 ;

    }
    public Director getDirectorByName(String directorName){
       Director director=movieRepository.getDirectorByName(directorName);
       return director;
    }
    public List<String> getListOfMovieNameByDirector(String directorName ){
       List<String>movieList=movieRepository.getListOfMovieNameByDirector(directorName);
       return movieList;
    }
   public List<String> getAllMovies(){
       List<String>movieList=movieRepository.getAllMovies();
       return movieList;
   }
   public String deleteDirectorByName(String directorName){
       return movieRepository.deleteDirectorByName(directorName);
   }
   public String  deleteAllDirectors(){
       return movieRepository.removeEverything();
   }

}
