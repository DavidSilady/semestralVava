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
import model.TVShows;

/**
 *
 * @author adamg
 */
public class XML_ReadWrite_TVShows extends XML_ReadWrite{
    private JAXBContext context;

    public XML_ReadWrite_TVShows() {}

    @Override
    public void initContext(){
        try {
            this.context = JAXBContext.newInstance(TVShows.class);
        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite_TVShows.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public TVShows read(String cesta) {
        try {

            initContext();

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
    
    @Override
    public void write(String cesta, Object serialy) {
        try {
            initContext();

            Marshaller marshaller = this.context.createMarshaller();

            File xmlF = new File(cesta);

            marshaller.marshal(serialy, xmlF);

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
