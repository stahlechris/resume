//***************************************************************************
//	File:                       MusicArtistsApp.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 4
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        November 22, 2016
//
//      Description:                This program reads an XML file to display
//                                  a list of artists and listings.
//***************************************************************************
package xml_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
//import javax.xml.stream.XMLStreamWriter;

public final class ArtistXMLFile implements ArtistDAO {

    private ArrayList<Artist> artists = null;
    private Path artistsPath = null;
    private File artistsFile = null;

    private final String FIELD_SEP = "\t";

    public ArtistXMLFile() {
        artistsPath = Paths.get("src/xml_assignment/music_artists.xml");
        artistsFile = artistsPath.toFile();
        artists = this.getArtists(); //constructor initializes file
    }

    public ArrayList<Artist> getArtists() {
        if (artists != null) {
            return artists;
        }

        artists = new ArrayList<>();
        Artist a = null;
        if (Files.exists(artistsPath)) {
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try {
                FileReader fileReader = new FileReader(artistsPath.toFile());
                XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
                int i = 0;
                String currentArtist = "";
                boolean alreadyDone = false;
                boolean isReset = false;
                boolean isFirstTime = true;
                
                while (reader.hasNext()) {
                    int eventType = reader.getEventType();
                    switch (eventType) {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Artist")) {
                                a = new Artist();
                                String code = reader.getAttributeValue(0);
                                a.setCode(code);
                                if (!alreadyDone) //only execute once
                                {
                                    currentArtist = a.getCode(); 
                                    alreadyDone = true;
                                }
                            }
                            if (elementName.equals("Name")) {
                                String name = reader.getElementText();
                                a.setName(name);
                            }
                            if (elementName.equals("Album")) {
                                String album = reader.getElementText(); 
                                if (!currentArtist.equals(a.getCode())) 
                                {
                                    currentArtist = a.getCode(); 
                                    i = 0;
                                    isReset = true; //resets after first Artist initialized
                                    i++; 
                                }
                                if ( !isReset ) 
                                {
                                    i++;
                                }
                                a.setAlbum(i, album); 
                                isReset = false; //must reset this after new Artist
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Artist")) {
                                artists.add(a);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
            } catch (XMLStreamException e) {
                System.out.println(e);
                return null;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArtistXMLFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return artists;
    }
}//end all 
    
    
        
    //Maybe you'll ask for this on the next assignment?
/*
    public Artist getArtist(String code) {
        for (Artist a : artists) {
            if (a.getCode().equals(code)) {
                return a;
            }
        }
        return null;
    }


    public boolean addArtist(Artist a) {
        artists.add(a);
        return this.saveArtists();
    }

    public boolean deleteArtist(Artist a) {
        artists.remove(a);
        return this.saveArtists();
    }

    public boolean updateArtist(Artist newArtist) {
        Artist oldArtist = this.getArtist(newArtist.getCode());
        int i = artists.indexOf(oldArtist);
        artists.remove(i);
        artists.add(i, newArtist);

        return this.saveArtists();
    }

    
    private boolean saveArtists() {
        // create the XMLOutputFactory object
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        try {
            // create XMLStreamWriter object
            FileWriter fileWriter = new FileWriter(artistsPath.toFile());
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);

            //write the artists to the file
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Artists");
            for (Artist a : artists) {
                writer.writeStartElement("Artist");
                writer.writeAttribute("Code", a.getCode());
                writer.writeStartElement("Name");
                writer.writeCharacters(a.getName());
                writer.writeEndElement();
                writer.writeStartElement("Album");
                String album = a.getAlbum(); //error 
                writer.writeCharacters(a.getAlbum()); //error 
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.flush();
            writer.close();
        } catch (IOException | XMLStreamException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
*/