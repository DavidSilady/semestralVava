package view;

import controller.PopUpController;
import controller.abstracts.Controller;
import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.User;

import java.util.Locale;
import java.util.ResourceBundle;

public class SceneManager {
    private String appName = "";
    private User user;
    private static SceneManager instance = null;

    private SceneManager() { }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Locale locale = new Locale("sk", "SK");

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public static FXMLLoader createApp(Stage primaryStage, String templateName, int width, int height) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(SceneManager.class.getResource("/view/template/" + templateName + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle(getInstance().appName);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static FXMLLoader switchScene (Event actionEvent, String sceneName) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(SceneManager.class.getResource("/view/template/" + sceneName + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        Parent root = fxmlLoader.load();
        Scene fxmlScene = new Scene(root);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(fxmlScene);
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static FXMLLoader switchDynamicPane (Pane dynamicPane, String name) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource("/view/template/" + name + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        Pane pane = (Pane) fxmlLoader.load();
        try {
            dynamicPane.getChildren().clear();
            dynamicPane.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static FXMLLoader switchWindow (Event actionEvent, String sceneName, int width, int height) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource("/view/template/" + sceneName + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(getInstance().appName + " | " + sceneName);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static FXMLLoader newWindow(String sceneName, int width, int height, boolean undecorated) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource("/view/template/" + sceneName + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle(getInstance().appName + " | " + sceneName);
        Scene scene = new Scene(root, width, height);
        if (undecorated) {
            stage.initStyle(StageStyle.UNDECORATED);
            scene.setFill(Color.TRANSPARENT); // Fill our scene with nothing
            stage.initStyle(StageStyle.TRANSPARENT); // Important one!
        }
        stage.setScene(scene);
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static FXMLLoader newWindow(String sceneName, int width, int height) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource("/view/template/" + sceneName + ".fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Language", instance.getLocale()));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(getInstance().appName + " | " + sceneName);
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.init();
        return fxmlLoader;
    }

    public static void changeLocale(Locale locale) {
        instance.setLocale(locale);
    }

    public static FXMLLoader newPopUp(String title, String text) throws Exception {
        FXMLLoader fxmlLoader = newWindow("popUpGeneric", 370, 120);
        PopUpController popUpController = fxmlLoader.getController();
        popUpController.setProperties(title, text);
        return fxmlLoader;
    }
}