import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackBird extends Birds
{
    private GreenfootImage blackBird = new GreenfootImage("BlackBird.png");
    public double DAMAGE = 50;
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
