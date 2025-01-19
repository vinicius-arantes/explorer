import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Island here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island extends Actor
{
    private String biomeName = "overworld";
    private String biomeType = "overworld";
    private boolean visible;
    private int treeTimeCounting;
    private int stoneTimeCounting;
    private int treeCounting;
    private int stoneCounting;
    
    public Island(String biomeName, String biomeType){
        visible = false;
        prepareBiomes(biomeName, biomeType);
        treeTimeCounting = 0;
        stoneTimeCounting = 0;
        treeCounting = 0;
        stoneCounting = 0;
    }
    
    public void prepareBiomes(String biomeName, String biomeType){
        if(biomeType.contains("mainOverworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
        }else if(biomeType.contains("overworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        } else if(biomeType.contains("tundra")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("tundraBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        } else if(biomeType.contains("desert")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("desertBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        } else if(biomeType.contains("heaven")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("heavenIsland.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        } else if(biomeType.contains("graveyard")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("graveyardBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        }
        
        if(biomeName.contains("mainOverworld")){
            visible = true;
        }
    }
    
    /**
     * Act - do whatever the Island wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isVisible() && treeCounting != 10){
            treeTimeCounting++;
        }
        if(isVisible() && stoneCounting != 8){
            stoneTimeCounting++;
        }
        if (Greenfoot.isKeyDown("m")){
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.showIslands();
            buyIsland();
        } else {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.hideIslands();
        }
        natureSpawns();
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public String getName(){
        return biomeName;
    }
    
    public String getType(){
        return biomeType;
    }
    
    public void setVisibility(){
        visible = true;
    }
    
    public int getTreeCounting(){
        return treeCounting;
    }
    
    public void setTreeCounting(int valueChange){
        treeCounting += valueChange;
    }
    
    public int getStoneCounting(){
        return stoneCounting;
    }
    
    public void setStoneCounting(int valueChange){
        stoneCounting += valueChange;
    }
    
    public void buyIsland(){
        if(Greenfoot.mouseClicked(this)){
            MyWorld myWorld = (MyWorld) getWorld();
            if(myWorld.canBeVisualized(this)){
                setVisibility();
                GreenfootImage image = getImage();
                image.setTransparency(255);
                setImage(image);
                
                myWorld.removeBorders(this.getName());
            }
        }
    }
    
    public boolean haveObjectsAtTheseCords(int x, int y){
        MyWorld myWorld = (MyWorld)getWorld();
        List<Actor> objectsAtTheseCords = myWorld.getObjectsAt(x, y, null);
        for(Actor object : objectsAtTheseCords){
            if(object.getClass().getName() != "Island"){
                return true;
            }
        }
        return false;
    }
    
    public void natureSpawns(){
        MyWorld myWorld = (MyWorld)getWorld();
        int x = Greenfoot.getRandomNumber((getX() + 180) - (getX() - 200) + 1) + (getX() - 200);
        int y = Greenfoot.getRandomNumber((getY() + 97) - (getY() - 125) + 1) + (getY() - 125);
        if(isVisible() && treeTimeCounting >= 1000 && treeCounting <= 10 && !haveObjectsAtTheseCords(x, y)){
            myWorld.addObject(new Tree(getType()), x, y);
            treeTimeCounting = 0;
            treeCounting++;
        }
        
        if(isVisible() && stoneTimeCounting >= 1343 && stoneCounting <= 8 && !haveObjectsAtTheseCords(x, y)){
            myWorld.addObject(new Stone(getType()), x, y);
            stoneTimeCounting = 0;
            stoneCounting++;
        }
    }
}
