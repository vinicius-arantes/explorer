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

    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
    }
    
    public SkillTree(){
        setImageInitial();
        hudVisible = false;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
    }
    
    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("skills.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
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
}
