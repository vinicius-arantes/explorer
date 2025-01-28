import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Market here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Furnace extends Actor
{
    private boolean wasTouching = false;
    private static boolean openFurnace = false;
    private Espaco espaco;
    private static boolean onFurnace = false;
    private static boolean setted = false;
    public void act() {
        boolean isCurrentlyTouching = isTouching(Explorer.class);
        if (isCurrentlyTouching && !wasTouching) {
            int x = getX();
            int y = getY();
            espaco = new Espaco();
            getWorld().addObject(espaco, x, y - 50);
        } 
        
        if (!openFurnace && isCurrentlyTouching && Greenfoot.isKeyDown("space")) {
            openFurnace = true;
            getWorld().removeObject(espaco);
            espaco = null;
            togglePause();
        } else if (!isCurrentlyTouching && espaco != null) {
            getWorld().removeObject(espaco);
            espaco = null;
        }
        
        if(openFurnace && Greenfoot.isKeyDown("escape")){
            openFurnace = false;
            togglePause();
        }
        
        wasTouching = isCurrentlyTouching;
        onOff();
    }
    
    public void togglePause(){
        if(Pause.getGamePause()){
                Pause.setGamePause(0);
            }
            else{
                Pause.setGamePause(1);
            }
    }
    
    public static boolean getOpenFurnace(){
        return openFurnace;
    }
    
    public void onOff(){
        if(onFurnace && !setted){
            setted = true;
            GreenfootImage imagem = new GreenfootImage("fornalhaOn.png");
            setImage(imagem);
        }
        
        if(!onFurnace && !setted){
            setted = true;
            GreenfootImage imagem = new GreenfootImage("fornalhaOff.png");
            setImage(imagem);
        }
    }
    
    public static void onOrOff(int value){
        if(value == 0){
            onFurnace = false;
            setted = false;
        } else{
            onFurnace = true;
            setted = false;
        }
    }
}