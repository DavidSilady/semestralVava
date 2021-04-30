package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.AppState;
import model.User;
import view.SceneManager;

public class LoginPageController extends Controller {

    public Button continueButton;
    @FXML
    private TextField loginUsernameField;

    @FXML
    private TextField regUsernameField;

    @FXML
    private TextField regFullNameField;

    @FXML
    private TextField regAddressField;

    @FXML
    private TextField regCityField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private TextField regZipField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML Label regStatusLabel;

    public void init() { }

    @FXML
    void onLogin(ActionEvent event) throws Exception {
        if (AppState.getInstance().verifyLogin(
                loginUsernameField.getText(),
                loginPasswordField.getText()
        )) {
            AppState.debug("Logged in.");
            SceneManager.switchScene(event, "mainPage");
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    void onRegister(ActionEvent event) throws Exception {
        if (validRegisterInput()) {
            User user = new User(
                    regFullNameField.getText(),
                    regCityField.getText(),
                    regZipField.getText(),
                    regAddressField.getText(),
                    regPasswordField.getText(),
                    regUsernameField.getText()
            );
            if (AppState.getInstance().registerCustomer(user)) {
                regStatusLabel.setText("Registration complete.");
            } else {
                regStatusLabel.setText("Username already taken. Choose a different username.");
            }
            AppState.debug("User registered.");
        } else {
            SceneManager.newPopUp("Invalid input", "All registration fields must be filled in");
        }

    }

    public void continueWithoutLogin(ActionEvent event) throws Exception {
        SceneManager.switchScene(event, "mainPage");
    }

    private boolean validRegisterInput() {
        return  !regFullNameField.getText().isEmpty() &&
                !regCityField.getText().isEmpty() &&
                !regZipField.getText().isEmpty() &&
                !regAddressField.getText().isEmpty() &&
                !regPasswordField.getText().isEmpty() &&
                !regUsernameField.getText().isEmpty();
    }
}

