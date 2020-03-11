/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import java.io.Serializable;
import java.util.List;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import model.dao.MovieDAO;
import model.entity.Movie;
/**
 *
 * @author Spondon
 */
@Data
@Named
@ViewScoped
public class MovieBackingBean implements Serializable {
    
    @EJB
    MovieDAO movieDAO;

    private List<Movie> movies;
    
    //private String key = "10dfedc564f5b41f3c803582d1d3a5fa";
    
    private String url = "https://api.themoviedb.org/3/discover/movie?api_key=10dfedc564f5b41f3c803582d1d3a5fa&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false";

    
    private String test;
    
    @PostConstruct
    private void init(){
       test = "Hello world";
       try{
       movies = movieDAO.getTopMovies(url + "&page=1");
       } catch (IOException ex){
           System.out.println(ex.toString());
       }
    }
    
    public List<Movie> getTopMovies(String page){
        try{
            movies = movieDAO.getTopMovies(url + "&page=" + page);
            return movies;
        } catch (IOException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
}
