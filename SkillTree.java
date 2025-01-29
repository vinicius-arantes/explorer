import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkillTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillTree extends Actor
{
    private int selected = 6;
    private int unlocked3;
    private int unlocked5;
    private int unlocked7;
    private int unlocked9;
    private boolean unlocked1;
    private boolean unlocked2;
    private boolean unlocked4;
    private boolean unlocked6;
    private boolean unlocked8;
    private boolean unlocked10;
    private boolean unlocked11;
    private boolean hudVisible;
    private boolean isJPressed;
    private Pet pet;
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
        unlocked3 = 0;
        unlocked5 = 0;
        unlocked7 = 0;
        unlocked9 = 0;
        unlocked1 = false;
        unlocked2 = false;        
        unlocked4 = false;        
        unlocked6 = false;       
        unlocked8 = false;
        unlocked10 = false;
        unlocked11 = false;
        isJPressed = false;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
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
        if (Greenfoot.isKeyDown("j") && !isJPressed) {
            hudVisible = !hudVisible; // Alterna o estado
            isJPressed = true;
            if(Pause.getGamePause()){
                Pause.setGamePause(0);
            }
            else{
                Pause.setGamePause(1);
            }
            if (hudVisible) {
                setImageInitial();
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.removeObject(this);
                myWorld.addObject(this, myWorld.getWidth() / 2, myWorld.getHeight() / 2);
            } else {
                setImage((GreenfootImage) null); // Oculta o HUD
            }
        } else if (Greenfoot.isKeyDown("j") == false && Greenfoot.isKeyDown("escape") == false){
            isJPressed = false;
        }
        if(hudVisible && Greenfoot.isKeyDown("escape")){
                setImage((GreenfootImage) null); // Oculta o HUD
                hudVisible = false;
                if(Pause.getGamePause()){
                    Pause.setGamePause(0);
                }
                else{
                    Pause.setGamePause(1);
                }
        }
    }
    
    public void moveSlots(){
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") && hudVisible){
            if (selected < 11){ 
                selected++;
                Greenfoot.delay(8);
                }
        }
    
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a") && hudVisible){
             if (selected > 1){ 
                selected--;
                Greenfoot.delay(8);
                }
        }
    
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") && hudVisible){
             if (selected + 3 > 11) {
                selected = 11;
                Greenfoot.delay(8);
            } 
            else {
                selected += 3;
                Greenfoot.delay(8);
            }
        }
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") && hudVisible){
             if (selected - 3 < 1) {
                selected = 1;
                Greenfoot.delay(8);
            }   else {
                selected -= 3;
                Greenfoot.delay(8);
            }
        }
    }
        
    
    public void skillUptade(){ 
        Explorer explorer = getWorld().getObjects(Explorer.class).get(0);
        if(selected == 6 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked6 == false){
            Greenfoot.playSound("buying.mp3");
            getWorld().addObject(new Merchant(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            
            Explorer.setXpPoint();
            unlocked6 = true;
         }
        
        //Precisam do 6 para serem desbloqueados
        if(selected == 3 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space"))  && Explorer.getXpPoint() > 0 && unlocked6 && unlocked3 < 5){
            Greenfoot.playSound("buying.mp3");
            explorer.increaseHarvestLevel();
            Explorer.setXpPoint();
            unlocked3++;
        }
        
        if(selected == 7 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked6 && unlocked7 < 5){
            Greenfoot.playSound("buying.mp3");
            explorer.increaseSpeed();
            Explorer.setXpPoint();
            unlocked7++;
        }
        
        if(selected == 9 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked6 && unlocked9 < 5){
            Greenfoot.playSound("buying.mp3");
            explorer.increaseDamageLevel();
            Explorer.setXpPoint();
            unlocked9++;
        }
        
        if(selected == 5 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked6 && unlocked5 < 5){
            Greenfoot.playSound("buying.mp3");
            explorer.changeLife(25);
            Explorer.setXpPoint();
            unlocked5++;
        }
        
        //Precisam do 5 e 3 para serem desbloqueados
        if(selected == 2 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked5 > 1 && unlocked3 > 1&& unlocked2 == false){
            Greenfoot.playSound("buying.mp3");
            explorer.gainXpIncrease(2);
            Explorer.setXpPoint();
            unlocked2 = true;
        }
        
        //Precisam do 3 e 7 para serem desbloqueados
        if(selected == 4 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked3 > 1 && unlocked7 > 1&& unlocked4 == false){
            Greenfoot.playSound("buying.mp3");
            HUDCoins.setIncrease(0.2);
            Explorer.setXpPoint();
            unlocked4 = true;
        }
        
        //Precisam do 7 e 9 para serem desbloqueados
        if(selected == 10 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked7 > 1 && unlocked9 > 1&& unlocked10 == false){
            Greenfoot.playSound("buying.mp3");
            Island.increaseDiscount();
            Explorer.setXpPoint();
            unlocked10 = true;
        }
        
        //Precisam do 9 e 5 para serem desbloqueados
        if(selected == 8 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked9 > 1&& unlocked5 > 1&& unlocked8 == false){
            Greenfoot.playSound("buying.mp3");
            Mob.increaseDrop();
            Cow.increaseDrop();
            Explorer.setXpPoint();
            unlocked8 = true;
        }
        
        //Precisa do 8 para ser desbloqueado
        if(selected == 11 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked8 && unlocked11 == false){
            Greenfoot.playSound("buying.mp3");
            getWorld().addObject(new Pet(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            explorer.changeLife(25);
            Explorer.setXpPoint();
            unlocked11 = true;
        }
        
        //Precisa do 4 para ser desbloqueado
        if(selected == 1 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && Explorer.getXpPoint() > 0 && unlocked4 && unlocked1 == false){
            Greenfoot.playSound("buying.mp3");
            HUDCoins.rendaFixaOn();
            Explorer.setXpPoint();
            unlocked1 = true;
        }
    }
}
