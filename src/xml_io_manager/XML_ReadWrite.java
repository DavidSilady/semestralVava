/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_io_manager;

/**
 *
 * @author adamg
 */
public class XML_ReadWrite {

    public static final int TYPMOVIES = 1;
    public static final int TYPTVSHOWS = 2;
    public static final int TYPUSERS = 3;
    public static final int TYPREVIEWS = 4;
    
    public XML_ReadWrite() {}
    
    public void initContext() {}
    
    public Object read(String cesta){ return new Object(); }
    
    public void write(String cesta, Object objekt){}
    
    public static XML_ReadWrite getXML_RW(int typCitacky){
        switch (typCitacky) {
            case TYPMOVIES:
                return new XML_ReadWrite_Movies();
                
            case TYPTVSHOWS:
                return new XML_ReadWrite_TVShows();
                
            case TYPUSERS:
                return new XML_ReadWrite_Users();
            
            case TYPREVIEWS:
                return new XML_ReadWrite_Reviews();
                
            default:
                return null;
        }
    }
}
