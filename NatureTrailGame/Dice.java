

public class Dice
{
     int maximumNumber;
     int minimumNumber;
     
     public Dice()
     {
         maximumNumber = 0;
         minimumNumber = 0;
     }
    
   
     public int generateRandomNumber(int newMinimumNumber,int newMaximumNumber)
     {
         minimumNumber = newMinimumNumber;
         maximumNumber = newMaximumNumber;
         return (minimumNumber + (int)(Math.random() * maximumNumber));
     }
}