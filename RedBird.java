import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBird extends Birds
{
    private GreenfootImage redBird = new GreenfootImage("RedBird.png");
    public double DAMAGE = 0.5;
    public RedBird()
    {
        redBird.scale( 30, 30);
        setImage(redBird);
        setDamage(DAMAGE);
    }
    
    
    /**
     * Act - do whatever the RedBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
