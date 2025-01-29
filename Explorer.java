import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Explorer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explorer extends Actor
{
    private int damageCapability;
    private int damageCapabilityMobs;
    private static int life;
    private static int lifeMax;
    private static int xp;
    private static int xpIncrease;
    private static int xpDificult;
    private static int xpLevel;
    private static int xpPoint;
    private int pickaxeLevel;
    private int backpackLevel;
    private int regenCooldown;
    private int reciveRecentDemage;
    private int speed;
    
    public Explorer(){
        damageCapability = 25;
        damageCapabilityMobs = 25;
        life = 100;
        lifeMax = 100;
        xp = 0;
        xpIncrease = 1;
        xpDificult = 0;
        xpLevel = 1;
        xpPoint = 0;
        pickaxeLevel = 0;
        backpackLevel = 0;
        regenCooldown = 0;
        reciveRecentDemage = 0;
        speed = 2;
    }
    
    /**
     * Act - do whatever the Explorer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Pause.getGamePause() == false){
            movimentar();
            colisions();
            openGuide();
            upLevel();
            regenLife();
        }
    }
    
    public void openGuide(){
        if(Greenfoot.isKeyDown("h")){
            List<Guide> guide = getWorld().getObjects(Guide.class);
            if(guide.isEmpty()){
                Guide guia = new Guide();
                getWorld().addObject(guia, 600, 375);
            }
        }
    }
    
    public void movimentar() {
        // Movimento com as setas do teclado
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed); // Move para cima
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed); // Move para baixo
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY()); // Move para a esquerda
            setImage("mainCharac.png");
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY()); // Move para a direita
            setImage("mainCharacRight.png");
        }
    }
    
    public void colisions(){
        if(haveIntersectingObjects()){
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() + speed); // Nega o movimento pra cima
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() - speed); // Nega o movimento pra baixo
            }
            if (Greenfoot.isKeyDown("a")) {
                setLocation(getX() + speed, getY()); // Nega o movimento pra esquerda
            }
            if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() - speed, getY()); // Nega o movimento pra direita
            }
        }
    }
    
    public boolean haveIntersectingObjects(){
        Actor border = getOneIntersectingObject(Border.class);
        Actor ore = getOneIntersectingObject(Ore.class);
        if(border != null || ore != null){
            return true;
        }
        return false;
    }
    
    public int getDamageCapability(){
        return damageCapability;
    }
    
    public int getDamageCapabilityMobs(){
        return damageCapabilityMobs;
    }
    
    public void takeDamage(int damageGiven){
        life -= damageGiven;
        getWorld().getObjects(HUDLife.class).get(0).setAmount(-damageGiven);
        reciveRecentDemage = 600;
        endGame();
    }
    
    public void changeLife(int quantidade){
        lifeMax += quantidade;
        getWorld().getObjects(HUDLife.class).get(0).setAmount(lifeMax);
    }
    
    public void regenLife(){
        if(reciveRecentDemage > 0){
            reciveRecentDemage--;
        }
        if(regenCooldown > 0){
            regenCooldown--;
        } else if(regenCooldown == 0 && lifeMax + 1 >= life && reciveRecentDemage == 0){
            getWorld().getObjects(HUDLife.class).get(0).setAmount(10);
            life +=10;
            regenCooldown = 1800;
        }
    }
    
    public void gainXp(int quantidade){
        xp += quantidade * xpIncrease;
        getWorld().getObjects(HUDXp.class).get(0).setAmount(xp);
    }
    
    public void gainXpIncrease(int quantidade){
        xpIncrease += quantidade;
    }
    
    public static void secretIncrease(){
        xpPoint = 30;
    }
    
    public void upLevel(){
        if( xp >= 100 + xpDificult && xpLevel < 30){
            xpLevel++;
            xpPoint++;
            if(xpLevel > 20){
                xpDificult += 3500;
            }
            if(xpLevel > 15 && xpLevel < 20){
                xpDificult += 2000;
            }
            if(xpLevel > 10 && xpLevel < 15){
                xpDificult += 1500;
            }
            if(xpLevel > 5 && xpLevel < 10){
                xpDificult += 1000;
            }
            else{
                xpDificult += 100;
            }
            xp = 0;
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.getObjects(HUDXp.class).get(0).resetHud(xpDificult);
            myWorld.addObject(new Warning("notEnoughCoins"), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
        }
    }
    
    public static int getXpPoint(){
        return xpPoint;
    }
    
    public static int getXpLevel(){
        return xpLevel;
    }
    
    public static int getLife(){
        return life;
    }
    
    public static void setXpPoint(){
        xpPoint -= 1;
    }
    
    public void upgradePickaxe(){
        pickaxeLevel++;
        if(pickaxeLevel <= 3){
            damageCapability += 25;
            damageCapabilityMobs += 25;
        } else if(pickaxeLevel == 4){
            damageCapability += 75;
            damageCapabilityMobs += 75;
        } else if(pickaxeLevel == 5){
            damageCapability += 125;
            damageCapabilityMobs += 125;
        }
    }
    
    public int getPickaxeLevel(){
        return pickaxeLevel;
    }
    
    public int getBackpackLevel(){
        return backpackLevel;
    }
    
    public void upgradeBackpack(){
        backpackLevel++;
    }
    
    public void increaseSpeed(){
        speed++;
    }
    
    public void increaseHarvestLevel(){
        damageCapability += 25;
    }
    
    public void increaseDamageLevel(){
        damageCapabilityMobs += 25;
    }
    
    public void endGame(){
        if(life <= 0){
            Greenfoot.setWorld(new GameOverWorld());        
        }
    }
}
