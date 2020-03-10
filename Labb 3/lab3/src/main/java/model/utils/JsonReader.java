/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.utils;

/**
 *
 * @author jespe
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import model.entity.*;
import com.fasterxml.jackson.databind.*;
import java.util.Iterator;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  
  public static List<Movie> getMoviesFromUrl(String url) throws IOException, JSONException {
      JSONObject json = readJsonFromUrl(url);
      List<Movie> movies = new ArrayList<>();
      
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode tree = objectMapper.readTree(json.toString());
      JsonNode paths = tree.get("results");
      
      Iterator<JsonNode> fields = paths.elements();
      while(fields.hasNext()){
           
            JsonNode field = fields.next();
            
            String title = field.findValue("title").asText();
            String avg_rating = field.findValue("vote_average").asText();
            String overview = field.findValue("overview").asText();
            String release_date = field.findValue("release_date").asText();
            String poster_path = field.findValue("poster_path").asText();
            
            Movie movie = new Movie(
                    title
                    ,avg_rating
                    ,overview
                    ,release_date
                    ,poster_path
            );
            
            movies.add(movie);      
      }
      return movies;
      
  }
 

}