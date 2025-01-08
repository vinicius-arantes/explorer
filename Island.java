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
    private int timeCounting;
    private int treeCounting;
    
    public Island(String biomeName, String biomeType){
        visible = false;
        prepareBiomes(biomeName, biomeType);
        timeCounting = 0;
        timeCounting = 0;
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
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
        } else if(biomeType.contains("graveyard")) {
            this.biomeName = biomeName;
            this.biomeType = biomeType;
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
        timeCounting++;
        if (Greenfoot.isKeyDown("m")){
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.showIslands();
            buyIsland();
        } else {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.hideIslands();
        }
        
        MyWorld myWorld = (MyWorld)getWorld();
        int maxX = this.getX() + 200;
        int minX = this.getX() - 200; 
        int maxY = this.getY() + 125;
        int minY = this.getY() - 125;
        
        int x = Greenfoot.getRandomNumber((maxX - minX + 1) + minX);
        int y = Greenfoot.getRandomNumber((maxY - minY + 1) + minY);
        if(isVisible() && timeCounting == 20 && treeCounting <= 10){
            myWorld.addObject(new Tree(getType()), x, y);
            timeCounting = 0;
            treeCounting++;
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
    
    public void buyIsland(){
        if(Greenfoot.mouseClicked(this)){    
            setVisibility();
            GreenfootImage image = getImage();
            image.setTransparency(255);
            setImage(image);
            
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.removeBorders(this.getName());
        }
    }
}
