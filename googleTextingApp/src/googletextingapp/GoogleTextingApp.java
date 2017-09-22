package googletextingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author chris stahle
 */
public class GoogleTextingApp {
//\\\\\\\\\\\\\\\\MAIN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//
static int caseNum = 1;
    public static void main(String[] args) {
        Reader inputReader = new Reader();
        ArrayList<String> list = inputReader.getInput();
        System.out.println("Input\t\t\t\tOutput");
        int numCases = Integer.parseInt(list.get(0));
        writeToFile("Input\t\t\t\tOutput", numCases);
        for (int i = 1; i < list.size(); i++) {
            try{
            letterToChar(list.get(i)); //one list element at a time 
            }
            catch(NullPointerException e)
            {
                System.out.println("wtf");
            }
        }
    }
//\\\\\\\\\\\\\\\\MAIN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//

    public static void letterToChar(String s) {
        String encodedMsg = "";
        for (int i = 0; i < s.length(); i++) //iterate through the length of one String element
        {
            char letter = s.charAt(i); //grab each letter from the String element
            int value = 0;
            switch (letter) {
                case ' ':
                    value = 0;
                    encodedMsg += value;
                    break;
                case 'a':
                case 'b':
                case 'c':
                    value = 2;
                    encodedMsg += value;
                    if (letter == 'b') {
                        encodedMsg += value;
                    } else if (letter == 'c') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'd':
                case 'e':
                case 'f':
                    value = 3;
                    encodedMsg += value;
                    if (letter == 'e') {
                        encodedMsg += value;
                    } else if (letter == 'f') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'g':
                case 'h':
                case 'i':
                    value = 4;
                    encodedMsg += value;
                    if (letter == 'h') {
                        encodedMsg += value;
                    } else if (letter == 'i') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'j':
                case 'k':
                case 'l':
                    value = 5;
                    encodedMsg += value;
                    if (letter == 'k') {
                        encodedMsg += value;
                    } else if (letter == 'l') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'm':
                case 'n':
                case 'o':
                    value = 6;
                    encodedMsg += value;
                    if (letter == 'n') {
                        encodedMsg += value;
                    } else if (letter == 'o') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'p':
                case 'q':
                case 'r':
                case 's':
                    value = 7;
                    encodedMsg += value;
                    if (letter == 'q') {
                        encodedMsg += value;
                    } else if (letter == 'r') {
                        encodedMsg += value;
                        encodedMsg += value;
                    } else if (letter == 's') {
                        encodedMsg += value;
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 't':
                case 'u':
                case 'v':
                    value = 8;
                    encodedMsg += value;
                    if (letter == 'u') {
                        encodedMsg += value;
                    } else if (letter == 'v') {
                        encodedMsg += value;
                        encodedMsg += value;
                    }
                    break;

                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    value = 9;
                    encodedMsg += value;
                    if (letter == 'x') {
                        encodedMsg += value;
                    } else if (letter == 'y') {
                        encodedMsg += value;
                        encodedMsg += value;
                    } else if (letter == 'z') {
                        encodedMsg += value;
                        encodedMsg += value;
                        encodedMsg += value;
                    }

                    break;

            }
        }
        //print(s, encodedMsg);
        writeToFile(s, encodedMsg);
    }

    public static void print(String oldMsg, String s) {
        System.out.print(oldMsg);
        
        if(oldMsg.length() > 7)
        {
            System.out.println("\t\t\tCase #" + caseNum + ": " + s);
        }
        else
        {
            System.out.println("\t\t\t\tCase #" + caseNum + ": " + s);
        }
        caseNum++;
    }
    
    public static void writeToFile(String oldMsg, String s){
    try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("GoogleOutputFile.txt", true)))) { //pass true value after to keep appending or some shit
        out.print(oldMsg);
        if(oldMsg.length() > 7)
        {
            out.println("\t\t\tCase #" + caseNum + ": " + s);
        }
        else
        {
            out.println("\t\t\t\tCase #" + caseNum + ": " + s);
        }
        caseNum++;                    
    
    
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void writeToFile(String inputOutput,int numCases)
    {
         try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("GoogleOutputFile.txt", true)))) { //pass true value after to keep appending or some shit
        out.println("Input\t\t\t\tOutput");                  
        //out.print(numCases);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
