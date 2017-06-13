import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Catapult here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Catapult extends Actor
{
    
    private GreenfootImage catapult = new GreenfootImage( "Catapult.png" );
    
    private int xLocation;
    private int yLocation;
    //private GreenfootImage elasticRect1 = new GreenfootImage( 2, 1 );
    //private GreenfootImage elasticRect2 = new GreenfootImage( 2, 1 );
    
    private CatapultBands elasticRect;
    
    
    public Catapult()
    {
        
        catapult.scale( 80, 85);
        
        setImage( catapult);
        
        

        
        //elasticRect2.setColor(Color.BLACK);
        
        
    }
    
    public void fire()
    {
        
        
        
    }
    
    
    
    /**
     * Act - do whatever the Catapult wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        
        //elasticRect.setLocation( xLocation, yLocation);
        
    }    
}
