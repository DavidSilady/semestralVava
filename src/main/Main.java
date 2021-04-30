package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.AppState;
import model.Movies;
import model.TVShows;
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
        try {
            Movies moviesXML = new Movies(AppState.getInstance().getMovies());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPMOVIES).write("src\\data\\movies.xml", moviesXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing movies");
        }
        try {
            TVShows tvShowsXML = new TVShows(AppState.getInstance().getTvshows());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPTVSHOWS).write("src\\data\\tvshows.xml", tvShowsXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing TV shows");
        }
        try {
            Users usersXML = new Users(AppState.getInstance().getUsers());
            XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPUSERS).write("src\\data\\users.xml", usersXML);
        } catch (NullPointerException e) {
            AppState.error("Error while writing users");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}