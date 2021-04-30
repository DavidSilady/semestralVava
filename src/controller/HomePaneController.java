package controller;

import controller.abstracts.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.AppState;
import model.Video;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomePaneController extends Controller {

    @FXML
    private AnchorPane newReleasesPane;

    @FXML
    private AnchorPane mostViewedPane;

    @FXML
    private AnchorPane recommendedPane;

    @FXML
    private Label newReleasesLabel;

    @FXML
    private Label mostViewedLabel;

    @FXML
    private Label recommendedLabel;

    ListingContainerController newReleasesPaneController;
    ListingContainerController recommendedPaneController;
    ListingContainerController mostViewedPaneController;

    public void init() throws Exception {
        setupMostViewedPane();
        setupNewReleasesPane();
        setupRecommendedPane();
    }

    private void setupRecommendedPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(recommendedPane, "listingContainer");
        recommendedPaneController = fxmlLoader.getController();
        recommendedPaneController.setParameters(370, 240);

        // TODO: get list from model and populate
        ArrayList<Video> list = new ArrayList<>(AppState.getInstance().getVideos());
        list = ContentFilter.sortByRatings(list, 10);
        populateList(recommendedPaneController, new ArrayList<>(list), "videoListingSmall");
    }

    private void setupMostViewedPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(mostViewedPane, "listingContainer");
        mostViewedPaneController = fxmlLoader.getController();
        mostViewedPaneController.setParameters(370, 240);

        // TODO: get list from model and populate
        ArrayList<Video> list = new ArrayList<>(AppState.getInstance().getVideos());
        list = ContentFilter.sortByPopularity(list, 10);
        populateList(mostViewedPaneController, new ArrayList<>(list), "videoListingSmall");
    }

    private void setupNewReleasesPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(newReleasesPane, "listingContainer");
        newReleasesPaneController = fxmlLoader.getController();
        newReleasesPaneController.setParameters(760, 557);

        // TODO: get list from model and populate
        ArrayList<Video> list = new ArrayList<>(AppState.getInstance().getVideos());
        list = ContentFilter.sortByYear(list, 10);
        populateList(newReleasesPaneController, new ArrayList<>(list), "videoListingMedium");
    }

    private void populateList(ListingContainerController controller, ArrayList<Listable> list, String listingName) throws Exception {
        controller.populate(list, listingName);
    }

    private void updateList(ListingContainerController controller, ArrayList<Listable> list) throws Exception {
        controller.updateListing(list);
    }

    public void setSearchResults(ArrayList<Video> results) throws Exception {
        newReleasesPaneController.updateListing(new ArrayList<>(results));
        Locale locale = SceneManager.getInstance().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.Language", locale);
        newReleasesLabel.setText(bundle.getString("searchResults"));
    }

}
