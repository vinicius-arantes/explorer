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
        Island tundra2 = new Island("tundra2", "tundra", 4500);
        addObject(tundra2, 200, 125);
        islandsMap.put(tundra2.getName(), tundra2);
        
        Island desert = new Island("desert1", "desert", 600);
        addObject(desert, 200, 375);
        islandsMap.put(desert.getName(), desert);

        Island heaven = new Island("heaven1", "heaven", 12000);
        addObject(heaven, 600, 125);
        islandsMap.put(heaven.getName(), heaven);
        
        Island island = new Island("mainOverworld", "mainOverworld", 0);
        island.setVisibility();
        addObject(island, 600, 375);
        islandsMap.put(island.getName(), island);

        Island graveyard2 = new Island("graveyard2", "graveyard", 10000);
        addObject(graveyard2, 1000, 125);
        islandsMap.put(graveyard2.getName(), graveyard2);
        
        Island tundra = new Island("tundra1", "tundra", 3000);
        addObject(tundra, 1000, 375);
        islandsMap.put(tundra.getName(), tundra);
        
        Island overworld = new Island("overworld", "overworld", 2150);
        addObject(overworld, 200, 625);
        islandsMap.put(overworld.getName(), overworld);
        
        Island graveyard = new Island("graveyard1", "graveyard", 8000);
        addObject(graveyard, 600, 625);
        islandsMap.put(graveyard.getName(), graveyard);
        
        Island desert2 = new Island("desert2", "desert", 4500);
        addObject(desert2, 1000, 625);
        islandsMap.put(desert2.getName(), desert2);
        
        setBorders();
        
        Explorer explorer = new Explorer();
        addObject(explorer, 600, 375);
        
        Inventory inventory = new Inventory();
        addObject(inventory, getWidth() / 2, getHeight() / 2);
        
        Market market = new Market();
        addObject(market, 420, 255);
        
        MarketHUD markethud = new MarketHUD();
        addObject(markethud, getWidth() / 2, getHeight() / 2);
        
        FurnaceHUD furnacehud = new FurnaceHUD();
        addObject(furnacehud, getWidth() / 2, getHeight() / 2);
        
        SkillTree skilltree = new SkillTree();
        addObject(skilltree, getWidth() / 2, getHeight() / 2);
        
        Guide guide = new Guide();
        addObject(guide, 600, 350);
        
        HUDCoins hud = new HUDCoins();
        addObject(hud, 50, 20);
    }
    
    public void setBorders(){
        Border mainToGrave = new Border("graveyard1", 400, 1);
        addObject(mainToGrave, 595, 492);
        bordersMap.add(mainToGrave);
        
        Border mainToHeaven = new Border("heaven1", 400, 1);
        addObject(mainToHeaven, 595, 220);
        bordersMap.add(mainToHeaven);
        
        Border mainToDesert = new Border("desert1", 1, 240);
        addObject(mainToDesert, 380, 355);
        bordersMap.add(mainToDesert);
        
        Border mainToTundra = new Border("tundra1", 1, 240);
        addObject(mainToTundra, 795, 355);
        bordersMap.add(mainToTundra);
        
        Border heavenToTundra2 = new Border("tundra2", 1, 240);
        addObject(heavenToTundra2, 380, 100);
        bordersMap.add(heavenToTundra2);
        
        Border heavenToGraveyard2 = new Border("graveyard2", 1, 240);
        addObject(heavenToGraveyard2, 795, 100);
        bordersMap.add(heavenToGraveyard2);
        
        Border graveyardToOverw = new Border("overworld", 1, 240);
        addObject(graveyardToOverw, 380, 625);
        bordersMap.add(graveyardToOverw);
        
        Border graveyardToDesert2 = new Border("desert2", 1, 240);
        addObject(graveyardToDesert2, 795, 625);
        bordersMap.add(graveyardToDesert2);
        
        Border tundraToDesert2 = new Border("desert2", 400, 1);
        addObject(tundraToDesert2, 1000, 492);
        bordersMap.add(tundraToDesert2);
        
        Border tundraToGraveyard2 = new Border("graveyard2", 400, 1);
        addObject(tundraToGraveyard2, 1000, 220);
        bordersMap.add(tundraToGraveyard2);
        
        Border desertToOverw = new Border("overworld", 400, 1);
        addObject(desertToOverw, 180, 492);
        bordersMap.add(desertToOverw);
        
        Border desertToTundra2 = new Border("tundra2", 400, 1);
        addObject(desertToTundra2, 180, 220);
        bordersMap.add(desertToTundra2);
        
        Border overworldToGrave = new Border("graveyard1", 1, 240);
        addObject(overworldToGrave, 400, 625);
        bordersMap.add(overworldToGrave);
        
        Border overworldToDesert = new Border("desert1", 400, 1);
        addObject(overworldToDesert, 180, 472);
        bordersMap.add(overworldToDesert);
        
        Border tundra2ToHeaven = new Border("heaven1", 1, 240);
        addObject(tundra2ToHeaven, 400, 100);
        bordersMap.add(tundra2ToHeaven);
        
        Border tundra2ToDesert = new Border("desert1", 400, 1);
        addObject(tundra2ToDesert, 180, 240);
        bordersMap.add(tundra2ToDesert);
        
        Border desert2ToTundra = new Border("tundra1", 400, 1);
        addObject(desert2ToTundra, 1000, 472);
        bordersMap.add(desert2ToTundra);
        
        Border desert2ToGrave = new Border("graveyard1", 1, 240);
        addObject(desert2ToGrave, 775, 625);
        bordersMap.add(desert2ToGrave);
        
        Border graveyard2ToHeaven = new Border("heaven1", 1, 240);
        addObject(graveyard2ToHeaven, 775, 100);
        bordersMap.add(graveyard2ToHeaven);
        
        Border graveyard2ToTundra = new Border("tundra1", 400, 1);
        addObject(graveyard2ToTundra, 1000, 240);
        bordersMap.add(graveyard2ToTundra);
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
            if(!islandsMap.get("heaven1").isVisible() && !islandsMap.get("tundra1").isVisible()){
                return false;
            }
        } else if (islandName == "tundra2"){
            if(!islandsMap.get("heaven1").isVisible() && !islandsMap.get("desert1").isVisible()){
                return false;
            }
        } else if (islandName == "overworld"){
            if(!islandsMap.get("graveyard1").isVisible() && !islandsMap.get("desert1").isVisible()){
                return false;
            }
        } else if (islandName == "desert2"){
            if(!islandsMap.get("graveyard1").isVisible() && !islandsMap.get("tundra1").isVisible()){
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
    
    public Island getIsland(String islandName){
        return islandsMap.get(islandName);
    }
    
}
