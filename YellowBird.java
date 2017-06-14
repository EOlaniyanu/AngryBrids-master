import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowBird extends Birds
{
    private GreenfootImage yellowBird = new GreenfootImage("YellowBird.png");
    
    public YellowBird()
    {
        yellowBird.scale( 30, 30);
        setImage(yellowBird);
    }
    
    /**
     * Act - do whatever the GreenBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
