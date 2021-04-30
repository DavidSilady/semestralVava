package controller;

import controller.abstracts.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.AppState;
import model.User;
import model.Video;
import view.SceneManager;

import java.util.ArrayList;

public class UserListsPaneController extends Controller {
    public AnchorPane favouritesPane;
    public AnchorPane reviewsPane;
    public Label userNameHeaderLabel;
    User user;

    ListingContainerController favouritesPaneController;
    ListingContainerController reviewsPaneController;

    public void setUser(User user) throws Exception {
        this.user = user;
        userNameHeaderLabel.setText(user.getUsername() + "'s lists");
        setupFavouritesPane();
        setupReviewsPane();
    }

    public void init() throws Exception { }

    private void setupFavouritesPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(favouritesPane, "listingContainer");
        favouritesPaneController = fxmlLoader.getController();

        favouritesPaneController.setParameters(370, 550);

        ArrayList<Video> list = new ArrayList<>(user.getFavMovies());
        list.addAll(user.getFavTVShows());

        String itemTemplateName = "videoListingSmall";
        if (AppState.userLoggedIn()) {
            itemTemplateName = "videoListingSmallDeletable";
        }
        favouritesPaneController.populate(new ArrayList<>(list), itemTemplateName);
    }

    private void setupReviewsPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(reviewsPane, "listingContainer");
        reviewsPaneController = fxmlLoader.getController();

        reviewsPaneController.setParameters(720, 550);
        String itemTemplateName = "reviewListing";
        if (AppState.userLoggedIn()) {
            itemTemplateName = "reviewListingDeletable";
        }
        reviewsPaneController.populate(new ArrayList<>(user.getReviews()), itemTemplateName);
    }
}
