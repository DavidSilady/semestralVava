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
public abstract class Video {

    private String title;
    private String genre;
    private short length;
    private short year;
    private String studio;
    private ArrayList<VideoCharacter> characters;
    private String curiosity;
    private ArrayList<Byte> ratings;
    private String director;
    private ArrayList<Review> reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public ArrayList<VideoCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<VideoCharacter> characters) {
        this.characters = characters;
    }

    public String getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(String curiosity) {
        this.curiosity = curiosity;
    }

    public ArrayList<Byte> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Byte> ratings) {
        this.ratings = ratings;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addRating(byte rating) {
        this.ratings.add(rating);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void updateRating(int indexRating, byte value) {
        this.ratings.set(indexRating, value);
    }

    public void addVideoCharacter(VideoCharacter videoCharacter) {
        this.characters.add(videoCharacter);
    }

    public Video(String title, String genre, short length, short year, String studio, String curiosity, String director) {
        this.title = title;
        this.genre = genre;
        this.length = length;
        this.year = year;
        this.studio = studio;
        this.curiosity = curiosity;
        this.director = director;
        this.characters = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }
}
