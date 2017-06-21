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
    private GreenfootImage kingImage = new GreenfootImage( "AngryBirdsKing_Failled.png");
    private GreenfootImage lackeyImage = new GreenfootImage( "AngryBirdsPig.png");
    private double exactX;
    private double exactY;
    private int health;
    
    /**
     * Pig sets the image of the pig object based on the boolean parameter
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
           aWorld.poof(this);
       }
       
       
       
    }
    
    /**
     * fall causes the Hero to fall when he jumps or moves up
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
    
    public void hit( double damage)
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        health -= (int)damage;
    
    }
    
}
