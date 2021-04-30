package model;


import java.util.ArrayList;
import model.interfaces.Listable;
import model.interfaces.Passable;

import javax.xml.bind.annotation.XmlTransient;


public class User implements Listable, Passable {
    private String name = "";
    private String city = "";
    private String zip = "";
    private String address = "";
    private String password = "";
    private String username = "";

    private ArrayList<Movie> favMovies = new ArrayList<>();
    private ArrayList<TVShow> favTVShows = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();
    
    public User() { };

    public User(String name, String password, String username, ArrayList<Movie> favMovies, ArrayList<TVShow> favTVShows, ArrayList<Review> reviews) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.favMovies = favMovies;
        this.favTVShows = favTVShows;
        this.reviews = reviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Movie> getFavMovies() {
        return favMovies;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public void setFavMovies(ArrayList<Movie> favMovies) {
        this.favMovies = favMovies;
    }

    public ArrayList<TVShow> getFavTVShows() {
        return favTVShows;
    }

    public void setFavTVShows(ArrayList<TVShow> favTVShows) {
        this.favTVShows = favTVShows;
    }
    
    public void addFavTVShow(TVShow tvshow){
        this.favTVShows.add(tvshow);
    }

    public void addFavMovie(Movie movie){
        this.favMovies.add(movie);
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }    


    
    
    
    public User(String name, String city, String zip, String address, String password, String username) {
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.address = address;
        this.password = password;
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void removeFromFavTVShows(TVShow video) {
        this.favTVShows.remove(video);
    }

    public void removeFromFavMovies(Movie video) {
        this.favMovies.remove(video);
    }

    public ArrayList<Video> getAllFavourites() {
        ArrayList<Video> list = new ArrayList<>(favMovies);
        list.addAll(favTVShows);
        return list;
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }
}
