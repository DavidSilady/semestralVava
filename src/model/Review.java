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
public class Review {
    private String username;
    private String title;
    private String commentary;
    private byte score;

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
}