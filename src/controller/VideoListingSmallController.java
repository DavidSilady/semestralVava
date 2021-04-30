package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.*;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;
import java.util.Locale;

public class VideoListingSmallController extends Controller implements ListablePaneController {
    public Button removeButton;
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
    }

    public void removeFromFavourites(ActionEvent event) throws Exception {
        User activeUser = AppState.getInstance().getActiveUser();
        if (video instanceof TVShow) {
            activeUser.removeFromFavTVShows((TVShow) video);
        } else if (video instanceof Movie) {
            activeUser.removeFromFavMovies((Movie) video);
        }
        parentContainer.updateListing(new ArrayList<>(AppState.getInstance().getActiveUser().getAllFavourites()));
    }
}
