package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Review;
import model.interfaces.Listable;
import view.SceneManager;

public class ReviewController extends Controller implements ListablePaneController {
    public Text usernameText;
    public Text reviewText;
    public Label ratingLabel;
    public Label titleLabel;

    private Review review;
    ListingContainerController parentController;

    public void onUsernameClicked(MouseEvent mouseEvent) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchScene(mouseEvent, "mainPage");
        MainPageController mainPageController = fxmlLoader.getController();
    }

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.review = (Review) listing;
        this.parentController = parentContainer;

        usernameText.setText(review.getUsername());
        reviewText.setText(review.getCommentary());
        ratingLabel.setText(review.getScore() / 10 + "");
        titleLabel.setText(review.getTitle());
    }
}
