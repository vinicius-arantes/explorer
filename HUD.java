import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    private double amount;
    private String type;
    private int total;
    private int level;
    
    public HUD(int amount, String type){
        this.amount = amount;
        this.type = type;
        total = 100;
        level = 0;
    }
    
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public void resetHud(int xpDificultIncrease){
        amount -= total;
        total += xpDificultIncrease;
        int intAmout = (int) ((amount/total) * 100);
        
        if(intAmout < 0){
            intAmout = 0;
        }
        
        if(intAmout <= 100 && intAmout > 95){
            setImage(type + "100.png");
        } else if(intAmout <= 95 && intAmout > 85){
            setImage(type + "90.png");
        } else if(intAmout <= 85 && intAmout > 75){
            setImage(type + "80.png");
        } else if(intAmout <= 75 && intAmout > 65){
            setImage(type + "70.png");
        } else if(intAmout <= 65 && intAmout > 55){
            setImage(type + "60.png");
        } else if(intAmout <= 55 && intAmout > 45){
            setImage(type + "50.png");
        } else if(intAmout <= 45 && intAmout > 35){
            setImage(type + "40.png");
        } else if(intAmout <= 35 && intAmout > 25){
            setImage(type + "30.png");
        } else if(intAmout <= 25 && intAmout > 15){
            setImage(type + "20.png");
        } else if(intAmout <= 15 && intAmout > 0){
            setImage(type + "10.png");
        } else if(intAmout == 0){
            setImage(type + "0.png");
        }
    }
    
    public void setAmount(int adicionar)
    {
        amount += adicionar;
        int intAmout = (int) ((amount/total) * 100);
        if(intAmout < 0){
            intAmout = 0;
        }
        
        if(intAmout <= 100 && intAmout > 95){
            setImage(type + "100.png");
        } else if(intAmout <= 95 && intAmout > 85){
            setImage(type + "90.png");
        } else if(intAmout <= 85 && intAmout > 75){
            setImage(type + "80.png");
        } else if(intAmout <= 75 && intAmout > 65){
            setImage(type + "70.png");
        } else if(intAmout <= 65 && intAmout > 55){
            setImage(type + "60.png");
        } else if(intAmout <= 55 && intAmout > 45){
            setImage(type + "50.png");
        } else if(intAmout <= 45 && intAmout > 35){
            setImage(type + "40.png");
        } else if(intAmout <= 35 && intAmout > 25){
            setImage(type + "30.png");
        } else if(intAmout <= 25 && intAmout > 15){
            setImage(type + "20.png");
        } else if(intAmout <= 15 && intAmout > 0){
            setImage(type + "10.png");
        } else if(intAmout == 0){
            setImage(type + "0.png");
        }
    }
}
