import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Xp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Xp extends Actor
{
    private int xpAmount;
    public Xp(int xpAmount){
        this.xpAmount = xpAmount;
    }
    
    /**
     * Act - do whatever the Xp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Explorer.class)) {
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.getObjects(Explorer.class).get(0).gainXp(xpAmount);
            myWorld.removeObject(this);
        }
    }
}
