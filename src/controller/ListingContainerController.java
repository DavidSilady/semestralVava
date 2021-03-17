package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class ListingContainerController extends Controller {

    @FXML
    private HBox scrollHBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane scrollPaneChild;

    @FXML
    private ArrayList<AnchorPane> listingPanes = new ArrayList<>();

    private ArrayList<Listable> listableArray = new ArrayList<>();

    private String itemTemplateName = "";

    public void populate(ArrayList<Listable> listableArray, String itemTemplateName) throws Exception {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.itemTemplateName = itemTemplateName;
        updateListing(listableArray);
    }

    public void setParameters(int width, int height) {
        rootPane.setPrefHeight(height);
        rootPane.setPrefWidth(width);
    }

    public ArrayList<Listable> getListableArray() {
        return listableArray;
    }

    public void updateListing(ArrayList<Listable> listableArray) throws Exception {
        this.listableArray = listableArray;
        // scrollPaneChild.getChildren().clear();
        scrollHBox.getChildren().clear();
        listingPanes.clear();
        int index = 0;
        for (Listable item : listableArray) {
            //System.out.print(index++ + " ");
            AnchorPane listingPane = new AnchorPane();

            FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(listingPane, itemTemplateName);
            ListablePaneController controller = fxmlLoader.getController();
            controller.init(item, this);
            listingPanes.add(listingPane);
        }

        VBox listingBox = new VBox(10);

        listingBox.maxHeight(2160);
        listingBox.getChildren().addAll(listingPanes);
        //System.out.print("\n" + listingPanes.size());
        //System.out.print("\n" + listingBox.getChildren().size());
        // scrollPaneChild.getChildren().add(listingBox);
        scrollHBox.getChildren().addAll(listingBox);
        listingBox.setAlignment(Pos.CENTER);
        scrollHBox.setAlignment(Pos.CENTER);
        scrollPane.setVvalue(0);
        //anchorPane.getChildren().add(listingBox);
    }
}
