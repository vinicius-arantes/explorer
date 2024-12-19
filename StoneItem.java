import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoneItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoneItem extends Actor
{
    /**
     * Act - do whatever the StoneItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Explorer.class)) {
            // Aumenta a quantidade de Bronze no Inventory
            Inventory inventory = (Inventory) getWorld().getObjects(Inventory.class).get(0);
            if (inventory != null) {
                inventory.takeItenStone();
            }

            // Remove este objeto do mundo
            getWorld().removeObject(this);
        }
    }
}
