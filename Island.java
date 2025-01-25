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
    private int price;
    private boolean visible;
    
    private int treeTimeCounting;
    private int treeDelaySpawning;
    private int treeCounting;
    private int maxTrees;
    
    private int stoneCounting;
    private int stoneTimeCounting;
    private int stoneDelaySpawning;
    private int maxStones;
    
    private int cowCounting;
    private int cowTimeCounting;
    private int cowDelaySpawning;
    private int maxCows;
    
    public Island(String biomeName, String biomeType, int price){
        visible = false;
        prepareBiomes(biomeName, biomeType);
        this.price = price;
        
        treeTimeCounting = Greenfoot.getRandomNumber(500);
        treeCounting = 0;
        
        stoneTimeCounting = Greenfoot.getRandomNumber(500);
        stoneCounting = 0;
        
        cowTimeCounting = Greenfoot.getRandomNumber(500);
        cowCounting = 0;
    }
    
    public void prepareBiomes(String biomeName, String biomeType){
        if(biomeType.contains("mainOverworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            maxTrees = 6;
            maxStones = 6;
            maxCows = 3;
            treeDelaySpawning = 2000;
            stoneDelaySpawning = 2543;
            cowDelaySpawning = 5500;
        }else if(biomeType.contains("overworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 5;
            maxStones = 4;
            maxCows = 4;
            treeDelaySpawning = 2000;
            stoneDelaySpawning = 2543;
            cowDelaySpawning = 5500;
        } else if(biomeType.contains("tundra")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("tundraBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 8;
            maxStones = 4;
            maxCows = 1;
            treeDelaySpawning = 2600;
            stoneDelaySpawning = 3143;
            cowDelaySpawning = 10500;
        } else if(biomeType.contains("desert")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("desertBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 10;
            maxStones = 0;
            maxCows = 0;
            treeDelaySpawning = 2200;
            stoneDelaySpawning = 10000;
            cowDelaySpawning = 10000;
        } else if(biomeType.contains("heaven")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("heavenIsland.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 11;
            maxStones = 0;
            maxCows = 2;
            treeDelaySpawning = 3000;
            stoneDelaySpawning = 10543;
            cowDelaySpawning = 10500;
        } else if(biomeType.contains("graveyard")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("graveyardBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 4;
            maxStones = 8;
            maxCows = 0;
            treeDelaySpawning = 3500;
            stoneDelaySpawning = 2943;
            cowDelaySpawning = 5500;
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
        if(isVisible() && treeCounting != maxTrees){
            treeTimeCounting++;
        }
        if(isVisible() && stoneCounting != maxStones){
            stoneTimeCounting++;
        }
        if(isVisible() && cowCounting != maxCows){
            cowTimeCounting++;
        }
        if (Greenfoot.isKeyDown("m")){
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.showIslands();
            callBuyIsland();
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
    
    public int getCowCounting(){
        return cowCounting;
    }
    
    public void setCowCounting(int valueChange){
        cowCounting += valueChange;
    }
    
    public void callBuyIsland(){
        MyWorld myWorld = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this) && myWorld.canBeVisualized(this)){
            if(HUDCoins.getCoin() >= price){
                myWorld.addObject(new Warning("buyIsland", this), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
            } else {
                myWorld.addObject(new Warning("notEnoughCoins", this), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
            }
        }
    }
    
    public void buyIsland(){
        MyWorld myWorld = (MyWorld) getWorld();
        
        setVisibility();
        GreenfootImage image = getImage();
        image.setTransparency(255);
        setImage(image);
        myWorld.removeBorders(getName());
        HUDCoins.setCoin(-price);
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
        if(isVisible() && treeTimeCounting >= treeDelaySpawning && treeCounting <= maxTrees && !haveObjectsAtTheseCords(x, y)){
            myWorld.addObject(new Tree(getType()), x, y);
            treeTimeCounting = 0;
            treeCounting++;
        }
        
        if(isVisible() && stoneTimeCounting >= stoneDelaySpawning && stoneCounting <= maxStones && !haveObjectsAtTheseCords(x, y)){
            myWorld.addObject(new Stone(getType()), x, y);
            stoneTimeCounting = 0;
            stoneCounting++;
        }
        
        if(isVisible() && cowTimeCounting >= cowDelaySpawning && cowCounting <= maxCows && !haveObjectsAtTheseCords(x, y)){
            myWorld.addObject(new Cow(this), x, y);
            cowTimeCounting = 0;
            cowCounting++;
        }
    }
}
