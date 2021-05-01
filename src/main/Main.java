package main;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import model.AppState;
import model.Movie;
import model.Movies;
import model.Review;
import model.Reviews;
import model.TVShow;
import model.TVShows;
import model.User;
import model.Users;
import view.SceneManager;
import xml_io_manager.XML_ReadWrite;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(event -> {
            AppState.debug("Primary stage close request.");
            serialize();
        });
        SceneManager.getInstance().setAppName("IMD-Beta");
        SceneManager.createApp(primaryStage, "mainPage", 1165, 720);
        AppState.debug("TEST");
    }

    private void serialize() {
        // uloz recenzie k filmom
        try{
            ArrayList<Review> recenzieFilmXML = new ArrayList<>();
            
            for (int i = 0; i < AppState.getInstance().getMovies().size(); i++) {
                Movie film = AppState.getInstance().getMovies().get(i);
                
                //zapamataj si recenzie filmu
                recenzieFilmXML.addAll(film.getReviews());
                
                // zmaz recenzie pri filme
                film.setReviews(new ArrayList<>());
            }
            
            // uloz data do suboru ak su nejake recenzie
            if(!recenzieFilmXML.isEmpty()){
                Reviews filmXML = new Reviews(recenzieFilmXML);
                XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPREVIEWS).write(System.getProperty("user.dir") + "\\data\\moviesreviews.xml", filmXML);
            }
            
        }catch (NullPointerException e) {
            AppState.error("Error while writing movies");
        }

        // uloz recenzie k serialom
        try{
            ArrayList<Review> recenzieSerialXML = new ArrayList<>();
            
            for (int i = 0; i < AppState.getInstance().getTvshows().size(); i++) {
                TVShow serial = AppState.getInstance().getTvshows().get(i);
                
                //zapamataj si recenzie filmu
                recenzieSerialXML.addAll(serial.getReviews());
                
                // zmaz recenzie pri filme
                serial.setReviews(new ArrayList<>());
            }
            
            // uloz data do suboru ak su nejake recenzie
            if(!recenzieSerialXML.isEmpty()){            
                Reviews serialXML = new Reviews(recenzieSerialXML);
                XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPREVIEWS).write(System.getProperty("user.dir") + "\\data\\tvshowsreviews.xml", serialXML);
            }
            
        }catch (NullPointerException e) {
            AppState.error("Error while writing movies");
        }
        
        // odstran recenzie usera
        for (int i = 0; i < AppState.getInstance().getUsers().size(); i++) {
            User user = AppState.getInstance().getUsers().get(i);
            user.setReviews(new ArrayList<>());
        }
        
        try {
            Movies moviesXML = new Movies(AppState.getInstance().getMovies());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPMOVIES).write(System.getProperty("user.dir") + "\\data\\movies.xml", moviesXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing movies");
        }
        try {
            TVShows tvShowsXML = new TVShows(AppState.getInstance().getTvshows());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPTVSHOWS).write(System.getProperty("user.dir") + "\\data\\tvshows.xml", tvShowsXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing TV shows");
        }
        try {
            Users usersXML = new Users(AppState.getInstance().getUsers());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPUSERS).write(System.getProperty("user.dir") + "\\data\\users.xml", usersXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing users");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}