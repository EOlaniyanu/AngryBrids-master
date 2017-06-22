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
    private GreenfootImage elasticRect1 = new GreenfootImage( 45, 15 ); // it uses a private modifier because it is only used in this class.
    private int length = 45;  // it uses a private modifier because it is only used in this class.
    private int rotation = 0; // it uses a private modifier because it is only used in this class.
    private double velX = 2.0; // it uses a private modifier because it is only used in this class.
    private double velY = 2.0; // it uses a private modifier because it is only used in this class.
    Catapult catapult; 
    
    /**
     * CatapultBands sets the Image for the elastic bands on the catapult
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @eturn Nothing is returned
     */
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
        catapult = (Catapult)getWorld().getObjects(Catapult.class).get(0);
        calcSpeed();
        updateElastic();
    }

    /**
     * updateElastic changes the rotation length and location of the elastic as needed
     * it uses a private modifier because it is only used in this class.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void updateElastic()
    {
        length = (int)catapult.getLength();
        rotation = (int)catapult.getRectRotation();
        setLocation( catapult.getXElastic(), catapult.getYElastic() );
        elasticRect1.scale( length, 15);
        setRotation(rotation);
    }
    
    /**
     * calcSpeed calculate the x and y velocity of the bird based on the diference in x values 
     * and y values of the mouse and the top of catapult.
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters 
     * @return Nothing is returned
     */
    public void calcSpeed()
    {
        velX = (catapult.getDeltaX() * 0.2);
        velY = (catapult.getDeltaY() * 0.2);
    }
    
    /**
     * getVelX returns the birds velocity in the x direction
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * return velX the birds velocity in the x direction is returned
     */
    public double getVelX()
    { 
        return velX;
    }

    /**
     * getVelY returns the birds velocity in the y direction
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * return velY the birds velocity in the y direction is returned
     */
    public double getVelY()
    {
         return velY;
    }
}
