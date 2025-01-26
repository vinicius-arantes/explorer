import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stone extends Ore
{
    private String biomeType;
    
    public Stone(String biomeType){
        super(125, "rock");
        this.biomeType = biomeType;
    }
    
    public void prepareBiome(String biomeType){
        if(biomeType.contains("mainOverworld") || biomeType.contains("overworld")){
            this.biomeType = biomeType;
        }else if(biomeType.contains("tundra")){
            this.biomeType = biomeType;
            //setImage("tundraTree.png");
        }else if(biomeType.contains("desert")){
            this.biomeType = biomeType;
            //setImage("Cactus.png");
        }
    }
}
