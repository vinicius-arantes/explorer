import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Market here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Market extends Actor
{
    private boolean wasTouching = false;
    private static boolean openMarket = false;
    private Espaco espaco;
    public void act() {
        boolean isCurrentlyTouching = isTouching(Explorer.class);
        if (isCurrentlyTouching && !wasTouching) {
            int x = getX();
            int y = getY();
            espaco = new Espaco();
            getWorld().addObject(espaco, x, y - 50);
        } 
        
        if (!openMarket && isCurrentlyTouching && Greenfoot.isKeyDown("space")) {
            openMarket = true;
            getWorld().removeObject(espaco);
            espaco = null;
            togglePause();
        } else if (!isCurrentlyTouching && espaco != null) {
            getWorld().removeObject(espaco);
            espaco = null;
        }
        if(openMarket && Greenfoot.isKeyDown("escape")){
            openMarket = false;
            togglePause();
        }
        
        wasTouching = isCurrentlyTouching;
    }
    
    public void togglePause(){
        if(Pause.getGamePause()){
                Pause.setGamePause(0);
            }
            else{
                Pause.setGamePause(1);
            }
    }
    
    public static boolean getOpenMarket(){
        return openMarket;
    }
}