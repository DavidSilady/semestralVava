/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author adamg
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class VideoCharacter {
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

    @Override
    public String toString() {
        return "VideoCharacter{" + "characterName=" + characterName + ", actorName=" + actorName + '}';
    }
    
    
    
}
