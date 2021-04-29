package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Video;

import java.util.Locale;

public class VideoDetailController extends Controller {

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

    @FXML
    void addReview(ActionEvent event) {

    }

    public void setVideo(Video video) {
        this.video = video;
        setupLabels();
    }

    private void setupLabels() {
        titleLabel.setText(video.getTitle());
        typeText.setText(video.getGenre().toUpperCase() + " " + video.getType());
        yearText.setText(video.getYear() + "");
        lengthText.setText(video.getLength() + " minutes");
        studioText.setText(video.getStudio());
        ratingText.setText(video.getAvgRating() / 10 + "*");
        directorText.setText(video.getDirector());
        curiosityText.setText(video.getCuriosity());
    }

}
