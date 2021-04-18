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
@XmlRootElement(name = "tvshows")
@XmlAccessorType(XmlAccessType.FIELD)
public class TVShows {

    @XmlElement(name = "tvshow")
    private ArrayList<TVShow> serialy;

    public ArrayList<TVShow> getSerialy() {
        return serialy;
    }

    public TVShows() {
    }

    public TVShows(ArrayList<TVShow> serialy) {
        this.serialy = serialy;
    }

    @Override
    public String toString() {
        return "TVShows{" + "serialy=" + serialy.toString() + '}';
    }

}
