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
public class Rating {

    private byte imdb;
    private byte csfd;
    private byte ours;

    public byte getImdb() {
        return imdb;
    }

    public void setImdb(byte imdb) {
        this.imdb = imdb;
    }

    public byte getCsfd() {
        return csfd;
    }

    public void setCsfd(byte csfd) {
        this.csfd = csfd;
    }

    public byte getOurs() {
        return ours;
    }

    public void setOurs(byte ours) {
        this.ours = ours;
    }

    public Rating(byte imdb, byte csfd, byte ours) {
        this.imdb = imdb;
        this.csfd = csfd;
        this.ours = ours;
    }

    public Rating() {
    }

    @Override
    public String toString() {
        return "Rating{" + "imdb=" + imdb + ", csfd=" + csfd + ", ours=" + ours + '}';
    }

}
