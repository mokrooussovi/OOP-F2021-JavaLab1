package ca.durhamcollege;

public class Player
{
    // instance variable
    private String m_name;

    // Constructors
    Player(String name)
    {
        setName(name);
    }

    Player()
    {
        setName("Unknown");
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    /**
     * This method tests the Person class and returns a simple message to the console
     * @return {Void}
     */
    public void scoreDetails()
    {
        System.out.println("Score Details for " + this.m_name + ":");
    }

}
