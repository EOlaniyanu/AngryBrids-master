import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Birds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Birds extends Actor
{
    private boolean fired = false;
    private int speedX;
    private int speedY;
    private int GRAVITY = -1;
    
    /**
     * Act - do whatever the Birds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if ( fired == true ) 
        {
            ballistics();
        }
    }
    
    public void ballistics()
    {
        setLocation( getX() + speedX, getY());
        
        if( speedY > 0 )
        {
            speedY += GRAVITY;
        }
        else
        {
            speedY = -1;
        }
        
        setLocation( getX(), getY() + speedY );
    }
}
