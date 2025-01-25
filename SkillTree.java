import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkillTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillTree extends Actor
{
    private boolean hudVisible;
    private int selected = 6;
    private boolean unlocked1;
    private boolean unlocked2;
    private int unlocked3;
    private boolean unlocked4;
    private int unlocked5;
    private boolean unlocked6;
    private int unlocked7;
    private boolean unlocked8;
    private int unlocked9;
    private boolean unlocked10;
    private boolean unlocked11;
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
        if (hudVisible) {
            skillUptade();
            moveSlots();
            updateHUD();
        }
    }
    
    public SkillTree(){
        setImageInitial();
        hudVisible = false;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
        unlocked1 = false;
        unlocked2 = false;
        unlocked3 = 0;
        unlocked4 = false;
        unlocked5 = 0;
        unlocked6 = false;
        unlocked7 = 0;
        unlocked8 = false;
        unlocked9 = 0;
        unlocked10 = false;
        unlocked11 = false;
    }
    
    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("Sselected-6.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
    }
    
    public void updateHUD() {
        // Cria a imagem base do HUD
        GreenfootImage imagem = new GreenfootImage("Sselected-6.png");

        // Adiciona a imagem do slot selecionado
        String selectedImageName = "Sselected-" + selected + ".png";
        GreenfootImage selectedImage = new GreenfootImage(selectedImageName);
        imagem.drawImage(selectedImage, 0, 0); // Posiciona a imagem do slot selecionado no HUD
        
        // Define a nova imagem com tudo desenhado
        setImage(imagem);
    }
    
    public void handleHUDToggle() {
        if (Greenfoot.isKeyDown("j")) {
            hudVisible = !hudVisible; // Alterna o estado
            if (hudVisible) {
                setImageInitial();
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.removeObject(this);
                myWorld.addObject(this, myWorld.getWidth() / 2, myWorld.getHeight() / 2);
            } else {
                setImage((GreenfootImage) null); // Oculta o HUD
            }
            Greenfoot.delay(20); // Evita repetição rápida ao segurar a tecla
        }
    }
    
    public void moveSlots(){
        if(Greenfoot.isKeyDown("right") && hudVisible){
            if (selected < 11){ 
                selected++;
                Greenfoot.delay(10);
                }
        }
    
        if(Greenfoot.isKeyDown("left") && hudVisible){
             if (selected > 1){ 
                selected--;
                Greenfoot.delay(10);
                }
        }
    
        if(Greenfoot.isKeyDown("down") && hudVisible){
             if (selected + 3 > 11) {
                selected = 11;
                Greenfoot.delay(10);
            } 
            else {
                selected += 3;
                Greenfoot.delay(10);
            }
        }
        if(Greenfoot.isKeyDown("up") && hudVisible){
             if (selected - 3 < 1) {
                selected = 1;
                Greenfoot.delay(10);
            }   else {
                selected -= 3;
                Greenfoot.delay(10);
            }
        }
    }
        
    
    public void skillUptade(){ 
        if(selected == 6 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked6 == false){
            getWorld().addObject(new Merchant(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Explorer.setXpPoint();
            unlocked6 = true;
        }
        
        //Precisam do 6 para serem desbloqueados
        if(selected == 3 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked6 && unlocked3 < 5){
            
            Explorer.setXpPoint();
            unlocked3++;
        }
        
        if(selected == 7 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked6 && unlocked7 < 5){
            
            Explorer.setXpPoint();
            unlocked7++;
        }
        
        if(selected == 9 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked6 && unlocked9 < 5){
            
            Explorer.setXpPoint();
            unlocked9++;
        }
        
        if(selected == 5 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked6 && unlocked5 < 5){
            
            Explorer.setXpPoint();
            unlocked5++;
        }
        
        //Precisam do 5 e 3 para serem desbloqueados
        if(selected == 2 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked5 > 1 && unlocked3 > 1&& unlocked2 == false){
            
            Explorer.setXpPoint();
            unlocked2 = true;
        }
        
        //Precisam do 3 e 7 para serem desbloqueados
        if(selected == 4 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked3 > 1 && unlocked7 > 1&& unlocked4 == false){
            
            Explorer.setXpPoint();
            unlocked4 = true;
        }
        
        //Precisam do 7 e 9 para serem desbloqueados
        if(selected == 10 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked7 > 1 && unlocked9 > 1&& unlocked10 == false){
            
            Explorer.setXpPoint();
            unlocked10 = true;
        }
        
        //Precisam do 9 e 5 para serem desbloqueados
        if(selected == 8 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked9 > 1&& unlocked5 > 1&& unlocked8 == false){
            
            Explorer.setXpPoint();
            unlocked8 = true;
        }
        
        //Precisa do 8 para ser desbloqueado
        if(selected == 11 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked8 && unlocked11 == false){
            
            Explorer.setXpPoint();
            unlocked11 = true;
        }
        
        //Precisa do 4 para ser desbloqueado
        if(selected == 1 && Greenfoot.isKeyDown("enter") && Explorer.getXpPoint() > 0 && unlocked4 && unlocked1 == false){
            
            Explorer.setXpPoint();
            unlocked1 = true;
        }
    }
}
