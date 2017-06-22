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
    private double exactX; // it uses a private modifier because it is only used in this class
    private double exactY; // it uses a private modifier because it is only used in this class
    private double speedX; // it uses a private modifier because it is only used in this class
    private double speedY; // it uses a private modifier because it is only used in this class
    private static final double GRAVITY = 0.2; // it uses a private modifier because it is only used in this class, it is static and final because it is not to be changed at all
    private static final double FRICTION = 0.5; // it uses a private modifier because it is only used in this class, it is static and final because it is not to be changed at all
    public boolean freeFall = false; // This uses a public modifier because it has to interact with other classes
    private double DAMAGE; // it uses a private modifier because it is only used in this class
    
    /**
     * Birds default parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Birds()
    {
        
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
     * setLocation sets the location of the bird to the given parameters
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
     * setDamage sets the damage of the bird to the given parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param d is the given damage of the bird
     * @return Nothing is returned
     */
    public void setDamage( double d)
    {
         DAMAGE = d;
    }
    
    /** 
     * fired sets the x and y velocity of the bird to its given parameters
     * This uses a public modifier because it has to interact with other classes
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
     * This uses a public modifier because it has to interact with other classes
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
     * This uses a public modifier because it has to interact with other classes
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
     * This uses a public modifier because it has to interact with other classes
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
