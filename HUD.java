import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    private int amount;
    private String type;
    
    public HUD(int amount, String type){
        this.amount = amount;
        this.type = type;
    }
    
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount(int adicionar)
    {
        amount += adicionar;
        if(amount < 0){
            amount = 0;
        }
        
        if(amount <= 100 && amount > 90){
            setImage(type + amount + ".png");
        } else if(amount <= 90 && amount > 80){
            setImage(type + amount + ".png");
        } else if(amount <= 80 && amount > 70){
            setImage(type + amount + ".png");
        } else if(amount <= 70 && amount > 60){
            setImage(type + amount + ".png");
        } else if(amount <= 60 && amount > 50){
            setImage(type + amount + ".png");
        } else if(amount <= 50 && amount > 40){
            setImage(type + amount + ".png");
        } else if(amount <= 40 && amount > 30){
            setImage(type + amount + ".png");
        } else if(amount <= 30 && amount > 20){
            setImage(type + amount + ".png");
        } else if(amount <= 20 && amount > 10){
            setImage(type + amount + ".png");
        } else if(amount <= 10 && amount > 0){
            setImage(type + amount + ".png");
        } else if(amount == 0){
            setImage(type + amount + ".png");
        }
    }
}
