import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Actor
{
    private GreenfootImage kingImage = new GreenfootImage( "AngryBirdsKing_Failled.png"); // it uses a private modifier because it is only used in this class.
    private GreenfootImage lackeyImage = new GreenfootImage( "AngryBirdsPig.png"); // it uses a private modifier because it is only used in this class.
    private double exactX; // it uses a private modifier because it is only used in this class.
    private double exactY; // it uses a private modifier because it is only used in this class.
    private int health; // it uses a private modifier because it is only used in this class.
    
    /**
     * Pig's default parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Pig()
    {
        kingImage.scale( 40,50);
        setImage(kingImage);
        health = 10;
    }
    
    /**
     * Pig sets the image of the pig object based on the boolean parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param king tells the computer whether the image for the pig should be the king Image or the lackey Image
     * @return Nothing is returned
     */
    public Pig( boolean king )
    {
        if ( king == true )
        {
            kingImage.scale( 40,50);
            setImage(kingImage);
            health = 10;
        }
        else
        {
            lackeyImage.scale( 30, 30);
            setImage(lackeyImage);
            health = 5;
        }
    }
    
    /**
     * setLocation sets the location of the bird to the given parameters
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param x is the given x location of the bird
     * @param y is the given y location of the bird 
     * @return Nothing is returned
     */
    public void setLocation( int x, int y)
    {
        exactX = x;
        exactY = y;
        super.setLocation( x, y);
    }
    
    /**
     * setLocation overides the setLocation of greenfoot to allow for the use of double values in the method
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param x is the given x location of the bird
     * @param y is the given y location of the bird 
     * @return Nothing is returned
     */
    public void setLocation( double x, double y)
    {
        exactX = x;
        exactY = y;
        super.setLocation( (int) x , (int) y);
    }
    
    /**
     * Act - do whatever the Pig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       AnimalWorld aWorld = (AnimalWorld)getWorld();
       fall();
       
       if( health <= 0  ) 
       {
           getWorld().addObject( new Smoke(), getX(), getY());
           getWorld().removeObject(this);
       }
    }
    
    /**
     * fall causes the Hero to fall when he jumps or moves up
     * it uses a private modifier because it is only used in this class.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void fall()
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        if ( getOneObjectAtOffset(0, getImage().getHeight()/2 +1, BuildingBlocks.class) == null && getY() + getImage().getHeight()/2 +1 < 399 ) 
        {
            setLocation(getX() , getY() + aWorld.GRAVITY);
        }
    }
    
    /**
     * hit reduces the health of the pig based on damage
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param damage is the amount which health will be changed by.
     * @return Nothing is returned
     */
    public void hit( double damage)
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        health -= (int)damage;
    }
}
