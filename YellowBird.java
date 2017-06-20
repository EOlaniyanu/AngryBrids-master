import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowBird extends Birds
{
    private GreenfootImage yellowBird = new GreenfootImage("YellowBird.png");
    public double DAMAGE = 0.5;
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
