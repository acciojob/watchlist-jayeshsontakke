package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    HashMap<String,Movie>movieDb=new HashMap<>();
    HashMap<String,Director>directorDb=new HashMap<>();
    HashMap<String,String>movieDirectorPair=new HashMap<>();
    public String addMovie(Movie movie){
       String key= movie.getName();
       movieDb.put(key,movie);
       return  "Movie added successfully";
    }
    public String addDirector(Director director){
        String key=director.getName();
        directorDb.put(key,director);
        return "Director added successfully";
    }
    public  String addMovieDirectorPair(String movieName,String directorName){
        String key=movieName;
        movieDirectorPair.put(key,directorName);
        return "successfully added pair ";
    }
    public  Movie getMovieByName(String movieName){
       for(Movie movie1:movieDb.values()){
           if(movie1.getName().equals(movieName)){
               return movie1;
           }
       }
     return null;
    }
    public  Director getDirectorByName(String directorName){
      for(Director director:directorDb.values()){
          if(director.getName().equals(directorName)){
              return director;
          }
      }
        return null;
    }
    public List<String> getListOfMovieNameByDirector(String directorName){
        List<String>movieList=new ArrayList<>();
        for(String director:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(director).equals(directorName)){
                movieList.add(director);
            }
        }
        return movieList;
    }
    public List<String> getAllMovies(){
        return new ArrayList<>(movieDirectorPair.keySet());
    }
    public String deleteDirectorByName(String directorName){
        // delete from directorDb
        //movie hashMap also
        directorDb.remove(directorName);
       for(Map.Entry<String ,String>entry:movieDirectorPair.entrySet()){
           if(entry.getValue().equals(directorName)){
               String movieName=entry.getValue();
               movieDb.remove(movieName);
               movieDirectorPair.remove(movieName);
           }
       }
       return "director removed successfully";
    }
    public String removeEverything(){
        for(String directorName:directorDb.keySet()){
            for(Map.Entry<String ,String>entry:movieDirectorPair.entrySet()){
                if(entry.getValue().equals(directorName)){
                    String movieName=entry.getValue();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }

        }
        return "Deleted EveryThing Successfully";
    }
}
