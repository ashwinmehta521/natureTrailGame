

/**
 * Write a description of class Input here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Input
{
    // instance variables - replace the example below with your own
    //Scanner console = new Scanner(System.in);
    
    public void display(String displayMessage)
    {
        System.out.println(displayMessage);
    }
    
    public String acceptString(String displayMessage)
    {
        Scanner text = new Scanner(System.in);
        display(displayMessage);
        String input = text.nextLine();
        return input;
    }
    
    public int acceptNumber(String displayMessage)
    {
        Scanner numeric = new Scanner(System.in);
        display(displayMessage);
        int input=0;
        while(!numeric.hasNextInt())
        {
            System.out.println("Please enter a numeric input");
            numeric.next();
        }
        input = numeric.nextInt();
        return input;
    }
    
    public char acceptChar(String displayMessage)
    {
        Scanner character = new Scanner(System.in);
        display(displayMessage);
        char input = character.next().charAt(0);
        return input;
    }
    
   
}
