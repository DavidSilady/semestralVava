package controller.interfaces;
import model.interfaces.Listable;
import controller.ListingContainerController;

public interface ListablePaneController {
    void init(Listable listing, ListingContainerController parentContainer);
}
