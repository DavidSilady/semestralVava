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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adamg
 */
@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {

    @XmlElement(name = "movie")
    private ArrayList<Movie> filmy;

    @Override
    public String toString() {
        return "Movies{" + "filmy=" + filmy.toString() + '}';
    }

    public Movies(ArrayList<Movie> filmy) {
        this.filmy = filmy;
    }

    public Movies() {
    }

    public ArrayList<Movie> getFilmy() {
        return filmy;
    }

}
