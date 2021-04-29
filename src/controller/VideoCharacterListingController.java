package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import model.VideoCharacter;
import model.interfaces.Listable;

public class VideoCharacterListingController extends Controller implements ListablePaneController {
    public Text characterNameText;
    public Label actorNameLabel;
    public Label dynamicSortInfoLabel;

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        VideoCharacter videoCharacter = (VideoCharacter) listing;

        characterNameText.setText(videoCharacter.getCharacterName());
        actorNameLabel.setText(videoCharacter.getActorName());
    }
}
