import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackBird extends Birds
{
    private GreenfootImage blackBird = new GreenfootImage("BlackBird.png"); // it uses a private modifier because it is only used in this class.
    private double DAMAGE = 50; // it uses a private modifier because it is only needed in this class.
    
    /**
     * BlackBird sets the damage and image of the bird and scales it to the right size.
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public BlackBird()
    {
        blackBird.scale( 30, 30);
        setImage(blackBird);
        setDamage(DAMAGE);
    }
    
    /**
     * Act - do whatever the BlackBird wants to do. This method is called whenever
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
