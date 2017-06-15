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
    private double exactX;
    private double exactY;
    private double speedX;
    private double speedY;
    private static final double GRAVITY = 0.5;
    
    
    public Birds()
    {
        
    }
    
    public void setLocation( int x, int y)
    {
        exactX = x;
        exactY = y;
        super.setLocation( x, y);
    }
    
    public void setLocation( double x, double y)
    {
        exactX = x;
        exactY = y;
        super.setLocation( (int) x , (int) y);
    }
    
    public double getExactX()
    {
        return exactX;
    }
    
    public double getExactY()
    {
        return exactY;
    }
    
    public void fired( double velX, double velY)
    {
        speedX = velX;
        speedY = velY;
    }
    
    /**
     * Act - do whatever the Birds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        if ( aWorld.getFired() == true ) 
        {
            
            ballistics();
        }
    }
    
    public void ballistics()
    {
        // setLocation( getX() + speedX, getY());
        
        speedY -= GRAVITY;
        
        setLocation( getExactX() + speedX, getExactY() - speedY);
        
        // // if( speedY > 0 )
        // // {
            // // speedY += GRAVITY;
        // // }
        // // else
        // // {
            // // speedY = -1;
        // // }
        
        // setLocation( getX(), getY() + speedY );
    }
}
