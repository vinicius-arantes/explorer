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
    private int life;
    
    public Tree(String biomeType){
        prepareBiome(biomeType);
        life = 100;
    }
    
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or ' button gets pressed in the environment.
     */
    public void act()
    {
        if(life > 0){
            decreaseLife();
        } else {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.addObject(new Log(), getX(), getY());
            getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setTreeCounting(-1);
            myWorld.removeObject(this);
        }
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
    
    public void decreaseLife(){
        if(Greenfoot.mouseClicked(this)){
            Explorer explorer = (Explorer) getWorld().getObjects(Explorer.class).get(0);
            double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
            if(distance < 50){
                life -= explorer.getDamageCapability();
                if(life < 100 && life > 50){
                    setImage("treeDamaged75.png");
                } else if (life < 75 && life > 25){
                    setImage("treeDamaged50.png");
                } else if(life < 50 && life > 0){
                    setImage("treeDamaged25.png");
                }
            }
        }
    }
}
