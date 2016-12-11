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

import java.util.ArrayList;

public interface ArtistReader {

    //Artist getArtist(String name);

    ArrayList<Artist> getArtists();
}
