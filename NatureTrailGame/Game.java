
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Game
{
    private int trailLength;
    private Trail natureTrail;
    private Player playerOne;
    private Player playerTwo;

    public Game()
    {
        trailLength = 0;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player();

    }
    
    public Game(int newTrailLength,int size,String newPlayerOneName,int newPlayerOnePosition,int newPlayerOneScore,
                String newPlayerTwoName,int newPlayertwoPosition,int newPlayerTwoScore)
    {
        trailLength = newTrailLength;
        natureTrail = new Trail(size);
        playerOne = new Player(newPlayerOneName,newPlayerOnePosition,newPlayerOneScore);
        playerTwo = new Player(newPlayerTwoName,newPlayertwoPosition,newPlayerTwoScore);

    }
    
    public int getTrailLength()
    {
        return trailLength;
    }

    public Trail getNatureTrail()
    {
        return natureTrail;
    }

    public Player getPlayerOne()
    {
        return playerOne;
    }

    /**
     * Method getPlayerTwo
     *
     * @return The return value
     */
    public Player getPlayerTwo()
    {
        return playerTwo;
    }

    public void setTrailLength(int newTrailLength)
    {
        trailLength = newTrailLength;
    }

    /**
     * Method setNatureTrail
     *
     * @param index A parameter
     * @param newFeaturePosition A parameter
     * @param newFeatureType A parameter
     * @param newSpacePenalty A parameter
     */
    public void setNatureTrail(int index, int newFeaturePosition,String newFeatureType,int newSpacePenalty)
    {
      natureTrail.setFeature(index,newFeaturePosition,newFeatureType,newSpacePenalty);
        
    }

    public void setPlayerOne(String newName,int newPosition,int newScore)
    {
        playerOne.setName(newName);
        playerOne.setPosition(newPosition);
        playerOne.setScore(newScore);
    }

    public void setPlayerTwo(String newName,int newPosition,int newScore)
    {
        playerTwo.setName(newName);
        playerTwo.setPosition(newPosition);
        playerTwo.setScore(newScore);
    }
    
    public int inputTrailLength()
    {
        Input input1 = new Input();
        
        //Get length of trial from the user
        input1.display("######## Welcome to the Nature Trail ########");
        System.out.println("");
        boolean notValidLength = true;
        int value = 0;
        //length validation and length input from the player
        while(notValidLength)
        {
            value = input1.acceptNumber("--> Enter the length of nature trail [10 to 20]");
            //for(int i = 0;i<;i++)
            
            if (10 <= value && value <= 20)
            {
                notValidLength = false;
            }
            else 
            {
                System.out.println("Please enter a valid length");
            }

        }
        return value;
    }
      
    public String inputPlayerName()
    {
        Input input2 = new Input();
        
        String name = "";
        boolean validName = true;
        //name validation and name input from the player
        while (validName)
        {
            name = input2.acceptString("--> Enter player name [1 to 6 characters]");
            name = name.trim();
            
            if (name.length() >= 1 && name.length() <= 6)
            {
                validName = false;
            }
            else
            {
                System.out.println("Not a valid name, please enter a valid name");
            }

        }
        return name;
    }
    
    public int diceRoll()
    {
        Dice dice1 = new Dice();
        int diceValue = 0;
        diceValue = dice1.generateRandomNumber(1,4);
        return diceValue;
    }
    
    public void playerOneTurn()
    {
        Input input1 = new Input();
        int playerDiceValue = 0;
        input1.acceptString("--> " + playerOne.getName() + " roll the dice");
        playerDiceValue = diceRoll();
        System.out.println(playerOne.getName() + " you got " + playerDiceValue);
        playerOne.setPosition(playerOne.getPosition() + playerDiceValue);

        if (playerOne.getPosition() != 1 && playerOne.getPosition() != trailLength)                            
            playerOne.setScore(playerOne.getScore() + animalSpot());                
        System.out.println(playerOne.getName() + " your score is " + playerOne.getScore());
        
        if (playerOne.getPosition() != 1 && playerOne.getPosition() != trailLength) 
            playerOne.setPosition(playerOne.getPosition() + featureSpot(playerOne.getPosition()));
        
        if (playerOne.getPosition() <= 0)
            playerOne.setPosition(1);
        
                            
                            
        if (playerOne.getPosition() > trailLength)
            playerOne.setPosition(trailLength);
                                
        //System.out.println(playerOne.getName() + " you moved to " + playerOne.getPosition() + " position");
        System.out.println("** Current position on the trail **"); 
        display(playerOne.getPosition(),playerTwo.getPosition());
        
    }
    
    public void playerTwoTurn()
    {
        int computerDiceValue = 0;
        System.out.println("--> Computer rolls the dice");
        System.out.println("");
        computerDiceValue = diceRoll();
        System.out.println(playerTwo.getName() + " get's " + computerDiceValue);
        playerTwo.setPosition(playerTwo.getPosition() + computerDiceValue);
        
        if (playerTwo.getPosition() !=1 && playerTwo.getPosition() != trailLength)
            playerTwo.setScore(playerTwo.getScore() + animalSpot());
          
        System.out.println(playerTwo.getName() + "'s score is " + playerTwo.getScore());
        
        if (playerTwo.getPosition() !=1 && playerTwo.getPosition() != trailLength)
            playerTwo.setPosition(playerTwo.getPosition() + featureSpot(playerTwo.getPosition()));
                                
        if (playerTwo.getPosition() <= 0)                           
            playerTwo.setPosition(1);
                                                                                     
        if (playerTwo.getPosition() > trailLength)
            playerTwo.setPosition(trailLength);
                                
        //System.out.println(playerTwo.getName() + " reached " + playerTwo.getPosition() + " position");                        
        System.out.println("** Current position on the trail **");                    
        display(playerOne.getPosition(),playerTwo.getPosition());
            
    }
    
    public void checkFinish()
    {
        if (playerOne.getPosition() > playerTwo.getPosition())
        {
            System.out.println(playerOne.getName() + " you reached the finish position");
            System.out.println(playerOne.getName() + " you get 10 points for finishing the game");
            playerOne.setScore(playerOne.getScore() + 10);
        }
        else
        {
            System.out.println(playerTwo.getName() + " reached the finish position");
            System.out.println(playerTwo.getName() + " gets 10 points for finishing the game");
            playerTwo.setScore(playerTwo.getScore() + 10);
        }
    }

    public void startGame ()
    {
            Input input = new Input();
            setTrailLength(inputTrailLength());
            System.out.println("");
            playerOne.setName(inputPlayerName());
            playerTwo.setName("Computer");
            System.out.println("");
            System.out.println("******** Game Information ********");
            System.out.println("Hi " + playerOne.getName() + "," + " you are playing against a " + playerTwo.getName() + " opponent and the player with higher score at the end, wins the game");
            System.out.println("Start position is abbreviated as S on the nature trail");
            System.out.println("Final position is abbreviated as F on the nature trail");
            System.out.println(playerOne.getName() + " you are abbreviated as H on the nature trail");
            System.out.println(playerTwo.getName() + " is abbreviated as C on the nature trail");
            //To check who plays first
            System.out.println("");
            System.out.println("");
            System.out.println("Each player rolls the dice and player with higher number plays first");
            System.out.println(playerOne.getName() + ", press enter for rolling the dice");
            int turnFlag = 0;
            int playerDiceValue = 0;
            int computerDiceValue = 0;
            System.out.println("");
            System.out.println("");
            for (int i = 0; i < 1; i--) {
                input.acceptString("--> " + playerOne.getName() + " roll the dice");
                playerDiceValue = diceRoll();
                System.out.println(playerOne.getName() + " gets " + playerDiceValue);
                computerDiceValue = diceRoll();
                System.out.println(playerTwo.getName() + " gets " + computerDiceValue);

                if (playerDiceValue > computerDiceValue) {
                    System.out.println(playerOne.getName() + " plays first");
                    i = 2;
                    turnFlag = 1;
                }

                if (playerDiceValue < computerDiceValue) {
                    System.out.println(playerTwo.getName() + " plays first");
                    i = 2;
                    turnFlag = 2;
                }

                if (playerDiceValue == computerDiceValue) {
                    System.out.println("Its a tie, roll again");

                }


            }
            System.out.println("");
            //setup position for natureFeatures on the trail
            trailSetup();
            //Based on the turn flag switch will execute any of the two cases
            switch (turnFlag) {
                case 1:
                    while (playerOne.getPosition() < trailLength && playerTwo.getPosition() < trailLength) {
                        playerOneTurn();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        if (playerOne.getPosition() < trailLength) {
                            playerTwoTurn();
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");
                        }
                    }

                    System.out.println("");

                    checkFinish();

                    break;

                case 2:
                    while (playerOne.getPosition() < trailLength && playerTwo.getPosition() < trailLength) {
                        playerTwoTurn();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        if (playerTwo.getPosition() < trailLength) {
                            playerOneTurn();
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");
                        }

                    }

                    System.out.println("");

                    checkFinish();

                    break;


            }

            if (playerOne.getScore() > playerTwo.getScore()) {
                System.out.println(playerOne.getName() + " you win and your score is " + playerOne.getScore());
            }

            if (playerOne.getScore() < playerTwo.getScore()) {
                System.out.println(playerTwo.getName() + " wins and score is " + playerTwo.getScore());
            }

            if (playerOne.getScore() == playerTwo.getScore()) {
                System.out.println("Its a tie");
            }


    }

    //Random Animal Spotting 
    public int animalSpot()
    {
        Dice dice = new Dice();
        int animalPosition = dice.generateRandomNumber(1,10);
        int score = 0;
        switch(animalPosition)
        {
            case 1: System.out.println("Spotted a Koala, 10 points");
                    score = 10;
                    break;
            case 2: System.out.println("Spotted a Emu!, 7 points");
                    score =  7;
                    break;
            case 3: System.out.println("Spotted a Wombat!, 5 points");
                    score =  5;
                    break;
            case 4: System.out.println("Spotted a Kangaroo!, 2 points");
                    score =  2;
                    break;
            case 5: System.out.println("Spotted a Redback Spider!, -5 points");
                    score = -5;
                    break;
            case 6: System.out.println("No animal spotted");
                    break;
            case 7: System.out.println("No animal spotted"); 
                    break;
            case 8: System.out.println("No animal spotted");
                    break;
            case 9: System.out.println("No animal spotted");
                    break;
            case 10:System.out.println("No animal spotted");
                    break;
        }
        return score;
        
    }
    
    public int featureSpot(int position)
    {
        int playerPosition = position;
        int positionAction = 0;
        
        for (int i = 0; i < 4 ; i++)
        {
            if (playerPosition == natureTrail.features[i].getFeaturePosition())
            {
                System.out.println(natureTrail.features[i].getFeatureType() + " found");
                
                if (natureTrail.features[i].getSpacePenalty()>0)
                {
                   System.out.println("Move forward "+ natureTrail.features[i].getSpacePenalty() + " position");
                }
                else
                {
                   System.out.println("Move back "+ (-1)*(natureTrail.features[i].getSpacePenalty()) + " position"); 
                }
                positionAction = natureTrail.features[i].getSpacePenalty();
                i = 5;
            }
            
        }
        
        if (positionAction == 0)
            System.out.println(" No feature found");
        
        
    
        return positionAction;
    }
    
    public void display(int playerDisplayPosition,int computerDisplayPosition)
    {
        int playerPosition = playerDisplayPosition;
        int computerPosition = computerDisplayPosition;
        
        for(int i = 1;i <= trailLength;i++)
        {
            
            if (i==1)
            {
             System.out.print("S");
            }
            
            if (playerPosition == i)
            {
                System.out.print("H");
            }
            
            if (computerPosition == i)
            {
                System.out.print("C");
            }
           
            if (playerPosition != i && computerPosition != i  && i!=trailLength && i!=1)
            {
                //System.out.print("  ");
                System.out.print("_");
            
            }
            if (i==trailLength)
            {
             System.out.print("F");
            }
            
            System.out.print("  ");
        }
        
        //System.out.println("F");
    }
    
    //Setting up the nature features randomly on the trail
    public void trailSetup()
    {
        Dice number = new Dice();
        int newPosition = 0;
        int maxPosition = trailLength - 2;
        natureTrail.setupFeatures();
        for (int i = 0; i < 4; i++)
        {
            boolean unique = true;
            while(unique)
            {
                newPosition = number.generateRandomNumber(2,maxPosition);
                for (int j = 0; j < 4; j++)
                {
                    if (newPosition == natureTrail.features[j].getFeaturePosition())
                    {
                        j = 5;
                    }
                    
                    if (j == 3)
                    {
                        unique = false;
                    }
                }
                
            }
            
            natureTrail.features[i].setFeaturePosition(newPosition);
        }
    }
}    
