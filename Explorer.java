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
    
    public Explorer(){
        damageCapability = 20;
    }
    
    /**
     * Act - do whatever the Explorer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        colisions();
    }
    
    public void movimentar() {
        // Movimento com as setas do teclado
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 2); // Move para cima
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 2); // Move para baixo
        }
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 2, getY()); // Move para a esquerda
            setImage("mainCharac.png");
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 2, getY()); // Move para a direita
            setImage("mainCharacRight.png");
        }
    }
    
    public void colisions(){
        if(haveIntersectingObjects()){
            if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() + 2); // Nega o movimento pra cima
            }
            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                setLocation(getX(), getY() - 2); // Nega o movimento pra baixo
            }
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
                setLocation(getX() + 2, getY()); // Nega o movimento pra esquerda
            }
            if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
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
}
