import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    private int log;
    private int stone;
    private int copper;
    private int tin;
    private int bronze;
    private int iron;
    private boolean hudVisible;
    
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleHUDToggle();
        if (hudVisible) {
            updateHUD();
        }
    }
    
    public Inventory()
    {
        setImageInitial();
        log = 0;
        stone = 0;
        copper = 0;
        tin = 0;
        bronze = 0;
        iron = 0;
        hudVisible = true;
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
        //Atualiza a HUD
        updateHUD();
    }
    
    public void updateHUD()
    {
        // Cria a imagem do HUD
        GreenfootImage imagem = new GreenfootImage("HUD.png");
        imagem.scale(320, 150);
        imagem.setTransparency(240);
        
        // Adiciona o texto do número de Log
        GreenfootImage textoLog = new GreenfootImage("Troncos: " + log, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLog, 20, 10); // Posiciona o texto no HUD
        // Adiciona o texto do número de Stone
        GreenfootImage textoStone = new GreenfootImage("Pedras: " + stone, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoStone, 20, 40); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Copper
        GreenfootImage textoCopper = new GreenfootImage("Cobres: " + copper, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopper, 100, 10); // Posiciona o texto no HUD
        // Adiciona o texto do número de Tin
        GreenfootImage textoTin = new GreenfootImage("Estanhos: " + tin, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTin, 100, 40); // Posiciona o texto no HUD
        // Adiciona o texto do número de Bronze
        
        GreenfootImage textoBronze = new GreenfootImage("Bronzes: " + bronze, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 200, 10); // Posiciona o texto no HUD
        // Adiciona o texto do número de Iron
        GreenfootImage textoIron = new GreenfootImage("Ferros: " + iron, 20, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIron, 200, 40); // Posiciona o texto no HUD
        
        
        
        
        

        // Define a nova imagem
        setImage(imagem);
    }
    
    public void handleHUDToggle()
    {
        if (Greenfoot.isKeyDown("e"))
        {
            hudVisible = !hudVisible; // Alterna o estado
            if (hudVisible) {
                setImageInitial();
            } else {
                setImage((GreenfootImage) null); // Oculta o HUD
            }
            Greenfoot.delay(10); // Evita repetição rápida ao segurar a tecla
        }
    }
    
    public void takeItenLog()
    {
        log++;
    }
    
    public void takeItenStone()
    {
        stone++;
    }
    
    public void takeItenCopper()
    {
        copper++;
    }
    
    public void takeItenTin()
    {
        tin++;
    }
    
    public void takeItenBronze()
    {
        bronze++;
    }
    
    public void takeItenIron()
    {
        iron++;
    }
    
}
