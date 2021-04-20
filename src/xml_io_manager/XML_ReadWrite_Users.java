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
import model.Users;

/**
 *
 * @author adamg
 */
public class XML_ReadWrite_Users extends XML_ReadWrite{
    private JAXBContext context;

    public XML_ReadWrite_Users() {}
    
    @Override
    public void initContext(){
        try {
            this.context = JAXBContext.newInstance(Users.class);
        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Users read(String cesta) {
        try {

            initContext();

            Unmarshaller unmarshaller = this.context.createUnmarshaller();

            File xmlF = new File(cesta);

            Users pouzivatelia = (Users) unmarshaller.unmarshal(xmlF);

            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(pouzivatelia, System.out);
            
            return pouzivatelia;

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return null;
        }
    }
    
    @Override
    public void write(String cesta, Object pouzivatelia) {
        try {
            initContext();

            Marshaller marshaller = this.context.createMarshaller();

            File xmlF = new File(cesta);

            marshaller.marshal(pouzivatelia, xmlF);

        } catch (JAXBException ex) {
            Logger.getLogger(XML_ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
