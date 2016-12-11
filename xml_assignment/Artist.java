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

public class Artist {

    private String code;
    private String name;
    private String album[];
    private int count;
    //constructor
    public Artist() {
        name = "";
        album = new String[10];
        count = 0;
    }

    //overloaded constructor
    
    public Artist(String name, String album) {
        this.name = name;
        for(int i=0;i<album.length();i++) //this is incorrectly going to 10 
        {
           this.album[i] = album;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the album[]
     */
    public String[] getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(int i,String album) 
    {
        
        this.album[i-1] = album; 
    }

/**
 * @return the code
 */
public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

}
