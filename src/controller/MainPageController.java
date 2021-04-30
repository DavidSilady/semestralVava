package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AppState;
import model.User;
import model.Video;
import view.SceneManager;

public class MainPageController extends Controller {

    public Button myListsButton;
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
    void goToDaily(ActionEvent event) {
    }

    @FXML
    void goToHome(ActionEvent event) throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "homePane");
    }

    @FXML
    void searchGeneral(ActionEvent event) {
    }

    @FXML
    void goToProfile(ActionEvent event) throws Exception {
        if (AppState.getInstance().getActiveUser() != null) {
            SceneManager.switchDynamicPane(dynamicPane, "myProfilePane");
        }
    }

    public void init() throws Exception {
        if (AppState.getInstance().getActiveUser() == null) {
            logButton.setText("Log In");
            profileButton.setText("Anonymous");
            myListsButton.setVisible(false);
        }
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
}
