import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wood extends BuildingBlocks
{
    private int health;
    private int BLOCK_IMAGES = 3;
    private GreenfootImage[] woodSquare = new GreenfootImage[BLOCK_IMAGES];
    private GreenfootImage[] woodRect = new GreenfootImage[BLOCK_IMAGES];
    
    public void Wood( String type )
    {
        
        for( int i = 0; i < BLOCK_IMAGES; i++)
        {
            woodSquare[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_SQUARE_" + i + ".png" );
            woodRect[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_LONG_" + i + ".png" );
        }
        
        
        if ( type == "S" )
        {
            setImage( woodSquare[0] );
            setHealth(10);
        }
        else 
        {
            setImage( woodRect[0] );
            setHealth(5);
        }
        
    }
    
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    
    
}
