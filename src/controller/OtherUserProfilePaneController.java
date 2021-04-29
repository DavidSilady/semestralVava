package controller;

import controller.abstracts.Controller;
import model.User;

public class OtherUserProfilePaneController  extends Controller {
    User previewUser;

    public void setUser(User user) {
        this.previewUser = user;
    }

    public void init() throws Exception {

    }
}
