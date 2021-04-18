package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import view.SceneManager;

public class MainPageController extends Controller {

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
        SceneManager.switchDynamicPane(dynamicPane, "profilePane");
    }

    public void init() throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "homePane");
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
        SceneManager.switchScene(event, "loginPage");
    }
}
