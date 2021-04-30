/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Listable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author adamg
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Review implements Listable {

    @XmlTransient
    private User user;

    @XmlTransient
    private Video video;

    private Integer movieIndex;
    private Integer tvShowIndex;
    private String username;
    private String title;
    private String commentary;
    private byte score;

    private Video getVideoFromIndex() {
        if (movieIndex == null) {
            return AppState.getInstance().getTvshows().get(tvShowIndex);
        } else {
            return AppState.getInstance().getMovies().get(movieIndex);
        }
    }

    public Video getVideo() {
        if (video == null) {
            return getVideoFromIndex();
        } else {
            return video;
        }
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    private User getUserFromUsername() {
        for (User user : AppState.getInstance().getUsers()) {
            if (user.getUsername().equals(this.username)) {
                return user;
            }
        }
        return null;
    }

    public User getUser() {
        if (this.user == null) {
            return getUserFromUsername();
        } else {
            return user;
        }

    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMovieIndex() {
        return movieIndex;
    }

    public void setMovieIndex(Integer movieIndex) {
        this.movieIndex = movieIndex;
    }

    public Integer getTvShowIndex() {
        return tvShowIndex;
    }

    public void setTvShowIndex(Integer tvShowIndex) {
        this.tvShowIndex = tvShowIndex;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public Review(String username, String title, String commentary, byte score) {
        this.username = username;
        this.title = title;
        this.commentary = commentary;
        this.score = score;
    }

    public Review(Integer movieIndex, Integer tvShowIndex, String username, String title, String commentary, byte score) {
        this.movieIndex = movieIndex;
        this.tvShowIndex = tvShowIndex;
        this.username = username;
        this.title = title;
        this.commentary = commentary;
        this.score = score;
    }
    
    public Review() {

    }
}
