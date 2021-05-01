/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_io_manager;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Movies;

/**
 *
 * @author adamg
 */
public class XML_ReadWrite_Movies extends XML_ReadWrite{
    private JAXBContext context;

    public XML_ReadWrite_Movies() {}

    @Override
    public void initContext(){
        try {
            this.context = JAXBContext.newInstance(Movies.class);
        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite_Movies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Movies read(String cesta) {
        try {

            initContext();

            Unmarshaller unmarshaller = this.context.createUnmarshaller();

            File xmlF = new File(cesta);

            Movies filmy = (Movies) unmarshaller.unmarshal(xmlF);

            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(filmy, System.out);
            
            return filmy;

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void write(String cesta, Object filmy) {
        try {
            initContext();

            Marshaller marshaller = this.context.createMarshaller();

            File xmlF = new File(cesta);

            marshaller.marshal(filmy, xmlF);

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
