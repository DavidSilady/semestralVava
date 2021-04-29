package controller;

import controller.abstracts.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.User;
import model.Video;
import view.SceneManager;

import java.util.ArrayList;

public class OtherUserProfilePaneController  extends Controller {
    public AnchorPane favouritesPane;
    public AnchorPane reviewsPane;
    User previewUser;

    ListingContainerController favouritesPaneController;
    ListingContainerController reviewsPaneController;

    public void setUser(User user) {
        this.previewUser = user;
    }

    public void init() throws Exception {

    }

    private void setupFavouritesPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(favouritesPane, "listingContainer");
        favouritesPaneController = fxmlLoader.getController();

        favouritesPaneController.setParameters(370, 550);

        ArrayList<Video> list = new ArrayList<>(previewUser.getFavMovies());
        list.addAll(previewUser.getFavTVShows());
        favouritesPaneController.populate(new ArrayList<>(list), "videoListingSmall");
    }

    private void setupReviewsPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(reviewsPane, "listingContainer");
        reviewsPaneController = fxmlLoader.getController();

        reviewsPaneController.setParameters(720, 550);
        reviewsPaneController.populate(new ArrayList<>(previewUser.getReviews()), "reviewListing");
    }
}
