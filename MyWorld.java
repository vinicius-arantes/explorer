import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private HashMap<String, Island> islandsMap = new HashMap<>();
    private ArrayList<Border> bordersMap = new ArrayList();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 750, 1);
        prepare();
    }

    public void prepare() {
        Island tundra2 = new Island("tundra2", "tundra");
        addObject(tundra2, 200, 125);
        islandsMap.put(tundra2.getName(), tundra2);
        
        Island desert = new Island("desert1", "desert");
        addObject(desert, 200, 375);
        islandsMap.put(desert.getName(), desert);

        Island heaven = new Island("heaven1", "heaven");
        addObject(heaven, 600, 125);
        islandsMap.put(heaven.getName(), heaven);
        
        Island island = new Island("mainOverworld", "mainOverworld");
        island.setVisibility();
        addObject(island, 600, 375);
        islandsMap.put(island.getName(), island);

        Island graveyard2 = new Island("graveyard2", "graveyard");
        addObject(graveyard2, 1000, 125);
        islandsMap.put(graveyard2.getName(), graveyard2);
        
        Island tundra = new Island("tundra1", "tundra");
        addObject(tundra, 1000, 375);
        islandsMap.put(tundra.getName(), tundra);
        
        Island overworld = new Island("overworld", "overworld");
        addObject(overworld, 200, 625);
        islandsMap.put(overworld.getName(), overworld);
        
        Island graveyard = new Island("graveyard1", "graveyard");
        addObject(graveyard, 600, 625);
        islandsMap.put(graveyard.getName(), graveyard);
        
        Island desert2 = new Island("desert2", "desert");
        addObject(desert2, 1000, 625);
        islandsMap.put(desert2.getName(), desert2);
        
        Border desertBorder1 = new Border("desert1");
        addObject(desertBorder1, 393, 375);
        bordersMap.add(desertBorder1);

        Border tundraBorder1 = new Border("tundra1");
        addObject(tundraBorder1, 801, 375);
        bordersMap.add(tundraBorder1);

        Border graveyardBorder1 = new Border("graveyard1");
        graveyardBorder1.turn(90);
        addObject(graveyardBorder1, 505, 492);
        bordersMap.add(graveyardBorder1);
        
        Border graveyardBorder2 = new Border("graveyard1");
        graveyardBorder2.turn(90);
        addObject(graveyardBorder2, 670, 492);
        bordersMap.add(graveyardBorder2);

        Border heavenBorder1 = new Border("heaven1");
        heavenBorder1.turn(90);
        addObject(heavenBorder1, 505, 217);
        bordersMap.add(heavenBorder1);
        
        Border heavenBorder2 = new Border("heaven1");
        heavenBorder2.turn(90);
        addObject(heavenBorder2, 669, 217);
        bordersMap.add(heavenBorder2);

        Explorer explorer = new Explorer();
        addObject(explorer, 600, 375);
        
        Inventory inventory = new Inventory();
        addObject(inventory, getWidth() / 2, getHeight() / 2);
        
        HUDCoins hud = new HUDCoins();
        addObject(hud, 50, 20);
    }
    
    public void showIslands(){
        for(Island island : islandsMap.values()){
            if(!island.isVisible() && canBeVisualized(island)){
                GreenfootImage image = island.getImage();
                image.setTransparency(150);
                island.setImage(image);
            }
        }
    }
    
    public void hideIslands(){
        for(Island island : islandsMap.values()){
            if(!island.isVisible() && canBeVisualized(island)){
                GreenfootImage image = island.getImage();
                image.setTransparency(0);
                island.setImage(image);
            }
        }
    }
    
    public boolean canBeVisualized(Island island){
        String islandName = island.getName();
        if(islandName == "graveyard2"){
            if(!islandsMap.get("heaven1").isVisible() || !islandsMap.get("tundra1").isVisible()){
                return false;
            }
        } else if (islandName == "tundra2"){
            if(!islandsMap.get("heaven1").isVisible() || !islandsMap.get("desert1").isVisible()){
                return false;
            }
        } else if (islandName == "overworld"){
            if(!islandsMap.get("graveyard1").isVisible() || !islandsMap.get("desert1").isVisible()){
                return false;
            }
        } else if (islandName == "desert2"){
            if(!islandsMap.get("graveyard1").isVisible() || !islandsMap.get("tundra1").isVisible()){
                return false;
            }
        }
        return true;
    }
    
    public void removeBorders(String biomeName){
        for(Border border : bordersMap){
            if(border.getName().equals(biomeName)){
                removeObject(border);
            }
        }
    }
    
}
