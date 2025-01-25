import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Ore
{
    private String biomeType;
    
    public Tree(String biomeType){
        super(100, "tree");
        this.biomeType = biomeType;
        prepareBiome(biomeType);
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
        }else if(biomeType.contains("graveyard")){
            this.biomeType = biomeType;
            setImage("graveyardTree.png");
        }else if(biomeType.contains("heaven")){
            this.biomeType = biomeType;
            setImage("heavenTree.png");
        }
    }
}
