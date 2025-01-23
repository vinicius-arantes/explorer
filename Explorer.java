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
    private static int xp;
    private static int xpIncrease;
    private static int xpDificult;
    private static int xpLevel;
    private static int xpPoint;
    
    public Explorer(){
        damageCapability = 25;
        xp = 0;
        xpIncrease = 1;
        xpDificult = 0;
        xpLevel = 1;
        xpPoint = 0;
    }
    
    /**
     * Act - do whatever the Explorer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        colisions();
        openGuide();
        upLevel();
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
            setLocation(getX(), getY() - 2); // Move para cima
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 2); // Move para baixo
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 2, getY()); // Move para a esquerda
            setImage("mainCharac.png");
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 2, getY()); // Move para a direita
            setImage("mainCharacRight.png");
        }
    }
    
    public void colisions(){
        if(haveIntersectingObjects()){
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() + 2); // Nega o movimento pra cima
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() - 2); // Nega o movimento pra baixo
            }
            if (Greenfoot.isKeyDown("a")) {
                setLocation(getX() + 2, getY()); // Nega o movimento pra esquerda
            }
            if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() - 2, getY()); // Nega o movimento pra direita
            }
        }
    }
    
    public boolean haveIntersectingObjects(){
        Actor border = getOneIntersectingObject(Border.class);
        Actor tree = getOneIntersectingObject(Tree.class);
        Actor stone = getOneIntersectingObject(Stone.class);
        if(border != null || tree != null || stone != null){
            return true;
        }
        return false;
    }
    
    public int getDamageCapability(){
        return damageCapability;
    }
    
    public void gainXp(int quantidade){
        xp += quantidade * xpIncrease;
    }
    
    public void gainXpIncrease(int quantidade){
        xpIncrease += quantidade;
    }
    
    public void upLevel(){
        if( xp == 100 + xpDificult && xpLevel < 30){
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
        }
    }
}
