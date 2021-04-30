package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PopUpController extends Controller {
    public Text titleText;
    public Text popUpText;
    public Button okButton;

    public void setProperties(String title, String text) {
        titleText.setText(title);
        popUpText.setText(text);
    }

    public void exit(ActionEvent event) {
        ((Stage) okButton.getScene().getWindow()).close();
    }
}
