package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import view.SceneManager;

public class MainPageController extends Controller {

    @FXML
    private Button profileButton;

    @FXML
    private Button productsButton;

    @FXML
    private Button invoicesButton;

    @FXML
    private AnchorPane dynamicPane;


    @FXML
    void goToProfile(ActionEvent event) throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "profilePane");
    }

    public void init() throws Exception {
        SceneManager.switchDynamicPane(dynamicPane, "profilePane");
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
        SceneManager.switchScene(event, "loginPage");
    }
}
