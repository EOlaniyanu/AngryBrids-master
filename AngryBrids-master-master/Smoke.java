import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    private GreenfootImage[] smoke = { new GreenfootImage("smoke_frame_0.png"), new GreenfootImage("smoke_frame_1.png"), new GreenfootImage("smoke_frame_2.png"), new GreenfootImage("smoke_frame_3.png"), new GreenfootImage("smoke_frame_4.png") }; // it uses a private modifier because it is only used in this class
    private int poofCount = 0; // it uses a private modifier because it is only used in this class
    
    
    /**
     * PigSmoke's default parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Smoke()
    {
        
    }
        
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        poof();
    }
    
    /**
     * poof makes an animation of the given object turning into smoke
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned 
     */
    public void poof()
    {
        setImage( smoke[poofCount/3] );
        poofCount++;

        if( poofCount >= 15 )
        {
            getWorld().removeObject(this);
        }
    }
}
