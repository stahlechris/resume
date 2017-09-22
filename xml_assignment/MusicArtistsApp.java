
//      Description:                This program reads an XML file to display
//                                  a list of artists and listings.
//***************************************************************************
package xml_assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicArtistsApp {

    private static ArtistDAO artistDAO = null;
    private static Scanner sc = null;

    public static void main(String[] args) {
        System.out.println("Welcome to the Artist Maintenance application\n");
        artistDAO = DAOFactory.getArtistDAO();
        sc = new Scanner(System.in);

        displayMenu();

        String userChoice = "";
        //The Java compiler generates generally more efficient bytecode from switch statements 
        //that use String objects than from chained if-then-else statements.
        //VIA https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html
        while (!userChoice.equalsIgnoreCase("exit")) {
           userChoice = Validator.getUserChoice(sc, "Enter a command: ", "Invalid choice");
            System.out.println();

            switch (userChoice) {
                case "LIST":
                    displayAllArtists();
                    break;
                    /*
                case "ADD":
                    addArtist();
                    break;
                case "DEL":
                    deleteArtist();
                    break;
                case "HELP":
                    displayMenu();
                    break;
                case "UPDATE":
                    updateArtist();
                    break;
                    */
                case "EXIT":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }

    }

    public static void displayMenu() {
        /*
        System.out.println("COMMAND MENU\n list    - List all artists\n add     - Add a artist\n "
                + "del     - Delete a artist\n help    - Show this menu\n"
                + " update  - Update a artist\n exit    - Exit this application\n");
        */
        System.out.println("COMMAND MENU\n list    - List all artists and their albums"
                + "\n exit    - Exit this application\n");

    }

    public static void displayAllArtists() {
        System.out.println("ARTIST LIST\t ALBUM LIST\n");

        ArrayList<Artist> artists = artistDAO.getArtists();
        Artist a = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < artists.size(); i++) 
        {
            a = artists.get(i);
            sb.append(StringUtils.addSpaces(a.getName(), 15 + 2));
            for(String t: a.getAlbum())
            {
                if(t != null)//dont print nulls, bc we let Artists have a max of 10 albums
                sb.append(t + ", "); 
            }
            sb.deleteCharAt(sb.length()-2); //remove the last comma 
            sb.deleteCharAt(sb.length()-1);//remove the last space
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}//end all 

    //Maybe you'll ask for these in the next assignment
/* 
    public static void addArtist() {
        String name = Validator.getString(sc, "Enter Artist name: ");
        String album = Validator.getString(sc, "Enter first album: ");
        int i = 1;
        Artist artist = new Artist();
        artist.setCode(artist.getName().trim()); //the code is the name - whitespace
        artist.setName(name);
        artist.setAlbum(i, album);
        artistDAO.addArtist(artist);

        System.out.println();
        System.out.println(name + " " + album
                + " has been added.\n");
    }

    public static void updateArtist() {
        String email = Validator.getString(sc, //don't need to validate email already entered
                "Enter email of artist to update: ");

        Artist c = artistDAO.getArtist(email);
        System.out.println();

        if (c != null) { //if email exists...
            System.out.println("We found that artist.");
            artistDAO.updateArtist(c); //send artist tied to entered email
            System.out.println(c.getName()
                    + " has been updated.\n");
        } 
        else 
        {
            System.out.println("No artist matches that email. Can't update.\n");
        }
    }

    public static void deleteArtist() {
        String email = Validator.getString(sc, //don't need to validate email already entered
                "Enter email to delete: ");

        Artist c = artistDAO.getArtist(email);

        System.out.println();
        if (c != null) {
            artistDAO.deleteArtist(c);
            System.out.println(c.getName()
                    + " has been deleted.\n");
        } else {
            System.out.println("No artist matches that email.\n");
        }
    }
    */
