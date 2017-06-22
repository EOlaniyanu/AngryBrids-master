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
    private GreenfootImage catapult = new GreenfootImage( "Catapult.png" ); // it uses a private modifier because it is only used in this class.
    private boolean birdFired = false; // it uses a private modifier because it is only changed in this class.
    private int xElastic; // it uses a private modifier because it is only altered in this class.
    private int yElastic;  // it uses a private modifier because it is only used in this class.
    private int deltaX = 1; // it uses a private modifier because it is only used in this class.
    private int deltaY = 1; // it uses a private modifier because it is only used in this class.
    private double rotation = 0; // it uses a private modifier because it is only used in this class.
    private double length = 1; // it uses a private modifier because it is only used in this class.
    
    /**
     * Catapult sets and scales the image of the catapult
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Catapult()
    {
        catapult.scale( 80, 85);
        setImage( catapult);
    }
    
    /**
     * fire calculates the needed informatio for the catapult bands and fires the bird
     * it uses a private modifier because it is only used in this class.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void fire()
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        CatapultBands elastic = (CatapultBands)aWorld.getObjects(CatapultBands.class).get(0);
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        xElastic = elastic.getX();
        yElastic = elastic.getY();
            
        if( Greenfoot.mousePressed(aWorld))
        {
            xElastic = ( this.getX() + mi.getX() )/2;
            deltaX = this.getX() - mi.getX();

            yElastic = ( this.getY() - ( (this.getImage().getHeight()) / 2) + mi.getY() )/2;
            deltaY = mi.getY() - (this.getY() - ( (this.getImage().getHeight()) / 2));
            
            
            length = Math.sqrt( (deltaX *deltaX) + ( deltaY * deltaY));
            rotation = 180 - Math.toDegrees(Math.atan( deltaY/deltaX ));
            
        }    
        
        if ( Greenfoot.mouseClicked(aWorld))
        {    
            birdFired = true;
            getFired();
        }
    }
    
    /**
     * getFired returns the birdFired variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return birdFired is a boolean that says whether the bird was fired or not
     */
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
        fire();
    }  
    
    /**
     * getLength returns the length variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return length is a double that stores the calculated length of the catapult bands
     */
    public double getLength()
    {
        return length;
    }
    
    /**
     * getRectRotation returns the rotation variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return rotation is a double that stores the angle of the catapult bands
     */
    public double getRectRotation()
    {
        return rotation;
    }
    
    /**
     * getDeltaX returns the deltaX
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return deltaX is the double that stores the difference in x values of the mouse and the catapult
     */
    public double getDeltaX()
    {
        return deltaX;
    }
    
    /**
     * getDeltaY returns the deltaY variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return deltaY is the double that stores the difference in y values of the mouse and the top of the catapult
     */
    public double getDeltaY()
    {
        return deltaY;
    }
    
    /**
     * getXElastic returns the xElastic variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return xElastic is a int that stores the  calculated x location of the catapult bands.
     */
    public int getXElastic()
    {
        return xElastic;
    }
    
    /**
     * getYElastic returns the yElastic variable
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return yElastic is an int that stores the calculated y locationof the catapult bands
     */
    public int getYElastic()
    {
        return yElastic;
    }
    
    /**
     * setFired sets birdFired to the given parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param bF stores whether the catapult was fired or not
     * @return Nothing is returned 
     */
    public void setFired( boolean bF)
    {
        birdFired = bF;
    }
    
    /**
     * setLength sets length to a given parameter 
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param l is the length of the cataopult bands
     * @return Nothing is returned 
     */
    public void setLength(double l)
    {
        length = l;
    }
    
    /**
     * setRectRotation sets rotationto the given parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param r is the rotation of the catapult bands
     * @return Nothing is returned 
     */
    public void setRectRotation( double r )
    {
        rotation = r;
    }
    
    /**
     * setDeltaX sets deltaX to the given parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param dx stores the difference in the x values of the mouse and the catapult
     * @return Nothing is returned 
     */
    public void setDeltaX( int dx)
    {
        deltaX = dx;
    }
    
    /**
     * setDeltaY sets deltaY to the given parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param dy is the difference in y values of the mouse and the top of the catapult
     * @return Nothing is returned 
     */
    public void setDeltaY( int dy)
    {
        deltaY = dy;
    }
}
