package ca.durhamcollege;

public class GameScore extends Player
{
    // instance variable
    private int m_score1;
    //private int m_score2;

    // Constructors
    GameScore(int score1)
    {
        super();
        setScore1(score1);
    }

    public int getScore1()
    {
        return m_score1;
    }


    public  void setScore1(int score1)
    {
        m_score1 = score1;
    }


    /**
     * This method tests the Person class and returns a simple message to the console
     * @return {Void}
     */
    public void scoreScoreDetails()
    {
        System.out.println("Score Details for " + this.m_score1 + ":");
        //System.out.println("Score Details for " + this.m_score2 + ":");
    }
}
