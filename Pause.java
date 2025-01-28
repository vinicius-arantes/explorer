import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pause extends Actor
{
    private static boolean gamePause;
    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Pause(){
        gamePause = true;
    }
    
    public static void setGamePause(int value){
        if(value == 1){
            gamePause = true;
        }
        else{
            gamePause = false;
        }
    }
    
    public static boolean getGamePause(){
        return gamePause;
    }
}
