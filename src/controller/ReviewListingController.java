package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.AppState;
import model.Review;
import model.User;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class ReviewListingController extends Controller implements ListablePaneController {
    public Text usernameText;
    public Text reviewText;
    public Label ratingLabel;
    public Label titleLabel;
    public Button deleteButton;
    public Label movieNameLabel;
    public AnchorPane headerPane;

    private Review review;
    ListingContainerController parentController;

    public void onUsernameClicked(MouseEvent event) throws Exception {
        if (review.getUser() != null) {
            FXMLLoader fxmlLoader = SceneManager.switchScene(event, "mainPage");
            MainPageController mainPageController = fxmlLoader.getController();
            mainPageController.redirectToProfilePane(review.getUser());
        }
    }

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.review = (Review) listing;
        this.parentController = parentContainer;

        usernameText.setText(review.getUsername());
        reviewText.setText(review.getCommentary());
        ratingLabel.setText(review.getScore() / 10 + "");
        titleLabel.setText(review.getTitle());

        movieNameLabel.setText(review.getVideo().getTitle());
    }

    public void deleteReview(ActionEvent event) throws Exception {
        User activeUser = AppState.getInstance().getActiveUser();
        review.getVideo().removeReview(review);
        activeUser.removeReview(review);

        parentController.updateListing(new ArrayList<>(activeUser.getReviews()));
    }

    public void clickOnUsername(Event event) throws Exception {
        if (review.getUser() != null) {
            FXMLLoader fxmlLoader = SceneManager.switchScene(event, "mainPage");
            MainPageController mainPageController = fxmlLoader.getController();
            mainPageController.redirectToProfilePane(review.getUser());
        }
    }

    public void clickOnVideoTitle(Event event) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchScene(event, "mainPage");
        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.redirectToVideoPane(review.getVideo());
    }

    public void onHeaderClicked(MouseEvent mouseEvent) throws Exception {
    }
}
