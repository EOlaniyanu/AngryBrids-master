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
    public double DAMAGE = 0.5;
    public BlueBird()
    {
        blueBird.scale( 30, 30);
        setImage(blueBird);
        setDamage(DAMAGE);
    }
    
    /**
     * Act - do whatever the BlueBird wants to do. This method is called whenever
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
