/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adamg
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    
    @XmlElement(name = "user")
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public Users(ArrayList<User> users) {
        this.users = users;
    }

    public Users() {
    }
    
    @Override
    public String toString() {
        return "Users{" + "users=" + users + '}';
    }
    
    
}
