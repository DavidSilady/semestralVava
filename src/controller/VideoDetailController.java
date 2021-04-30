package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.*;
import model.interfaces.Listable;
import view.SceneManager;

import javax.jws.soap.SOAPBinding;
import java.awt.*;
import java.util.ArrayList;

public class VideoDetailController extends Controller {

    public TextField titleField;
    public Label episodesLabel;
    public Button displaySpecificDetailsButton;
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
    ListingContainerController charactersContainerController;

    @FXML
    void addReview(ActionEvent event) throws Exception {
        if (validInput()) {
            String username = "Anonymous"; //Default
            if (AppState.getInstance().getActiveUser() != null) {
                username = AppState.getInstance().getActiveUser().getUsername();
            }
            Review review = new Review(
                    username,
                    titleField.getText(),
                    newReviewTextArea.getText(),
                    (byte) Math.floor(reviewRatingSlider.getValue() * 10)
            );
            review.setUser(AppState.getInstance().getActiveUser());
            review.setVideo(video);

            if (AppState.getInstance().getActiveUser() != null) {
                AppState.getInstance().getActiveUser().addReview(review);
            }

            video.addReview(review);
            reviewsContainerController.updateListing(new ArrayList<>(video.getReviews()));
            ratingText.setText((float) video.getAvgRating() / 10 + "*");
        } else {
            SceneManager.newPopUp("Invalid input", "Either title or commentary are missing");
        }
    }

    private boolean validInput() {
        return true;
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

        if (video instanceof TVShow) {
            displaySpecificDetailsButton.setVisible(false);
            TVShow tvShow = (TVShow) video;
            episodesLabel.setText("Episodes: " + tvShow.getEpisodeCount() + " Seasons: " + tvShow.getSeasonCount());
        } else {
            episodesLabel.setVisible(false);
        }

        setupReviews();
        setupCharacters();
    }

    private void setupReviews() throws Exception{
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(reviewsPane, "listingContainer");
        reviewsContainerController = fxmlLoader.getController();

        reviewsContainerController.setParameters(720, 190);

        reviewsContainerController.populate(new ArrayList<>(video.getReviews()), "reviewListing");
    }

    private void setupCharacters() throws Exception{
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(charactersPane, "listingContainer");
        charactersContainerController = fxmlLoader.getController();

        charactersContainerController.setParameters(370, 550);

        charactersContainerController.populate(new ArrayList<>(video.getCharacters()), "videoCharacterListing");
    }

    public void addToFavourites(ActionEvent event) throws Exception {
        User activeUser = AppState.getInstance().getActiveUser();
        // If not logged in or already in favourites, skip
        if (activeUser == null ) {
            SceneManager.newPopUp("Not logged in", "You need to be logged in, in order to add to favourites");
            return;
        }
        if (activeUser.getAllFavourites().contains(video)) {
            SceneManager.newPopUp("Already added", "This content has already been in your list");
            return;
        }

        if (video instanceof Movie) {
            activeUser.addFavMovie((Movie) video);
            AppState.pushNotification("Notification Demo", "Movie added", "Movie " + video.getTitle() + " has been added to favourites.");
        } else if (video instanceof TVShow) {
            activeUser.addFavTVShow((TVShow) video);
            AppState.pushNotification("Notification Demo", "TV show added", "TV show " + video.getTitle() + " has been added to favourites.");
        }
    }

    public void displaySpecificDetails(ActionEvent event) throws Exception {
        if (video instanceof Movie) {
            displayMovieSpecifics();
        } else if (video instanceof TVShow) {
            displayTVShowSpecifics();
        }
    }

    private void displayMovieSpecifics() throws Exception {
        Movie movie = (Movie) video;
        FXMLLoader fxmlLoader = SceneManager.newWindow("listingContainer", 370, 250);
        ListingContainerController controller = fxmlLoader.getController();
        ArrayList<Listable> list = new ArrayList<>();
        for (Video video : AppState.getInstance().getVideos()) {
            for (int index : movie.getRelatedIndeces()) {
                if (video.getId() == index) {
                    list.add(video);
                    break;
                }
            }
        }
        AppState.debug(movie.getRelatedIndeces().size() + "");
        controller.setParameters(370, 250);
        controller.populate(list, "videoListingSmall");
    }

    private void displayTVShowSpecifics() {
    }
}
