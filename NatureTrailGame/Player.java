
/**
 * Stores the player details 
 * provides accessor and mutator methods for player position, player name and player score
 * @author (Ashwin Ashok Mehta)
 * @version (02/04/2019)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private int position;
    private int score;

    /**
     * Player Default Constructor for initialising fields of class Player
     */
    public Player()
    {
        name = "";
        position = 1;
        score = 0;
    }
    
    /**
     * Player Non-default Constructor for initialising fields of class Player
     *
     * @param newName A string input parameter
     * @param newPosition An integer input parameter
     * @param newScore An integer input parameter
     */
    public Player(String newName,int newPosition,int newScore)
    {
        name = newName;
        position = newPosition;
        score = newScore;
    }
    
    /**
     * Method displayState
     * To display current state of a playe
     * @return it returns the current state of player in string format 
     */
    public String displayState()
    {
        String state = name + " " + position + " " + score;
        return state;
    }

    /**
     * Method getName
     * To get the value of name field of the player class
     * @return it returns the name as a string
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method getPosition
     * To get the value of position field of the player class
     * @return it returns the position as a integer
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Method getScore
     * To get the value of score field of the player class
     * @return it returns the score as a integer
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Method setName
     * To set a value to the name field of the player class
     * @param newName it is a formal parameter of String type
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Method setPosition
     * To set a value to the position field of the player class
     * @param newPosition it is a formal parameter of integer type
     */
    public void setPosition(int newPosition)
    {
        position = newPosition;        
    }
    
    /**
     * Method setScore
     * To set a value to the score field of the player class
     * @param newScore it is a formal parameter of integer type
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }
}
