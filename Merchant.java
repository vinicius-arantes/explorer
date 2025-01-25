import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Merchant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merchant extends Actor
{
    private int timeCounting;
    private int walkAmountX;
    private int walkAmountY;
    private int alreadyWalked;
    private int walkDirection;
    private int HUDDelay;
    
    public Merchant(){
        timeCounting = 0;
        walkAmountX = 0;
        walkAmountY = 0;
        alreadyWalked = 0;
        walkDirection = 2;
        HUDDelay = 0;
    }
    
    /**
     * Act - do whatever the Merchant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timeCounting++;
        movimentar();
        colisions();
        openUpgradeHUD();
        if(HUDDelay > 0){
            HUDDelay--;
        }
    }
    
    public void movimentar() {
        if(timeCounting >= 1000){
            walkAmountX = Greenfoot.getRandomNumber((120 - 5) + 1) + 5;
            walkAmountY = Greenfoot.getRandomNumber((100 - 2) + 1) + 2;
            walkDirection = Greenfoot.getRandomNumber((4 - 1) + 1) + 1;
            
            timeCounting = 0;
            alreadyWalked = 0;
        }
        
        if(alreadyWalked <= walkAmountX){
            if(walkDirection == 1){
                setLocation(getX(), getY() - 1); // Move para cima
                setLocation(getX() - 1, getY()); // Move para a esquerda
            }
            if(walkDirection == 2){
                setLocation(getX(), getY() - 1); // Move para cima
                setLocation(getX() + 1, getY()); // Move para a direita
            }
            if(walkDirection == 3){
                setLocation(getX(), getY() + 1); // Move para baixo
                setLocation(getX() - 1, getY()); // Move para a esquerda
            }
            if(walkDirection == 4){
                setLocation(getX(), getY() + 1); // Move para baixo
                setLocation(getX() + 1, getY()); // Move para a direita
            }
            alreadyWalked++;
        }
        
        if (walkDirection == 2 || walkDirection == 4) {
            setImage("merchant.png");
        } else{
            setImage("merchantLeft.png");
        }
    }
    
    public void colisions(){
        List<Border> intersectingObjects = getIntersectingObjects(Border.class);
        if(!intersectingObjects.isEmpty()){
            if(walkDirection == 1){
                setLocation(getX(), getY() + 1); // Move para cima
                setLocation(getX() + 1, getY()); // Move para a esquerda
            }
            if(walkDirection == 2){
                setLocation(getX(), getY() + 1); // Move para cima
                setLocation(getX() - 1, getY()); // Move para a direita
            }
            if(walkDirection == 3){
                setLocation(getX(), getY() - 1); // Move para baixo
                setLocation(getX() + 1, getY()); // Move para a esquerda
            }
            if(walkDirection == 4){
                setLocation(getX(), getY() - 1); // Move para baixo
                setLocation(getX() - 1, getY()); // Move para a direita
            }
        }
    }
    
    public void openUpgradeHUD(){
        List<Explorer> intersectingObjects = getIntersectingObjects(Explorer.class);
        List<MerchantHUD> intersectingHUDs = getWorld().getObjects(MerchantHUD.class);
        if(!intersectingObjects.isEmpty() && intersectingHUDs.isEmpty() && HUDDelay == 0){
            getWorld().addObject(new MerchantHUD(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            setLocation(600, 375);
            HUDDelay = 1500;
        }
    }
}
