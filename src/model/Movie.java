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
 *
 * @author adamg
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie extends Video {
    @XmlElement(name = "relatedIndeces")
    private ArrayList<Integer> relatedIndeces = new ArrayList<>();

    public Movie(String title, String genre, short length, short year, String studio, ArrayList<VideoCharacter> characters, String curiosity, Rating ratings, String director, ArrayList<Integer> relatedIndeces) {
        super(title, genre, length, year, studio, characters, curiosity, ratings, director);
        this.relatedIndeces = relatedIndeces;
    }

    public Movie() {
    }

    public ArrayList<Integer> getRelatedIndeces() {
        return relatedIndeces;
    }

    public void setRelated(ArrayList<Integer> relatedIndeces) {
        this.relatedIndeces = relatedIndeces;
    }
    
    public void addRelated(Integer relatedIndex){
        this.relatedIndeces.add(relatedIndex);
    }

    @Override
    public String toString() {
        return "Movie{" + super.toString() + "related=" + relatedIndeces.toString() + '}';
    }

    @Override
    public String getType() {
        return "Movie";
    }
}