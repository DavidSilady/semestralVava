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
@XmlRootElement(name = "reviews")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reviews {
    @XmlElement(name = "review")
    private ArrayList<Review> recenzie;

    public ArrayList<Review> getRecenzie() {
        return recenzie;
    }

    public Reviews() {
    }

    public Reviews(ArrayList<Review> recenzie) {
        this.recenzie = recenzie;
    }

    @Override
    public String toString() {
        return "Reviews{" + "recenzie=" + recenzie + '}';
    }
    
    
}
