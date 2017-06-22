import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * Name: Emmanuel Olaniyanu
 * Teacher: Mr Hardman
 * Final Project, Angry Birds
 * Date Last Modified: 06/22/2017
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalWorld extends World
{
    private GreenfootImage[] smoke = { new GreenfootImage("smoke_frame_0.png"), new GreenfootImage("smoke_frame_1.png"), new GreenfootImage("smoke_frame_2.png"), new GreenfootImage("smoke_frame_3.png"), new GreenfootImage("smoke_frame_4.png") }; // it uses a private modifier because it is only used in this class
    private GreenfootImage background = new GreenfootImage( "AngryBirdsBackground.jpg"); // it uses a private modifier because it is only used in this class
    private Birds[] birds1 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()}; // it uses a private modifier because it is only used in this class
    private Birds[] birds2 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()}; // it uses a private modifier because it is only used in this class
    private Birds[] birds3 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()}; // it uses a private modifier because it is only used in this class
    public static final double GRAVITY = 5; // This uses a public modifier because it has to interact with other classes, it is static and final because it is not to be changed at all
    private int blockPoofCount = 0; // it uses a private modifier because it is only used in this class
    private int birdPoofCount = 0; // it uses a private modifier because it is only used in this class
    private String message; // it uses a private modifier because it is only used in this class
    private boolean secondBird = false; // it uses a private modifier because it is only used in this class
    private boolean finalBird = false; // it uses a private modifier because it is only used in this class
    private boolean gameOver = false; // it uses a private modifier because it is only used in this class
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public AnimalWorld()
    {    
        super(600, 400, 1); 
        prepareWorld();
    }

    /**
     * prepareWorld creates all needed objects in the world
     * it uses a private modifier because it is only used in this class
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

    /**
     * Act - do whatever the Birds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }

    /**
     * poof makes an animation of the given object turning into smoke
     * This uses a public modifier because it has to interact with other classes
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
     * This uses a public modifier because it has to interact with other classes
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
     * it uses a private modifier because it is only used in this class
     * 
     * @param There are no parameters
     * @return Nothing is returned 
     */
    private void reload()
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
            gameOver = true;
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
     * gameOver stops the program and displays a farewell text to the user
     * it uses a private modifier because it is only used in this class
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void gameOver()
    {
        List<Pig> allEnemies = getObjects(Pig.class);

        if( allEnemies.size() > 0)
        {
             message = " You failed to destroy the Pig empire";
        }
        else
        {
             message = "Congratulations on deafting the Pig empire";
        }

        clearScreen();

        showText( message + "\nThank You for playing"  , getWidth()/2, getHeight()/2 );

        Greenfoot.stop();
    }
    
    /**
     * clearScreen clears the screen of all objects and text and empties the list of objects
     * it uses a private modifier because it is only used in this class
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void clearScreen()
    {
        showText("", getWidth()/2, getHeight()/2 );

        List objects = getObjects(null);

        if ( objects != null)
        {
            removeObjects(objects);
        }
    }
}    