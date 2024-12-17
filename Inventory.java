import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    private int Log;
    private int Stone;
    private int Copper;
    private int Tin;
    private int Bronze;
    private int Iron;
    
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        updateHUD();
    }
    
    public Inventory()
    {
        setImageInitial();
        Log = 0;
        Stone = 0;
        Copper = 0;
        Tin = 0;
        Bronze = 0;
        Iron = 0;
    }
    
    public void setImageInitial()
    {
        //Cria o HUD
        GreenfootImage imagem = new GreenfootImage("HUD.png");
        // Redimensiona o HUD
        imagem.scale(320,150);
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
    }
    
    public void updateHUD()
    {
        // Cria a imagem do HUD
        GreenfootImage imagem = new GreenfootImage("HUD.png");
        imagem.scale(320, 150);
        imagem.setTransparency(240);

        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("Bronze: " + Bronze, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 20, 20); // Posiciona o texto no HUD

        // Define a nova imagem
        setImage(imagem);
    }
    
    public void takeItenLog()
    {
        Log++;
    }
    
    public void takeItenStone()
    {
        Stone++;
    }
    
    public void takeItenCopper()
    {
        Copper++;
    }
    
    public void takeItenTin()
    {
        Tin++;
    }
    
    public void takeItenBronze()
    {
        Bronze++;
    }
    
    public void takeItenIron()
    {
        Iron++;
    }
    
}
