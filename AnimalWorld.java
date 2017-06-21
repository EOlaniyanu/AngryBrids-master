import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalWorld extends World
{

    private GreenfootImage[] smoke = { new GreenfootImage("smoke_frame_0.png"), new GreenfootImage("smoke_frame_1.png"), new GreenfootImage("smoke_frame_2.png"), new GreenfootImage("smoke_frame_3.png"), new GreenfootImage("smoke_frame_4.png") };
    private GreenfootImage background = new GreenfootImage( "AngryBirdsBackground.jpg");

    private Birds[] birds1 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};
    private Birds[] birds2 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};
    private Birds[] birds3 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};
    public static final double GRAVITY = 5;
    private static final String square = new String( "s");
    private int blockPoofCount = 0;
    private int birdPoofCount = 0;
    private int pigPoofCount = 0;
    private int bodyCount = 0;
    private String message;
    private boolean secondBird = false;
    private boolean finalBird = false;
    private boolean gameOver = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public AnimalWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareWorld();
    }

    /**
     * prepareWorld creates all needed objects in the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareWorld()
    {
        background.scale( 600, 400);
        setBackground(background);
        addObject( new Catapult(), 80, 355);
        addObject( new CatapultBands(), 70, 320);
        addObject( birds1[Greenfoot.getRandomNumber(4)], 60, 320);
        addObject( new Wood(true), 500, 300);
        Wood wood = new Wood(true);
        addObject(wood,392,387);
        wood.setLocation(379,385);
        Wood wood2 = new Wood(true);
        addObject(wood2,382,329);
        wood2.setLocation(378,326);
        Wood wood3 = new Wood(false);
        addObject(wood3,418,394);
        wood3.setLocation(435,393);
        Wood wood4 = new Wood(false);
        addObject(wood4,408,293);
        wood4.setLocation(402,304);
        Wood wood5 = new Wood(true);
        addObject(wood5,380,361);
        wood5.setLocation(379,356);
        Wood wood6 = new Wood(false);
        addObject(wood6,522,397);
        wood6.setLocation(514,393);
        Wood wood7 = new Wood(false);
        addObject(wood7,536,366);
        wood7.setLocation(561,394);
        Pig pig = new Pig(false);
        addObject(pig,414,288);
        pig.setLocation(414,284);
        Pig pig2 = new Pig(true);
        addObject(pig2,554,371);
        pig2.setLocation(557,363);
    }

    public void act()
    {
        if( finalBird == true && pigPoofCount == 0 && gameOver == true)
        {
            gameOver();
        }
    }

    public void addBody()
    {
        bodyCount++;
    }

    /**
     * poof makes an animation of the given object turning into smoke
     * 
     * @param b is the buildingblocks object that is to be animated into smoke 
     * @return Nothing is returned 
     */
    public void poof( BuildingBlocks b )
    {

        b.setImage( smoke[blockPoofCount/3] );
        blockPoofCount++;

        if( blockPoofCount >= 15 )
        {
            removeObject(b);
            blockPoofCount = 0;
        }
        
    }

    /**
     * poof makes an animation of the given object turning into smoke
     * 
     * @param b is the pig object that is to be animated into smoke 
     * @return Nothing is returned 
     */
    public void poof( Pig b )
    {

        b.setImage( smoke[pigPoofCount/3] );
        pigPoofCount++;

        if( pigPoofCount >= 15 )
        {
            removeObject(b);
            pigPoofCount = 0;

        }
        
        if( finalBird == true && pigPoofCount == 0 )
        {
            gameOver = true;
        }

    }
    /**
     * poof makes an animation of the given object turning into smoke
     * 
     * @param b is the birds object that is to be animated into smoke 
     * @return Nothing is returned 
     */
    public void poof( Birds b)
    {
        b.setImage( smoke[birdPoofCount/3] );
        birdPoofCount++;

        if( birdPoofCount >= 15 )
        {
            removeObject(b);
            birdPoofCount = 0;

            reload();
        }

    }

    /**
     * reload resets the game by adding a new bird and catapult bands and reset various variables
     * 
     * @param There are no parameters
     * @return Nothing is returned 
     */
    public void reload()
    {
        List<CatapultBands> allBands = getObjects(CatapultBands.class);

        Catapult catapult = (Catapult)getObjects(Catapult.class).get(0);

        removeObjects(allBands);

        catapult.setFired(false);
        catapult.setLength(1);
        catapult.setRectRotation(0);
        catapult.setDeltaX(1);
        catapult.setDeltaY(1);

        addObject( new CatapultBands(), 70, 320);

        if( finalBird == true )
        {
            gameOver();
        }
        else if( secondBird == true)
        {
            addObject( birds3[Greenfoot.getRandomNumber(4)], 60, 320);
            finalBird = true;
        }
        else
        {
            addObject( birds2[Greenfoot.getRandomNumber(4)], 60, 320);
            secondBird = true;
        }

    }

    /**
     * thankYou stops the program and displays a farewell text to the user
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void gameOver()
    {

        List<Pig> allEnemies = getObjects(Pig.class);

        if( allEnemies.size() > 0)
        {
            System.out.println(allEnemies.size());
            Greenfoot.stop();
            // message = " You failed to destroy the Pig empire";
        // }
        // else
        // {
            // message = "Congratulations on deafting the Pig empire";
        }

        // clearScreen();

        // showText( message + "\nThank You for playing"  , getWidth()/2, getHeight()/2 );

        // Greenfoot.stop();
    }

    /**
     * clearScreen clears the screen of all objects and text and empties the list of objects
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void clearScreen()
    {
        showText("", getWidth()/2, getHeight()/2 );

        List objects = getObjects(null);//(null gets all the objects in the world)

        if ( objects != null)
        {
            removeObjects(objects);
        }

    }
}    
