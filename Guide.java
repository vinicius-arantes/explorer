import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guide extends Actor
{
    private int page;
    
    public Guide(){
        page = 1;
    }
    
    /**
     * Act - do whatever the Guide wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("escape")){
            getWorld().removeObject(this);
        }
        changePage();
    }
    
    public void changePage(){
        if(Greenfoot.isKeyDown("right") && page != 7){
            page++;
            setImage("guia" + page + ".png");
            Greenfoot.delay(10);
        } else if(Greenfoot.isKeyDown("left") && page != 1){
            page--;
            setImage("guia" + page + ".png");
            Greenfoot.delay(10);
        }
    }
}
