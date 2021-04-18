/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_io_manager;

import model.Movies;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.TVShows;

/**
 *
 * @author adamg
 */
public class XML_ReadWrite {

    private JAXBContext context;

    public void initContextMovie() throws JAXBException {
        this.context = JAXBContext.newInstance(Movies.class);
    }

    public void initContextTVShow() throws JAXBException {
        this.context = JAXBContext.newInstance(TVShows.class);
    }
    
    public Movies readingMovies(String cesta) {
        try {

            initContextMovie();

            Unmarshaller unmarshaller = this.context.createUnmarshaller();

            File xmlF = new File(cesta);

            Movies filmy = (Movies) unmarshaller.unmarshal(xmlF);

            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(filmy, System.out);
            
            return filmy;

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return null;
        }
    }
    
    public TVShows readingTVshows(String cesta) {
        try {

            initContextTVShow();

            Unmarshaller unmarshaller = this.context.createUnmarshaller();

            File xmlF = new File(cesta);

            TVShows serialy = (TVShows) unmarshaller.unmarshal(xmlF);

            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(serialy, System.out);
            
            return serialy;

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return null;
        }
    }

    public void writingMovie(String cesta, Movies filmy) {
        try {
            initContextMovie();

            Marshaller marshaller = this.context.createMarshaller();

            File xmlF = new File(cesta);

            marshaller.marshal(filmy, xmlF);

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writingTVshow(String cesta, TVShows serialy) {
        try {
            initContextTVShow();

            Marshaller marshaller = this.context.createMarshaller();

            File xmlF = new File(cesta);

            marshaller.marshal(serialy, xmlF);

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
