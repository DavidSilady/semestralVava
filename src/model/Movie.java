/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author adamg
 */
public class Movie extends Video{
    private ArrayList<Movie> sequels;
    private ArrayList<Movie> prequels;

    public ArrayList<Movie> getSequels() {
        return sequels;
    }

    public void setSequels(ArrayList<Movie> sequels) {
        this.sequels = sequels;
    }

    public ArrayList<Movie> getPrequels() {
        return prequels;
    }

    public void setPrequels(ArrayList<Movie> prequels) {
        this.prequels = prequels;
    }
    
    public void addSequel(Movie sequel){
        this.sequels.add(sequel);
    }
    
    public void addPrequel(Movie prequel){
        this.prequels.add(prequel);
    }

    public Movie(String title, String genre, short length, short year, String studio, String curiosity, String director) {
        super(title, genre, length, year, studio, curiosity, director);
        this.sequels = new ArrayList<>();
        this.prequels = new ArrayList<>();
    }    
}
