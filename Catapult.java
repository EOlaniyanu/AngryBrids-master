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
    
    private boolean birdFired = false;
    
    private int xLocation;
    private int yLocation;
    //private GreenfootImage elasticRect1 = new GreenfootImage( 2, 1 );
    //private GreenfootImage elasticRect2 = new GreenfootImage( 2, 1 );
    private int xElastic;
    private int yElastic;
    private int deltaX = 1;
    private int deltaY = 1;
    private double rotation = 0;
    private double length = 1;
    
    private double velX = 10.0;
    private double velY = 5.0;
    
    private CatapultBands elasticRect;
    
    
    public Catapult()
    {
        
        catapult.scale( 80, 85);
        
        setImage( catapult);
        
        

        
        //elasticRect2.setColor(Color.BLACK);
        
        
    }
    
    public void fire()
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        CatapultBands elastic = (CatapultBands)aWorld.getObjects(CatapultBands.class).get(0);
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        xElastic = elastic.getX();
        yElastic = elastic.getY();
            
        if( Greenfoot.mousePressed(aWorld))
        {
            // if( mi.getX() < this.getX())
            // {
                xElastic = ( this.getX() + mi.getX() )/2;
                deltaX = this.getX() - mi.getX();
            // }
            // else
            // {
                // xElastic = 70;
                // deltaX = 1;
            // }
            
            // if( mi.getY() > (this.getY() - ( (this.getImage().getHeight()) / 2)))
            // {
                yElastic = ( this.getY() - ( (this.getImage().getHeight()) / 2) + mi.getY() )/2;
                deltaY = mi.getY() - (this.getY() - ( (this.getImage().getHeight()) / 2));
            // }
            // else
            // {
                // yElastic = ( this.getY() - (this.getImage().getHeight()/2) );
                // deltaY = 1;
            // }
            
            length = Math.sqrt( (deltaX *deltaX) + ( deltaY * deltaY));
            rotation = 180 - Math.toDegrees(Math.atan( deltaY/deltaX ));
            
        }    
        
        
        
        if ( Greenfoot.mouseClicked(aWorld))
        {    
            birdFired = true;
            getFired();
        }
        
    }
    
    public boolean getFired()
    {
        return birdFired;
    }
    
    /**
     * Act - do whatever the Catapult wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        fire();
        
        //elasticRect.setLocation( xLocation, yLocation);
        
    }  
    
    public double getLength()
    {
        return length;
    }
    
    public double getRectRotation()
    {
        return rotation;
    }
    
    public double getDeltaX()
    {
        return deltaX;
    }
    
    public double getDeltaY()
    {
        return deltaY;
    }
    
    public int getXElastic()
    {
        return xElastic;
    }
 
    public int getYElastic()
    {
        return yElastic;
    }
    
    public void setFired( boolean bF)
    {
        birdFired = bF;
    }
    
    public void setLength(double l)
    {
        length = l;
    }
    
    public void setRectRotation( double rotation )
    {
        rotation = 0;
    }
    
    public void setDeltaX( int dx)
    {
        deltaX = dx;
    }
    
    public void setDeltaY( int dy)
    {
        deltaY = dy;
    }
    
    // public int setXElastic( int xE)
    // {
        // xElastic = xE;
    // }
 
    // public int setYElastic( int yE)
    // {
        // yElastic = yE;
    // }
    
    // public double getVelX()
    // { 
        // return velX;
    // }
    
    // public double getVelY()
    // {
         // return velY;
    // }
    
}
