import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Drop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Drop extends Actor
{
    private String type;
    public Drop(String type){
        this.type = type;
    }
    
    /**
     * Act - do whatever the Drop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Explorer.class)) {
            // Aumenta a quantidade de Bronze no Inventory
            Inventory inventory = (Inventory) getWorld().getObjects(Inventory.class).get(0);
            if (inventory != null) {
                if(type.contains("iron")){
                    inventory.takeItenIronOre(1);
                } else if(type.contains("copper")){
                    inventory.takeItenCopperOre(1);
                } else if(type.contains("tin")){
                    inventory.takeItenTinOre(1);
                } else if(type.contains("gold")){
                    inventory.takeItenGoldOre(1);
                } else if(type.contains("owOrb")){
                    inventory.setOverworldOrb(1);
                } else if(type.contains("tdOrb")){
                    inventory.setTundraOrb(1);
                } else if(type.contains("gyOrb")){
                    inventory.setGraveyardOrb(1);
                } else if(type.contains("deOrb")){
                    inventory.setDesertOrb(1);
                }
            }

            // Remove este objeto do mundo
            getWorld().removeObject(this);
        }
    }
}
