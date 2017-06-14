import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class CatapultBands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CatapultBands extends Actor
{
    private GreenfootImage elasticRect1 = new GreenfootImage( 45, 15 );
    int xLocation;
    int yLocation;
    
    AnimalWorld aWorld = (AnimalWorld)getWorld();
    
    public CatapultBands()
    {
        elasticRect1.setColor(Color.BLACK);
        elasticRect1.fillRect(0, 0, 45, 15);
        setImage(elasticRect1);
        
        
    }
    
    
    /**
     * Act - do whatever the CatapultBands wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        updateElastic();
        
        
    }
    
    public void updateElastic()
    {
        xLocation = aWorld.getXElastic();
        yLocation = aWorld.getYElastic();
        
        //setLocation( xLocation, yLocation);
    }
}
