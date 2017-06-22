import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wood extends BuildingBlocks
{
    private int BLOCK_IMAGES = 3;// it uses a private modifier because the variable is only used in this class
    private GreenfootImage[] woodSquare = new GreenfootImage[BLOCK_IMAGES];// it uses a private modifier because the variable is only used in this class
    private GreenfootImage[] woodRect = new GreenfootImage[BLOCK_IMAGES];// it uses a private modifier because the variable is only used in this class
    private boolean square; // it uses a private modifier because the variable is only used in this class

    
    /**
     * Wood's default parameter
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Wood()
    {
        for( int i = 0; i < BLOCK_IMAGES; i++)
        {
            woodSquare[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_SQUARE_" + i + ".png" );
            woodSquare[i].scale( 30,30 );
            woodRect[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_LONG_" + i + ".png" );
            woodRect[i].scale( 80, 15);
        }
        
        square = false;
        setImage( woodRect[0] );
        setHealth(15);
    }
    
    /**
     * This constructor sets an Image array and health to every wood object based on the type of object 
     * it is set to be.
     * This uses a public modifier because it has to interact with other classes
     * 
     * @param img tells us which type of block the wood object is.
     * @return Nothing is returned
     */
    public Wood( boolean img )
    {
        for( int i = 0; i < BLOCK_IMAGES; i++)
        {
            woodSquare[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_SQUARE_" + i + ".png" );
            woodSquare[i].scale( 30,30 );
            woodRect[i] = new GreenfootImage( "ANGRYBIRDS_INGAME_BLOCKS_WOOD_LONG_" + i + ".png" );
            woodRect[i].scale( 80, 15);
        }

        if ( img  == true  )
        {
            square = true;
            setImage( woodSquare[0] );
            setHealth(10);
        }
        else 
        {
            square = false;
            setImage( woodRect[0] );
            setHealth(15);
        }

    }
    
    /**
     * Act - do whatever the Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHealth();
    }
    
    /**
     * checkHealth checks the health of the wood object and responds accordingly
     * it uses a private modifier because it is only used in this class.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkHealth()
    {
        AnimalWorld aWorld = (AnimalWorld)getWorld();

        if( square == true)
        {
            if( health <= 0 ) 
            {
                health = 0;
                aWorld.poof(this);
            }
            else if( health <= 10 )
            {
                setImage( woodSquare[1]);
            }
            else if( health <= (maxHealth * 0.50) )
            {
                setImage( woodSquare[2]);
            }
            else if( health <= ( maxHealth * 0.25) )
            {
                setImage( woodSquare[3]);
            }
            else if( health == maxHealth)
            {
                setImage( woodSquare[0]);
            }

        }
        else
        {
            if( health <= 0 ) 
            {
                health = 0;
                aWorld.poof(this);
            }    
            else if( health < 15 )
            {
                setImage( woodRect[1]);
            }
            else if( health <= (maxHealth * 0.50) )
            {
                setImage( woodRect[2]);
            }
            else if( health <= ( maxHealth * 0.25) )
            {
                setImage( woodRect[3]);
            }
            else if( health == maxHealth)
            {
                setImage( woodRect[0]);
            }

        }
    }
}
