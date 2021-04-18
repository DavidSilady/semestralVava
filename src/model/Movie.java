/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author adamg
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie extends Video {

    private ArrayList<Movie> related;

    public Movie(String title, String genre, short length, short year, String studio, ArrayList<VideoCharacter> characters, String curiosity, Rating ratings, String director, ArrayList<Movie> related) {
        super(title, genre, length, year, studio, characters, curiosity, ratings, director);
        this.related = related;
    }

    public Movie() {
    }

    public ArrayList<Movie> getRelated() {
        return related;
    }

    public void setRelated(ArrayList<Movie> related) {
        this.related = related;
    }
    
    public void addRelated(Movie movie){
        this.related.add(movie);
    }

    @Override
    public String toString() {
        return "Movie{" + super.toString() + "related=" + related + '}';
    }

}