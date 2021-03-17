package model;

import java.util.ArrayList;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        this.users = new ArrayList<>();
    };

    private ArrayList<User> users;

    private User activeUser;

    public static void debug(String output) {
        if (DEBUG) {
            System.out.println(output);
        }
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public ArrayList<User> getCustomers() {
        return users;
    }

    public void setCustomers(ArrayList<User> users) {
        this.users = users;
    }

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    private void addCustomer(User user) {
        this.users.add(user);
    }

    public Boolean registerCustomer(User newUser) {
        for (User user : this.users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                return false;
            }
        }
        addCustomer(newUser);
        return true;
    }

    public Boolean verifyLogin(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.activeUser = user;
                return true;
            }
        }
        return false;
    }
}
