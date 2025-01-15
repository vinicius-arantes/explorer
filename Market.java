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
    
    public void act() {
        boolean isCurrentlyTouching = isTouching(Explorer.class);
        if (isCurrentlyTouching && !wasTouching) {
            openMarket = true;
        } else if (!isCurrentlyTouching && wasTouching) {
            openMarket = false;
        }
        wasTouching = isCurrentlyTouching;
    }
    
    public static boolean getOpenMarket(){
        return openMarket;
    }
}