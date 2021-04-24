package controller;

import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.AppState;
import model.interfaces.Listable;

public class VideoListingSmallController extends VideoListingController implements ListablePaneController {


    @FXML
    private ImageView image;

    @FXML
    private Text titleText;

    @FXML
    private Label videoTypeLabel;

    @FXML
    void onClick(MouseEvent event) {
        AppState.debug("Clicked on video link");
    }

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
    }


}
