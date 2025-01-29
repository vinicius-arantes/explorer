import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Cow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cow extends Actor
{
    private int timeCounting;
    private int walkAmountX;
    private int walkAmountY;
    private int alreadyWalked;
    private int walkDirection;
    private int life;
    private static boolean increase;
    private Island spawnIsland;
    
    public Cow(Island island){
        timeCounting = 0;
        walkAmountX = 0;
        walkAmountY = 0;
        alreadyWalked = 0;
        walkDirection = 2;
        life = 100;
        spawnIsland = island;
        increase = false;
    }
    
    /**
     * Act - do whatever the Merchant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Pause.getGamePause() == false){
            timeCounting++;
            movimentar();
            colisions();
            if(life > 0){
                decreaseLife();
            } else {
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.addObject(new Leather(), getX()-5, getY()-2);
                if(increase){
                    myWorld.addObject(new Leather(), getX()-5, getY()-2);
                }
                myWorld.addObject(new Xp(100), getX() + 5, getY() + 3);
                spawnIsland.setCowCounting(-1);
                myWorld.removeObject(this);
            }
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
            setImage("cow.png");
        } else{
            setImage("cowLeft.png");
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
    
    public void decreaseLife(){
        if(Greenfoot.mouseClicked(this)){
            Explorer explorer = (Explorer) getWorld().getObjects(Explorer.class).get(0);
            double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
            if(distance < 50){
                life -= explorer.getDamageCapabilityMobs();
                if(life < 100 && life > 50){
                    setImage("cow.png");
                } else if (life < 75 && life > 25){
                    setImage("cow.png");
                } else if(life < 50 && life > 0){
                    setImage("cow.png");
                }
            }
        }
    }
    
    public static void increaseDrop(){
        increase = true;
    }
}
