import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Warning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warning extends Actor
{
    private String warningType;
    private boolean canExecute;
    private Island island;
    
    public Warning(String warningType, Actor actor){
        this.warningType = warningType;
        island = null;
        canExecute = true;
        prepareWarning(warningType);
        prepareAction(actor);
    }
    
    public Warning(String warningType){
        this.warningType = warningType;
        island = null;
        canExecute = true;
        prepareWarning(warningType);
    }
    
    /**
     * Act - do whatever the Warning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("enter")){
            if(warningType.contains("buyIsland")){
                island.buyIsland();
            }
            getWorld().removeObject(this);
        } else if(Greenfoot.isKeyDown("escape")){
            getWorld().removeObject(this);
        }
    }
    
    public void prepareAction(Actor actor){
        if(actor.getClass().getName().equals("Island")){
            island = (Island) actor;
        }
    }
    
    public void prepareWarning(String warningType){
        if(warningType.contains("buyIsland")){
            setImage(warningType + ".png");
        } else if (warningType.contains("notEnoughCoins")){
            setImage(warningType + ".png");
        } else if (warningType.contains("cannotBuyEndPortal")){
            setImage(warningType + ".png");
        } else if (warningType.contains("buyEndPortal")){
            setImage(warningType + ".png");
        }
    }
}
