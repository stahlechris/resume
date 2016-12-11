//***************************************************************************
//	File:                       CustomerMaintApp.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 6
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        December 6, 2016
//
//      Description:                This program maintains a list of customers.
//                                  It reads and writes from and to a 
//                                  derby database.
//***************************************************************************
package customermaintenancesql;

public class StringUtils
{
    public static String addSpaces(String s, int length)
    {
        if (s.length() < length)
        {
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() < length)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        else
        {
            return s.substring(0, length);
        }
    }
    
}
