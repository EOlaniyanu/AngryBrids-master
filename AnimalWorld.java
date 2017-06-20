import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalWorld extends World
{

    private GreenfootImage[] smoke = { new GreenfootImage("smoke_frame_0.png"), new GreenfootImage("smoke_frame_1.png"), new GreenfootImage("smoke_frame_2.png"), new GreenfootImage("smoke_frame_3.png"), new GreenfootImage("smoke_frame_4.png") };

    // private boolean birdFired = false;

    // private int xElastic;
    // private int yElastic;

    // private int deltaX;
    // private int deltaY;

    // private double velX = 5.0;
    // private double velY = 5.0;

    private Birds[] birds1 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};
    
    private Birds[] birds2 = { new RedBird(), new BlackBird(), new BlueBird(), new YellowBird()};

    private static final String square = new String( "s");
    private int blockPoofCount = 0;
    private int birdPoofCount = 0;

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
        addObject( birds1[Greenfoot.getRandomNumber(4)], 60, 320);
        addObject( new Wood(true), 500, 300);
        Wood wood = new Wood(true);
        addObject(wood,392,387);
        wood.setLocation(379,385);
        Wood wood2 = new Wood(true);
        addObject(wood2,382,329);
        wood2.setLocation(378,326);
        Wood wood3 = new Wood(false);
        addObject(wood3,418,394);
        wood3.setLocation(435,393);
        Wood wood4 = new Wood(false);
        addObject(wood4,408,293);
        wood4.setLocation(402,304);
    }

    public void act()
    {
        fire();
    }

    public void poof( BuildingBlocks b )
    {

        b.setImage( smoke[blockPoofCount/3] );
        blockPoofCount++;

        if( blockPoofCount >= 15 )
        {
            removeObject(b);
            blockPoofCount = 0;
        }

    }
    public void poof( Birds b)
    {
        b.setImage( smoke[birdPoofCount/3] );
        birdPoofCount++;

        if( birdPoofCount >= 15 )
        {
            removeObject(b);
            birdPoofCount = 0;
            reload();
        }

        
    }

    public void fire()
    {
        // CatapultBands elastic = (CatapultBands)getObjects(CatapultBands.class).get(0);
        // Catapult catapult = (Catapult)getObjects(Catapult.class).get(0); 

        // xElastic = elastic.getX();
        // yElastic = elastic.getY();

        // MouseInfo mi = Greenfoot.getMouseInfo();
        // if( Greenfoot.mousePressed(this))
        // {
        // if( mi.getX() < catapult.getX())
        // {
        // xElastic = ( catapult.getX() + mi.getX() )/2;
        // }
        // else
        // {
        // xElastic = 70;
        // }

        // if( mi.getY() > (catapult.getY() - ( (catapult.getImage().getHeight()) / 2)))
        // {
        // yElastic = ( catapult.getY() - ( (catapult.getImage().getHeight()) / 2) + mi.getY() )/2;
        // }
        // else
        // {
        // yElastic = ( catapult.getY() - (catapult.getImage().getHeight()/2) );
        // }

        // }    

        // if ( Greenfoot.mouseClicked(this))
        // {    
        // birdFired = true;
        // getFired();
        // }

    }

    public void reload()
    {
        List<CatapultBands> allBands = getObjects(CatapultBands.class);
        
        Catapult catapult = (Catapult)getObjects(Catapult.class).get(0);
        
        removeObjects(allBands);
        
        catapult.setFired(false);
        catapult.setLength(1);
        catapult.setRectRotation(0);
        catapult.setDeltaX(1);
        catapult.setDeltaY(1);
        
        addObject( new CatapultBands(), 70, 320);
        addObject( birds2[Greenfoot.getRandomNumber(4)], 60, 320);
    }

    // public int getXElastic()
    // {
    // return xElastic;
    // }

    // public int getYElastic()
    // {
    // return yElastic;
    // }

    // public boolean getFired()
    // {
    // return birdFired;
    // }

    // public double getVelX()
    // { 
    // return velX;
    // }

    // public double getVelY()
    // {
    // return velY;
    // }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        
    }
}    
