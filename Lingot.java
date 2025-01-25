import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lingot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lingot extends Actor
{
    private String type;
    public Lingot(String type){
        this.type = type;
    }
    
    /**
     * Act - do whatever the Lingot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Explorer.class)) {
            // Aumenta a quantidade de Bronze no Inventory
            Inventory inventory = (Inventory) getWorld().getObjects(Inventory.class).get(0);
            if (inventory != null) {
                if(type.contains("iron")){
                    inventory.takeItenIron(1);
                } else if(type.contains("copper")){
                    inventory.takeItenCopper(1);
                } else if(type.contains("tin")){
                    inventory.takeItenTin(1);
                } else if(type.contains("gold")){
                    inventory.takeItenGold(1);
                } else if(type.contains("bronze")){
                    inventory.takeItenBronze(1);
                }
            }

            // Remove este objeto do mundo
            getWorld().removeObject(this);
        }
    }
}
