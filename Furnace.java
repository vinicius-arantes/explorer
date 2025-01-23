import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Furnace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Furnace extends Actor
{
    private boolean wasTouching = false;
    private static boolean openFurnace = false;
    
    public void act() {
        boolean isCurrentlyTouching = isTouching(Explorer.class);
        if (isCurrentlyTouching && !wasTouching) {
            openFurnace = true;
        } else if (!isCurrentlyTouching && wasTouching) {
            openFurnace = false;
        }
        wasTouching = isCurrentlyTouching;
    }
    
    public static boolean getOpenFurnace(){
        return openFurnace;
    }
}
