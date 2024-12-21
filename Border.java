import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Border here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Border extends Actor
{
    private String biomeName;
    public Border(String biomeName){
        this.biomeName = biomeName;
        GreenfootImage image = getImage();  
        image.scale(1, 250);
        image.setTransparency(0);
        setImage(image);
    }
    /**
     * Act - do whatever the Border wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    public String getName(){
        return biomeName;
    }
}
