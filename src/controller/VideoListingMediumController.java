package controller;

import controller.abstracts.Controller;
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

public class VideoListingMediumController extends Controller implements ListablePaneController {
    public Text curiosityText;
    public Label lengthLabel;
    public Label directorLabel;
    @FXML
    private ImageView image;

    @FXML
    private Text titleText;

    @FXML
    private Label videoTypeLabel;

    @FXML
    private Label dynamicSortInfoLabel;

    ListingContainerController parentContainer;

    Video video;

    @FXML
    void onClick(MouseEvent event) throws Exception {
        AppState.debug("Clicked on video link");
        FXMLLoader fxmlLoader = SceneManager.switchScene(event, "mainPage");
        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.redirectToVideoPane(video);
    }

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.video = (Video) listing;
        this.parentContainer = parentContainer;

        titleText.setText(video.getTitle());
        videoTypeLabel.setText(video.getGenre().toUpperCase() + " " + video.getType().toUpperCase());
        dynamicSortInfoLabel.setText(video.getRelevantSortInfo());

        curiosityText.setText(video.getCuriosity());
        directorLabel.setText(video.getDirector());
        lengthLabel.setText(Short.toString(video.getLength()));
    }
}
