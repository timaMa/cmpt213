package ca.cmpt213.assignment3.GameLogic;

/**
 * Fokimon class is for create fokimons
 */

public class Fokimon {

    private String name;

    public Fokimon(String newName)
    {
        name = newName;
    }

    public String toString()
    {
        String str=this.getName();
        return str;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }




}
