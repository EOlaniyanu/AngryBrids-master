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
    
    private int xLocation;
    private int yLocation;
    //private GreenfootImage elasticRect1 = new GreenfootImage( 2, 1 );
    //private GreenfootImage elasticRect2 = new GreenfootImage( 2, 1 );
    private int xElastic;
    private int yElastic;
    
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
            if( mi.getX() < this.getX())
            {
                xElastic = ( this.getX() + mi.getX() )/2;
            }
            else
            {
                xElastic = 70;
            }
            
            if( mi.getY() > (this.getY() - ( (this.getImage().getHeight()) / 2)))
            {
                yElastic = ( this.getY() - ( (this.getImage().getHeight()) / 2) + mi.getY() )/2;
            }
            else
            {
                yElastic = ( this.getY() - (this.getImage().getHeight()/2) );
            }
            
        }    
        
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
    
    public int getXElastic()
    {
        return xElastic;
    }
    
    
    
    public int getYElastic()
    {
        return yElastic;
    }
    
}
