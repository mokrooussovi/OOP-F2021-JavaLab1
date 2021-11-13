package ca.durhamcollege;

public abstract class Player
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

}
