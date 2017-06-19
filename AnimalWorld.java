import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalWorld extends World
{

    private GreenfootImage[] smoke = { new GreenfootImage("smoke_frame_0.png"), new GreenfootImage("smoke_frame_1.png"), new GreenfootImage("smoke_frame_2.png"), new GreenfootImage("smoke_frame_3.png"), new GreenfootImage("smoke_frame_4.png") };
    
    private boolean birdFired = false;
    
    private int xElastic;
    private int yElastic;
    
    private int deltaX;
    private int deltaY;
    
    private double velX = 5.0;
    private double velY = 5.0;
    
    private Birds[] birds = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};
    
    
    private static final String square = new String( "s");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public AnimalWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareWorld();
    }
    
    private void prepareWorld()
    {
        addObject( new Catapult(), 80, 355);
        addObject( new CatapultBands(), 70, 320);
        addObject( birds[Greenfoot.getRandomNumber(4)], 60, 320);
        addObject( new Wood(  ), 500, 300);
    }
    
    public void act()
    {
        fire();
    }
    
    public void poof( BuildingBlocks b )
    {
        for( int i = 0; i < smoke.length; i++)
        {
            b.setImage( smoke[i] );
            
        }
        
        removeObject(b);
        
    }
    
    public void poof( Birds b)
    {
        for( int i = 0; i < smoke.length; i++)
        {
            b.setImage( smoke[i] );
            
        }
        
        removeObject(b);
        reload();
    }
    
    public void fire()
    {
        CatapultBands elastic = (CatapultBands)getObjects(CatapultBands.class).get(0);
        Catapult catapult = (Catapult)getObjects(Catapult.class).get(0); 
        
        xElastic = elastic.getX();
        yElastic = elastic.getY();
        
        
        
        
        
        
        MouseInfo mi = Greenfoot.getMouseInfo();
            
        if( Greenfoot.mousePressed(this))
        {
            if( mi.getX() < catapult.getX())
            {
                xElastic = ( catapult.getX() + mi.getX() )/2;
            }
            else
            {
                xElastic = 70;
            }
            
            if( mi.getY() > (catapult.getY() - ( (catapult.getImage().getHeight()) / 2)))
            {
                yElastic = ( catapult.getY() - ( (catapult.getImage().getHeight()) / 2) + mi.getY() )/2;
            }
            else
            {
                yElastic = ( catapult.getY() - (catapult.getImage().getHeight()/2) );
            }
            
        }    
            
            
        
       
        
        
        if ( Greenfoot.mouseClicked(this))
        {    
            birdFired = true;
            getFired();
        }
        
        
    }
    
    
    public void reload()
    {
        prepareWorld();
    }
    
    public int getXElastic()
    {
        return xElastic;
    }
    
    public int getYElastic()
    {
        return yElastic;
    }
    
    public boolean getFired()
    {
        return birdFired;
    }
    
    public double getVelX()
    { 
        return velX;
    }
    
    public double getVelY()
    {
         return velY;
    }
    
    
}    
