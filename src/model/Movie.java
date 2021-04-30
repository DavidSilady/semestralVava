/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author adamg
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie extends Video {
//    @XmlElement(name = "relatedIndices")
    private ArrayList<Integer> relatedIndices = new ArrayList<>();

    public Movie(String title, String genre, short length, short year, String studio, ArrayList<VideoCharacter> characters, String curiosity, Rating ratings, String director, ArrayList<Integer> relatedIndices) {
        super(title, genre, length, year, studio, characters, curiosity, ratings, director);
        this.relatedIndices = relatedIndices;
    }

    public Movie() {
    }

    public ArrayList<Integer> getRelatedIndices() {
        return relatedIndices;
    }

    public void setRelatedIndices(ArrayList<Integer> relatedIndices) {
        this.relatedIndices = relatedIndices;
    }
    
    public void addRelated(Integer relatedIndex){
        this.relatedIndices.add(relatedIndex);
    }

    @Override
    public String toString() {
        return "Movie{" + super.toString() + "related=" + relatedIndices.toString() + '}';
    }

    @Override
    public String getType() {
        return "Movie";
    }
}