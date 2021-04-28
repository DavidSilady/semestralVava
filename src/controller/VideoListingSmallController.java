package controller;

import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.AppState;
import model.Video;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.Locale;

public class VideoListingSmallController extends VideoListingController implements ListablePaneController {


    @FXML
    private ImageView image;

    @FXML
    private Text titleText;

    @FXML
    private Label videoTypeLabel;

    ListingContainerController parentContainer;

    Video video;

    @FXML
    void onClick(MouseEvent event) throws Exception {
        AppState.debug("Clicked on video link");
        FXMLLoader fxmlLoader = SceneManager.switchScene(event, "mainPage");
        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.redirectToVideoPane();
    }

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.video = (Video) listing;
        this.parentContainer = parentContainer;

        titleText.setText(video.getTitle());
        videoTypeLabel.setText(video.getGenre().toUpperCase() + " " + video.getType().toUpperCase());
    }
}
