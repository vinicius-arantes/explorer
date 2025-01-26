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
    
    public MerchantHUD(int level){
        page = 1;
        haveEnoughItensToBuy("pickaxe", level);
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
                haveEnoughItensToBuy("backpack", getWorld().getObjects(Explorer.class).get(0).getBackpackLevel());
            }
        } else if(page > 1){
            if(Greenfoot.isKeyDown("left")){
                page--;
                haveEnoughItensToBuy("pickaxe", getWorld().getObjects(Explorer.class).get(0).getPickaxeLevel());
            }
        }
    }
    
    public void upgradeTool(){
        if(Greenfoot.isKeyDown("enter")){
            List<Explorer> explorer = getWorld().getObjects(Explorer.class);
            if(page == 1){
                payForUpgrade("pickaxe", explorer.get(0).getPickaxeLevel());
                explorer.get(0).upgradePickaxe();
                haveEnoughItensToBuy("pickaxe", explorer.get(0).getPickaxeLevel());
                Greenfoot.delay(10);
            } else if(page == 2){
                payForUpgrade("backpack", explorer.get(0).getPickaxeLevel());
                explorer.get(0).upgradeBackpack();
                haveEnoughItensToBuy("backpack", explorer.get(0).getBackpackLevel());
                Greenfoot.delay(10);
            }
        }
    }
    
    public void haveEnoughItensToBuy(String item, int level){
        if(item.contains("backpack") && level == 0){
            if(HUDCoins.getCoin() >= 5000 && Inventory.getLeather() >= 80){
                setImage("merchantHUD1_ON2.png");
            } else if (HUDCoins.getCoin() < 5000 || Inventory.getLeather() < 80) {
                setImage("merchantHUD1_OFF2.png");
            }
        }
        
        if(item.contains("pickaxe") && level == 1){
            if(HUDCoins.getCoin() >= 100 && Inventory.getLog() >= 12 && Inventory.getStone() >= 10){
                setImage("merchantHUD2_ON1.png");
            } else {
                setImage("merchantHUD2_OFF1.png");
            }
        } else if(item.contains("pickaxe") && level == 2){
            if(HUDCoins.getCoin() >= 1400 && Inventory.getLog() >= 20 && Inventory.getCopper() >= 30){
                setImage("merchantHUD3_ON1.png");
            } else {
                setImage("merchantHUD3_OFF1.png");
            }
        } else if(item.contains("pickaxe") && level == 3){
            if(HUDCoins.getCoin() >= 3200 && Inventory.getLog() >= 30 && Inventory.getBronze() >= 15){
                setImage("merchantHUD4_ON1.png");
            } else {
                setImage("merchantHUD4_OFF1.png");
            }
        } else if(item.contains("pickaxe") && level == 4){
            if(HUDCoins.getCoin() >= 5200 && Inventory.getLog() >= 60 && Inventory.getIron() >= 30){
                setImage("merchantHUD5_ON1.png");
            } else {
                setImage("merchantHUD5_OFF1.png");
            }
        } else if(item.contains("pickaxe") && level == 5){
            if(HUDCoins.getCoin() >= 11200 && Inventory.getLog() >= 60 && Inventory.getGold() >= 30){
                setImage("merchantHUD6_ON1.png");
            } else {
                setImage("merchantHUD6_OFF1.png");
            }
        }
    }
    
    public void payForUpgrade(String type, int lastLevel){
        if(type.contains("pickaxe") && lastLevel == 1){
            HUDCoins.setCoin(-100);
        } else if(type.contains("pickaxe") && lastLevel == 2){
            HUDCoins.setCoin(-1400);
        } else if(type.contains("pickaxe") && lastLevel == 3){
            HUDCoins.setCoin(-3200);
        } else if(type.contains("pickaxe") && lastLevel == 4){
            HUDCoins.setCoin(-5200);
        } else if(type.contains("pickaxe") && lastLevel == 5){
            HUDCoins.setCoin(-11200);
        }
        
        if(type.contains("backpack") && lastLevel == 0){
            HUDCoins.setCoin(-5000);
        }
    }
}
