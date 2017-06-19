import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBird extends Birds
{
    private GreenfootImage blueBird = new GreenfootImage("BlueBird.png");
    
    public BlueBird()
    {
        blueBird.scale( 30, 30);
        setImage(blueBird);
    }
    
    /**
     * Act - do whatever the BlueBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        
        if ( aWorld.getFired() ) 
        {
            if( freeFall == false)
            {
                calcVel(aWorld);
                
            }    
            ballistics();
            
        }
        
    }    
}
