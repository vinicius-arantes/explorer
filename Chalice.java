import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chalice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chalice extends Actor
{
    private String biomeType;
    private int orbAmount;
    private int totalAmount;
    private boolean isVisible;
    
    public Chalice(String biomeType, int totalAmount){
        this.biomeType = biomeType;
        this.totalAmount = totalAmount;
        orbAmount = 0;
        isVisible = true;
        if(!biomeType.contains("overworld")){
            GreenfootImage image = getImage();
            image.setTransparency(0);
            setImage(image);
            isVisible = false;
        }
    }
    
    /**
     * Act - do whatever the Chalice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        depositOrb();
        if(isFull() && isVisible){
            setImage(biomeType + "Chalice.png");
        } else if (!isFull() && isVisible) {
            updateHUD();
        }
    }
    
    public boolean isFull(){
        if(orbAmount >= totalAmount){
            return true;
        }
        return false;
    }
    
    public String getType(){
        return biomeType;
    }
    
    public void setVisibility(){
        isVisible = true;
    }
    
    public void depositOrb(){
        Explorer explorer = getWorld().getObjects(Explorer.class).get(0);
        double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
        if(distance < 80){
            if(Greenfoot.mouseClicked(this)){
                if(biomeType.contains("desert") && Inventory.getDesertOrb() > 0){
                    orbAmount++;
                    Inventory.setDesertOrb(-1);
                } else if(biomeType.contains("overworld") && Inventory.getOverworldOrb() > 0){
                    orbAmount++;
                    Inventory.setOverworldOrb(-1);
                } else if(biomeType.contains("tundra") && Inventory.getTundraOrb() > 0){
                    orbAmount++;
                    Inventory.setTundraOrb(-1);
                } else if(biomeType.contains("graveyard") && Inventory.getGraveyardOrb() > 0){
                    orbAmount++;
                    Inventory.setGraveyardOrb(-1);
                }
            }
        }
    }
    
    public void updateHUD(){
        GreenfootImage orbsAmountText = new GreenfootImage("" + orbAmount, 50, Color.WHITE, new Color(0, 0, 0, 0));

        GreenfootImage imagem = new GreenfootImage("offChalice.png");
    
        imagem.drawImage(orbsAmountText, 600, 375);

        setImage(imagem);
    }
}
