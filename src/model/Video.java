/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Listable;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;

/**
 *
 * @author adamg
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Video implements Listable {
    
    private final static byte CSFD = 1;
    private final static byte IMDB = 2;
    private final static byte OURS = 3;

    private int id;
    private String title;
    private String genre;
    private short length;
    private short year;
    private String studio;
    private String director;
    private String curiosity;
    
    private Rating ratings;
    
    private ArrayList<VideoCharacter> characters;

    private ArrayList<Review> reviews;

    private String relevantSortInfo = "";

    public String getRelevantSortInfo() {
        return relevantSortInfo;
    }

    public void setRelevantSortInfo(String relevantSortInfo) {
        this.relevantSortInfo = relevantSortInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Rating getRatings() {
        return ratings;
    }

    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public ArrayList<Review> getReviews() {
        setupReviews();
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
        setupReviews();
    }

    public int getNumberOfReviews() {
        return this.reviews.size();
    }

    private void setupReviews() {
        for (Review review : this.reviews) {
            AppState.debug(review.toString());
            review.setVideo(this);
        }
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        
        byte newRating = countNewRating();
        
        updateRating(OURS, newRating);   // po pridani recenzie k filmu uprav aj rating nasich uzivatelov
    }

    public void addVideoCharacter(VideoCharacter videoCharacter) {
        this.characters.add(videoCharacter);
    }
    
    public void updateRating(int typRating, byte value) {
        
        switch (typRating) {
            case IMDB:
                this.ratings.setImdb(value);
                break;
            case CSFD:
                this.ratings.setCsfd(value);
                break;
            case OURS:
                this.ratings.setOurs(value);
                break;
            default:
                System.out.println(" Nepodporovany typ ratingu  " + typRating);
                break;
        }
    }

    public int getAvgRating() {
        return (this.ratings.getCsfd() + this.ratings.getImdb() + this.ratings.getOurs()) / 3;
    }
    
    public byte countNewRating(){
        byte result = 0;
        
        int suma = 0;
        for (int i = 0; i < reviews.size(); i++) {
            Review rev = reviews.get(i);
                suma+=rev.getScore();
        }
        
        result = (byte)(suma/reviews.size());
        
        return result;
    }
    
    public Video(String title, String genre, short length, short year, String studio, ArrayList<VideoCharacter> characters, String curiosity, Rating ratings, String director) {
        this.title = title;
        this.genre = genre;
        this.length = length;
        this.year = year;
        this.studio = studio;
        this.characters = characters;
        this.curiosity = curiosity;
        this.ratings = ratings;
        this.director = director;
        this.reviews = new ArrayList<>();
        setupReviews();
    }

    public Video() {
        this.reviews = new ArrayList<>();
        setupReviews();
    }

    public String getType() {
        return "";
    }

    @Override
    public String toString() {
        return "Video{" + "id=" + id + ", title=" + title + ", genre=" + genre + ", length=" + length + ", year=" + year + ", studio=" + studio + ", characters=" + characters.toString() + ", curiosity=" + curiosity + ", ratings=" + ratings + ", director=" + director + '}';
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    };
}
