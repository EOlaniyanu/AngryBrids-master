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
    private int length = 45;
    private int rotation = 0;
    private double velX = 2.0;
    private double velY = 2.0;
    
    
    // AnimalWorld aWorld;
    
    Catapult catapult;
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
        // aWorld = (AnimalWorld)getWorld();
        catapult = (Catapult)getWorld().getObjects(Catapult.class).get(0);
        calcSpeed();
        updateElastic();
    }
    
    public void updateElastic()
    {
        length = (int)catapult.getLength();
        rotation = (int)catapult.getRectRotation();
        setLocation( catapult.getXElastic(), catapult.getYElastic() );
        elasticRect1.scale( length, 15);
        setRotation(rotation);
    }
    
    public void calcSpeed()
    {
        velX = (catapult.getDeltaX() * 0.2);
        velY = (catapult.getDeltaY() * 0.2);
        
    }
    
    public double getVelX()
    { 
        return velX;
    }
    
    public double getVelY()
    {
         return velY;
    }
    
}
