/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Listable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author adamg
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class VideoCharacter implements Listable {
    private int id;
    private String characterName;
    private String actorName;

    public VideoCharacter() {
    }

    public VideoCharacter(int id, String characterName, String actorName) {
        this.id = id;
        this.characterName = characterName;
        this.actorName = actorName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "VideoCharacter{" + "characterName=" + characterName + ", actorName=" + actorName + '}';
    }
    
    
    
}
