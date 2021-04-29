package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.AppState;
import model.Review;
import model.Video;
import view.SceneManager;

import java.util.ArrayList;
import java.util.Locale;

public class VideoDetailController extends Controller {

    public TextField titleField;
    @FXML
    private Label titleLabel;

    @FXML
    private Text typeText;

    @FXML
    private Text yearText;

    @FXML
    private Text lengthText;

    @FXML
    private Text studioText;

    @FXML
    private Text ratingText;

    @FXML
    private Text directorText;

    @FXML
    private Text curiosityText;

    @FXML
    private AnchorPane charactersPane;

    @FXML
    private Label recommendedLabel;

    @FXML
    private AnchorPane reviewsPane;

    @FXML
    private Label recommendedLabel1;

    @FXML
    private TextArea newReviewTextArea;

    @FXML
    private Button addReviewButton;

    @FXML
    private Slider reviewRatingSlider;

    private Video video;

    ListingContainerController reviewsContainerController;

    @FXML
    void addReview(ActionEvent event) throws Exception {
        Review review = new Review(
                AppState.getInstance().getActiveUser().getUsername(),
                titleField.getText(),
                newReviewTextArea.getText(),
                (byte) Math.floor(reviewRatingSlider.getValue() * 10)
        );
        video.addReview(review);
        reviewsContainerController.updateListing(new ArrayList<>(video.getReviews()));
    }

    public void setVideo(Video video) throws Exception {
        this.video = video;
        setupLabels();
    }

    private void setupLabels() throws Exception {
        titleLabel.setText(video.getTitle());
        typeText.setText(video.getGenre().toUpperCase() + " " + video.getType());
        yearText.setText(video.getYear() + "");
        lengthText.setText(video.getLength() + " minutes");
        studioText.setText(video.getStudio());
        ratingText.setText(video.getAvgRating() / 10 + "*");
        directorText.setText(video.getDirector());
        curiosityText.setText(video.getCuriosity());

        setupReviews();
    }

    private void setupReviews() throws Exception{
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(reviewsPane, "listingContainer");
        reviewsContainerController = fxmlLoader.getController();

        reviewsContainerController.setParameters(720, 190);

        reviewsContainerController.populate(new ArrayList<>(video.getReviews()), "review");
    }

}
