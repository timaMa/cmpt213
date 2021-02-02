package ca.cmpt213.assignment3.GameLogic;

/**
 * Tokimon class is for create tokimons
 */

public class Tokimon {

    private static String name;

    public Tokimon(String newName)
    {
        name = newName;
    }

    public String toString()
    {
        String str=this.getName();
        return str;
    }

    public static void setName(String newName)
    {
        name = newName;
    }

    public static String getName()
    {
        return name;
    }




}
