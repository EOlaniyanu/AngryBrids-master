import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuildingBlocks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildingBlocks extends Actor
{
    public double health; // This uses a public modifier because it has to interact with other classes
    public double maxHealth; // This uses a public modifier because it has to interact with other classes
    
    /**
     * BuildingBlocks default parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public BuildingBlocks()
    {
        
    }
    
    /**
     * Act - do whatever the BuildingBlocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    /**
     * setHealth sts the Health of the block to a given value
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param h is the given health of the building block
     * @return Nothing is returned
     */
    public void setHealth( double h )
    {
        health = h;
        maxHealth = h;
    }
    
    /**
     * hit reduces the health of the buildingblock based on damage
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param damage is the amount whichh health will be changed by
     * @return Nothing is returned
     */
    public void hit( double damage)
    {
        health -= damage;
    }
}
