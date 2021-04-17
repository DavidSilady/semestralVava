/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adamg
 */
public class TVShow extends Video {

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

    public TVShow(String title, String genre, short length, short year, String studio, String curiosity, String director, byte seasonCount, short episodeCount) {
        super(title, genre, length, year, studio, curiosity, director);
        this.seasonCount = seasonCount;
        this.episodeCount = episodeCount;
    }
}
