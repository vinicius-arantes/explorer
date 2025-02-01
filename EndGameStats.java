import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGameStats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameStats extends Actor
{
    public EndGameStats() {
        updateImage(); // Chama a função para configurar a imagem inicial
    }
    
    public void act() {
        updateImage(); // Atualiza a imagem a cada frame
    }
    
    private void updateImage() {
        GreenfootImage imagem = new GreenfootImage("endGameStats.png"); // Preenchendo com preto
    
        GreenfootImage wholeTimePlayed = new GreenfootImage(Statistic.getTimePlayed(), 15, new Color(0x73, 0x3D, 0x26, 255), new Color(0, 0, 0, 0));
        imagem.drawImage(wholeTimePlayed, 105, 15);
        
        GreenfootImage wholeXP = new GreenfootImage(Statistic.getTotalXp(), 15, new Color(0x73, 0x3D, 0x26, 255), new Color(0, 0, 0, 0));
        imagem.drawImage(wholeXP, 108, 40);
        
        setImage(imagem);
    }
}
