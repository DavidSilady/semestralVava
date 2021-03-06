package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;
import model.AppState;
import model.User;
import model.Video;
import view.SceneManager;

import java.net.URL;
import java.util.*;

public class MainPageController extends Controller implements Initializable {

    public Button myListsButton;
    public Button localeButton;
    @FXML
    private AnchorPane dynamicPane;

    @FXML
    private Button logButton;

    @FXML
    private Button profileButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    void goToCharts(ActionEvent event) {
    }

    @FXML
    void goToDaily(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "homePane");
        HomePaneController homePaneController = fxmlLoader.getController();
        ArrayList<Video> list = new ArrayList<>(AppState.getInstance().getVideos());
        Collections.shuffle(list);
        homePaneController.setDaily(list.subList(0, 10));
    }

    @FXML
    void goToHome(ActionEvent event) throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "homePane");
    }

    @FXML
    void searchGeneral(ActionEvent event) throws Exception {
        ArrayList<Video> finalResults = new ArrayList<>();
        try {
            ArrayList<Video> list = AppState.getInstance().getVideos();
            List<BoundExtractedResult<Video>> results = FuzzySearch.extractTop(searchField.getText(), list, Video::toString, 20);

            for (BoundExtractedResult<Video> result : results) {
                finalResults.add(result.getReferent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "homePane");
            HomePaneController homePaneController = fxmlLoader.getController();
            homePaneController.setSearchResults(finalResults);
        }
    }

    @FXML
    void goToProfile(ActionEvent event) throws Exception {
        if (AppState.getInstance().getActiveUser() != null) {
            SceneManager.switchDynamicPane(dynamicPane, "myProfilePane");
        }
    }

    public void init() throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "homePane");
    }

    public void redirectToVideoPane(Video video) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "videoDetail");
        VideoDetailController videoDetailController = fxmlLoader.getController();
        videoDetailController.setVideo(video);
    }

    public void redirectToProfilePane(User user) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "otherUserProfilePane");
        UserListsPaneController videoDetailController = fxmlLoader.getController();
        videoDetailController.setUser(user);
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
        AppState.getInstance().setActiveUser(null);
        SceneManager.switchScene(event, "loginPage");
    }

    public void goToMyLists(ActionEvent event) throws Exception {
        redirectToProfilePane(AppState.getInstance().getActiveUser());
    }

    // Internationalization

    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
        if (AppState.getInstance().getActiveUser() == null) {
            logButton.setText(bundle.getString("logIn"));
            profileButton.setText(bundle.getString("anonymous"));
            myListsButton.setVisible(false);
        }
    }

    public void changeLocale(ActionEvent event) throws Exception {
        SceneManager.changeLocale(
            new Locale(bundle.getString("alternativeLanguage"), bundle.getString("alternativeCountry"))
        );
        SceneManager.switchScene(event, "mainPage");
    }
}
