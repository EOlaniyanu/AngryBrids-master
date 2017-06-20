import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuildingBlocks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildingBlocks extends Actor
{
    public double health;
    public double maxHealth;
    
    /**
     * Act - do whatever the BuildingBlocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }
    
    public BuildingBlocks( )
    {
        
    }
    
    public void setHealth( double h )
    {
        health = h;
        maxHealth = h;
    }
    
    public void hit( double damage)
    {
        
        
        health -= damage;
        
        // if( health <= 0 ) 
        // {
            // health = 0;
            // aWorld.poof(this);
        // }
    }
}
