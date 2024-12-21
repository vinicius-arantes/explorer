import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private HashMap<String, Island> islandsMap = new HashMap<>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 750, 1); 
        prepare();
    }
    
    public void prepare(){
        Island desert = new Island("desert1", "desert");
        addObject(desert,200,375);
        islandsMap.put(desert.getName(), desert);
        
        Island island = new Island("mainOverworld", "overworld");
        addObject(island,600,375);
        islandsMap.put(island.getName(), island);
        
        Island tundra = new Island("tundra1", "tundra");
        addObject(tundra,1000,375);
        islandsMap.put(tundra.getName(), tundra);
        
        Border desertBorder1 = new Border("desert1");
        addObject(desertBorder1,801,375);
        
        Border tundraBorder1 = new Border("tundra1");
        addObject(tundraBorder1,393,375);
        
        Border graveyardBorder1 = new Border("graveyard1");
        graveyardBorder1.turn(90);
        addObject(graveyardBorder1,505,492);
        Border graveyardBorder2 = new Border("graveyard1");
        graveyardBorder2.turn(90);
        addObject(graveyardBorder2,670,492);
        
        Border heavenBorder1 = new Border("heaven1");
        heavenBorder1.turn(90);
        addObject(heavenBorder1,505,217);
        Border heavenBorder2 = new Border("heaven1");
        heavenBorder2.turn(90);
        addObject(heavenBorder2,669,217);
        
        Explorer explorer = new Explorer();
        addObject(explorer,600,375);
        Inventory inventory = new Inventory();
        addObject(inventory, getWidth() / 2, getHeight() / 2);
        HUDCoins hud = new HUDCoins();
        addObject(hud, 50, 20);
    }
    
    public void showIslands(){
        {
            for(Island island : islandsMap.values()){
                if(!island.isVisible()){
                    GreenfootImage image = island.getImage();
                    image.setTransparency(150);
                    island.setImage(image);
                }
            }
        }
    }
    
    public void hideIslands(){
        {
            for(Island island : islandsMap.values()){
                if(!island.isVisible()){
                    GreenfootImage image = island.getImage();
                    image.setTransparency(0);
                    island.setImage(image);
                }
            }
        }
    }
}
