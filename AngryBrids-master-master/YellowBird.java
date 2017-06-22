import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowBird extends Birds
{
    private GreenfootImage yellowBird = new GreenfootImage("YellowBird.png"); // it uses a private modifier because it is only used in this class.
    private double DAMAGE = 0.5; // it uses a private modifier because it is only used in this class.
    
    /**
     * YellowBird sets the damage and image of the bird and scales it to the right size.
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public YellowBird()
    {
        yellowBird.scale( 30, 30);
        setImage(yellowBird);
        setDamage(DAMAGE);
    }
    
    /**
     * Act - do whatever the GreenBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();
        Catapult catapult = (Catapult)getWorld().getObjects(Catapult.class).get(0);
        CatapultBands elastic = (CatapultBands)aWorld.getObjects(CatapultBands.class).get(0);
        if ( catapult.getFired() ) 
        {
            if( freeFall == false)
            {
                calcVel(elastic);
                
            }    
            ballistics();
            
        }
        
        checkCollisions();
    }
}
