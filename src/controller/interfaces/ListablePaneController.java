package controller.interfaces;
import model.interfaces.Listable;
import controller.ListingContainerController;

public interface ListablePaneController {
    void fillData(Listable listing, ListingContainerController parentContainer);
}
