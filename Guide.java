import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guide extends Actor
{
    private boolean visible;
    private int page;
    
    public Guide(){
        visible = true;
        page = 1;
    }
    
    /**
     * Act - do whatever the Guide wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("h") && !visible) {
            getImage().setTransparency(240);
            visible = true;
        } else if(Greenfoot.isKeyDown("escape") && visible){
            getImage().setTransparency(0);
            visible = false;
        }
        changePage();
    }
    
    public void changePage(){
        if(Greenfoot.isKeyDown("right") && visible && page != 9){
            page++;
            setImage("guia" + page + ".png");
            Greenfoot.delay(10);
        } else if(Greenfoot.isKeyDown("left") && visible && page != 1){
            page--;
            setImage("guia" + page + ".png");
            Greenfoot.delay(10);
        }
    }
}
