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
public class TVShow extends Video{
    private byte seasonCount;
    private short episodeCount;

    public byte getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(byte seasonCount) {
        this.seasonCount = seasonCount;
    }

    public short getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(short episodeCount) {
        this.episodeCount = episodeCount;
    }

    public TVShow(String title, String genre, short length, short year, String studio, ArrayList<VideoCharacter> characters, String curiosity, Rating ratings, String director, byte seasonCount, short episodeCount) {
        super(title, genre, length, year, studio, characters, curiosity, ratings, director);
        this.seasonCount = seasonCount;
        this.episodeCount = episodeCount;
    }

    public TVShow() {
        super();
    }

    @Override
    public String toString() {
        return "TVShow{" + super.toString() + "seasonCount=" + seasonCount + ", episodeCount=" + episodeCount + '}';
    }

    @Override
    public String getType() {
        return "TV Show";
    }
}
