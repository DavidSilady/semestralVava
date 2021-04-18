package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.interfaces.Listable;
import view.SceneManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        recommendedPaneController.setParameters(370, 557);

        // TODO: get list from model and populate
    }

    private void setupMostViewedPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(mostViewedPane, "listingContainer");
        mostViewedPaneController = fxmlLoader.getController();
        mostViewedPaneController.setParameters(370, 557);

        // TODO: get list from model and populate
    }

    private void setupNewReleasesPane() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(newReleasesPane, "listingContainer");
        newReleasesPaneController = fxmlLoader.getController();
        newReleasesPaneController.setParameters(370, 557);

        // TODO: get list from model and populate
    }

    private void populateList(ListingContainerController controller, ArrayList<Listable> list, String listingName) throws Exception {
        controller.populate(list, listingName);
    }

    private void updateList(ListingContainerController controller, ArrayList<Listable> list) throws Exception {
        controller.updateListing(list);
    }

}
