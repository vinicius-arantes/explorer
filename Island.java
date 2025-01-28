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
    
    private int goldCounting;
    private int goldTimeCounting;
    private int goldDelaySpawning;
    private int maxGolds;
    
    private int ironCounting;
    private int ironTimeCounting;
    private int ironDelaySpawning;
    private int maxIrons;
    
    private int copperCounting;
    private int copperTimeCounting;
    private int copperDelaySpawning;
    private int maxCoppers;
    
    private int tinCounting;
    private int tinTimeCounting;
    private int tinDelaySpawning;
    private int maxTins;
    
    private int mobCounting;
    private int mobTimeCounting;
    private int mobDelaySpawning;
    private int maxMobs;
    
    public Island(String biomeName, String biomeType, int price){
        visible = false;
        prepareBiomes(biomeName, biomeType);
        this.price = price;
        
        treeTimeCounting = Greenfoot.getRandomNumber(3500);
        treeCounting = 0;
        
        stoneTimeCounting = Greenfoot.getRandomNumber(3500);
        stoneCounting = 0;
        
        cowTimeCounting = Greenfoot.getRandomNumber(500);
        cowCounting = 0;
        
        goldTimeCounting = Greenfoot.getRandomNumber(500);
        goldCounting = 0;
        
        ironTimeCounting = Greenfoot.getRandomNumber(500);
        ironCounting = 0;
        
        copperTimeCounting = Greenfoot.getRandomNumber(500);
        copperCounting = 0;
        
        tinTimeCounting = Greenfoot.getRandomNumber(500);
        tinCounting = 0;
        
        mobTimeCounting = Greenfoot.getRandomNumber(1500);
        mobCounting = 0;
    }
    
    public void prepareBiomes(String biomeName, String biomeType){
        if(biomeType.contains("mainOverworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            maxTrees = 3;
            maxStones = 3;
            maxCows = 2;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = -1;
            maxMobs = 2;
            mobDelaySpawning = 4000;
            treeDelaySpawning = 4000;
            stoneDelaySpawning = 4500;
            cowDelaySpawning = 5500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
        }else if(biomeType.contains("overworld")){
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 3;
            maxStones = 3;
            maxCows = 2;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = -1;
            maxMobs = 2;
            mobDelaySpawning = 4500;
            treeDelaySpawning = 4000;
            stoneDelaySpawning = 4500;
            cowDelaySpawning = 5500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
        } else if(biomeType.contains("tundra")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("tundraBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 5;
            maxStones = 2;
            maxCows = 0;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = 0;
            maxMobs = 2;
            mobDelaySpawning = 7500;
            treeDelaySpawning = 4000;
            stoneDelaySpawning = 6500;
            cowDelaySpawning = 10500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 8500;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
        } else if(biomeType.contains("desert")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("desertBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 7;
            maxStones = -1;
            maxCows = -1;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = 1;
            maxTins = -1;
            maxMobs = 2;
            mobDelaySpawning = 7500;
            treeDelaySpawning = 4000;
            stoneDelaySpawning = 10000;
            cowDelaySpawning = 10000;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 7500;
            tinDelaySpawning = 6500;
        } else if(biomeType.contains("heaven")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("heavenIsland.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 4;
            maxStones = -1;
            maxCows = 0;
            maxGolds = 1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = -1;
            maxMobs = -1;
            mobDelaySpawning = 7500;
            treeDelaySpawning = 8000;
            stoneDelaySpawning = 10543;
            cowDelaySpawning = 10500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
        } else if(biomeType.contains("graveyard")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("graveyardBiome.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = 3;
            maxStones = 5;
            maxCows = -1;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = -1;
            maxMobs = 2;
            mobDelaySpawning = 6000;
            treeDelaySpawning = 4500;
            stoneDelaySpawning = 5000;
            cowDelaySpawning = 5500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
        } else if(biomeType.contains("endPortal")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
            setImage("endPortal.png");
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            maxTrees = -1;
            maxStones = -1;
            maxCows = -1;
            maxGolds = -1;
            maxIrons = -1;
            maxCoppers = -1;
            maxTins = -1;
            maxMobs = -1;
            mobDelaySpawning = 2500;
            treeDelaySpawning = 2600;
            stoneDelaySpawning = 3143;
            cowDelaySpawning = 10500;
            goldDelaySpawning = 20000;
            ironDelaySpawning = 6000;
            copperDelaySpawning = 4500;
            tinDelaySpawning = 4500;
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
        if(Pause.getGamePause() == false){
            if(isVisible() && treeCounting != maxTrees){
                treeTimeCounting++;
            }
            if(isVisible() && stoneCounting != maxStones){
                stoneTimeCounting++;
            }
            if(isVisible() && cowCounting != maxCows){
                cowTimeCounting++;
            }
            if(isVisible() && goldCounting != maxGolds){
                goldTimeCounting++;
            }
            if(isVisible() && ironCounting != maxIrons){
                ironTimeCounting++;
            }
            if(isVisible() && copperCounting != maxCoppers){
                copperTimeCounting++;
            }
            if(isVisible() && tinCounting != maxTins){
                tinTimeCounting++;
            }
            if(isVisible() && mobCounting != maxMobs){
                mobTimeCounting++;
            }
        
            if (Greenfoot.isKeyDown("m")){
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.showIslands();
                callBuyIsland();
            } else {
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.hideIslands();
            }
        
            if(biomeType.contains("endPortal")){
                endGame();
            }
            natureSpawns();
        
            secretBuying();
        }
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
    
    public void setGoldCounting(int valueChange){
        goldCounting += valueChange;
    }
    
    public void setIronCounting(int valueChange){
        ironCounting += valueChange;
    }
    
    public void setCopperCounting(int valueChange){
        copperCounting += valueChange;
    }
    
    public void setTinCounting(int valueChange){
        tinCounting += valueChange;
    }
    
    public void setMobCounting(int valueChange){
        mobCounting += valueChange;
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
            if(HUDCoins.getCoin() >= price && !biomeType.contains("endPortal")){
                myWorld.addObject(new Warning("buyIsland", this), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
            } else if (HUDCoins.getCoin() >= price && biomeType.contains("endPortal")){
                if(MyWorld.haveAllChalicesFullfilled()){
                    myWorld.addObject(new Warning("buyEndPortal", this), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
                } else {
                    myWorld.addObject(new Warning("cannotbuyEndPortal", this), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
                }
            } else {
                myWorld.addObject(new Warning("notEnoughCoins"), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
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
        MyWorld.showChalice(getType());
        Greenfoot.playSound("buyIsland.mp3");
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
        boolean haveObjectsHere = haveObjectsAtTheseCords(x, y);
        if(isVisible() && treeTimeCounting >= treeDelaySpawning && treeCounting <= maxTrees && !haveObjectsHere){
            myWorld.addObject(new Tree(getType()), x, y);
            treeTimeCounting = 0;
            treeCounting++;
        }
        
        if(isVisible() && stoneTimeCounting >= stoneDelaySpawning && stoneCounting <= maxStones && !haveObjectsHere){
            myWorld.addObject(new Stone(getType()), x, y);
            stoneTimeCounting = 0;
            stoneCounting++;
        }
        
        if(isVisible() && cowTimeCounting >= cowDelaySpawning && cowCounting <= maxCows && !haveObjectsHere){
            myWorld.addObject(new Cow(this), x, y);
            cowTimeCounting = 0;
            cowCounting++;
        }
        
        if(isVisible() && mobTimeCounting >= mobDelaySpawning && mobCounting <= maxMobs && !haveObjectsHere){
            myWorld.addObject(new Mob(this), x, y);
            mobTimeCounting = 0;
            mobCounting++;
        }
        
        if(isVisible() && goldTimeCounting >= goldDelaySpawning && goldCounting <= maxGolds && !haveObjectsHere){
            myWorld.addObject(new GoldOre(), x, y);
            goldTimeCounting = 0;
            goldCounting++;
        }
        
        if(isVisible() && ironTimeCounting >= ironDelaySpawning && ironCounting <= maxIrons && !haveObjectsHere){
            myWorld.addObject(new IronOre(), x, y);
            ironTimeCounting = 0;
            ironCounting++;
        }
        
        if(isVisible() && copperTimeCounting >= copperDelaySpawning && copperCounting <= maxCoppers && !haveObjectsHere){
            myWorld.addObject(new CopperOre(), x, y);
            copperTimeCounting = 0;
            copperCounting++;
        }
        
        if(isVisible() && tinTimeCounting >= tinDelaySpawning && tinCounting <= maxTins && !haveObjectsHere){
            myWorld.addObject(new TinOre(), x, y);
            tinTimeCounting = 0;
            tinCounting++;
        }
    }
    
    public void endGame(){
        Actor explorer = getOneIntersectingObject(Explorer.class);
        if(explorer != null){
            Greenfoot.setWorld(new EndGameWorld());         
        }
    }
    
    public void secretBuying(){
        if(Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("o") && Greenfoot.isKeyDown("p")){
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.buyAllIslands();
            HUDCoins.setCoin(10000);
            Explorer.secretIncrease();
            Inventory.takeItenLog(1000);
            Inventory.takeItenCopperOre(1000);
        }
    }
}
