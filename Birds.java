import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Birds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Birds extends Actor
{
    private boolean fired = true;
    private double exactX;
    private double exactY;
    private double speedX;
    private double speedY;
    private static final double GRAVITY = 0.2;
    private static final double FRICTION = 0.5;
    public boolean freeFall = false;
    private double DAMAGE;
    
    
    
    public Birds()
    {
        
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
     * setLocation sets the location of the bird to the given parameters
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
     * setDamage sets the damage of the bird to the given parameter
     * 
     * @param d is the given damage of the bird
     * @raturn Nothing is returned
     */
    public void setDamage( double d)
    {
         DAMAGE = d;
    }
    
    /** 
     * fired sets the x and y velocity of the bird to its given parameters
     * 
     * @param velX  is the birds velocity in the x direction
     * @param velY is the birds velocity in the y direction;
     * @return Nothing is returned
     */
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
        
    }
    
    /**
     * calcVel gets the x and why velocity of the bird and sends it to the fire method, 
     * it also makes gravity to act on the bird.
     * 
     * @param currentBands is the current CatapultBelts that has the x and y velocity of the bird
     * @return Nothing is returned
     */
    public void calcVel(CatapultBands currentBands)
    {
        fired( currentBands.getVelX(), currentBands.getVelY());
        freeFall = true;
    }
    
    /**
     * ballistics causes the bird to act like an object under the force of gravity
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void ballistics()
    {
        speedY -= GRAVITY;
        setLocation( exactX + speedX, exactY - speedY);
    }
    
    
    /**
     * checkCollisions checks fot the birds interactions with other objects and responds accordingly
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void checkCollisions()
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        double impactVel = Math.sqrt( (speedX * speedX) + (speedY * speedY));
        List<BuildingBlocks> allObstacles = getIntersectingObjects(BuildingBlocks.class);
        List<Pig> allEnemies = getIntersectingObjects(Pig.class);
        if( getY() <= 1)
        {
            speedY *= -1;
        }
        else if( getY() >= 395 )
        {
            
            if ( speedX >= 0)
            {
                speedX -= FRICTION;
            }
            else 
            {
                speedX = 0;
                aWorld.poof(this);
            }
        }
        else if( getX() <= 0 )
        {
            aWorld.poof(this);
        }
        else if( getX() >= 599 )
        {
            aWorld.poof(this);
        }
        
        for( int i = 0; i < allEnemies.size(); i++)
        {
            allEnemies.get(i).hit( DAMAGE * impactVel ); 
            speedX = -2.0;
            aWorld.poof(this);
        }
        
        for( int i = 0; i < allObstacles.size(); i++)
        {
            allObstacles.get(i).hit( DAMAGE * impactVel ); 
            speedX = -2.0;
            aWorld.poof(this);
        }
    }
}
