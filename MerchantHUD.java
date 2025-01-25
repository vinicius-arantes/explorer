import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MerchantHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MerchantHUD extends Actor
{
    private int page;
    
    public MerchantHUD(){
        page = 1;
    }
    
    /**
     * Act - do whatever the MerchantHUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        changePage();
        upgradeTool();
        if(Greenfoot.isKeyDown("escape")){
            getWorld().removeObject(this);
        }
    }
    
    public void changePage(){
        if(page < 2){
            if(Greenfoot.isKeyDown("right")){
                page++;
                //setImage("merchantHUD_" + page + ".png");
                setImage("guia2.png");
            }
        } else if(page > 1){
            if(Greenfoot.isKeyDown("left")){
                page--;
                //setImage("merchantHUD_" + page + ".png");
                setImage("guia1.png");
            }
        }
    }
    
    public void upgradeTool(){
        if(Greenfoot.isKeyDown("enter")){
            List<Explorer> explorer = getWorld().getObjects(Explorer.class);
            if(page == 1){
                explorer.get(0).upgradePickaxe();
                Greenfoot.delay(10);
            } else if(page == 2){
                explorer.get(0).upgradeBackpack();
                Greenfoot.delay(10);
            }
        }
    }
}
