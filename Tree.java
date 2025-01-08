import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    private String biomeType;
    
    public Tree(String biomeType){
        prepareBiome(biomeType);
    }
    
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or ' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    public void prepareBiome(String biomeType){
        if(biomeType.contains("mainOverworld") || biomeType.contains("overworld")){
            this.biomeType = biomeType;
        }else if(biomeType.contains("tundra")){
            this.biomeType = biomeType;
            setImage("tundraTree.png");
        }else if(biomeType.contains("desert")){
            this.biomeType = biomeType;
            setImage("Cactus.png");
        }
    }
}
