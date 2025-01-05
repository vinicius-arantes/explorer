import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public Island(String biomeName, String biomeType){
        visible = false;
        prepareBiomes(biomeName, biomeType);
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
        } else {
            visible = false;
        }
    }
    
    /**
     * Act - do whatever the Island wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("m")){
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.showIslands();
            buyIsland();
        } else {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.hideIslands();
        }
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public String getName(){
        return biomeName;
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
