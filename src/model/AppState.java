package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import sun.rmi.runtime.Log;
import xml_io_manager.XML_ReadWrite;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        //this.users = new ArrayList<>();
        Users usrs = (Users) XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPUSERS).read("src\\data\\users.xml");
        Movies mvs = (Movies) XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPMOVIES).read("src\\data\\movies.xml");
        TVShows tvs = (TVShows) XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPTVSHOWS).read("src\\data\\tvshows.xml");
        this.users = usrs.getUsers();
        this.movies = mvs.getFilmy();
        this.tvshows = tvs.getSerialy();
    };

    private ArrayList<User> users;
    private ArrayList<Movie> movies;
    private ArrayList<TVShow> tvshows;

    private User activeUser = null;

    public static void debug(String output) {
        if (DEBUG) {
            Logger.getLogger(AppState.class.getName()).log(Level.INFO, "Debug: " + output);
        }
    }

    public static void pushNotification(String tooltip, String title, String text) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, tooltip);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip(tooltip);
        tray.add(trayIcon);
        trayIcon.displayMessage(title, text, TrayIcon.MessageType.INFO);
    }

    public static void error(String error) {
        Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, "Error: " + error);
    }

    public ArrayList<Video> getVideos() {
        ArrayList<Video> connectedList = new ArrayList<>(movies);
        connectedList.addAll(tvshows);
        return connectedList;
    }

    public static boolean userLoggedIn() {
        return instance.getActiveUser() != null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<TVShow> getTvshows() {
        return tvshows;
    }

    public void setTvshows(ArrayList<TVShow> tvshows) {
        this.tvshows = tvshows;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public ArrayList<User> getCustomers() {
        return users;
    }

    public void setCustomers(ArrayList<User> users) {
        this.users = users;
    }

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    private void addCustomer(User user) {
        this.users.add(user);
    }

    public Boolean registerCustomer(User newUser) {
        for (User user : this.users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                return false;
            }
        }
        addCustomer(newUser);
        return true;
    }

    public Boolean verifyLogin(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.activeUser = user;
                return true;
            }
        }
        return false;
    }
}
