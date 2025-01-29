import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Write a description of class FurnaceHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FurnaceHUD extends Actor
{
    private boolean hudVisible;
    private boolean isDoneSmelting;
    private boolean isEnterPressed;
    private int selected = 1;
    private int timePass;
    private int smelTime;
    private int itensGive;
    private HashMap<String, Boolean> smeltingStates = new HashMap<>();
    
    public FurnaceHUD() {
        setImageInitial();
        hudVisible = false;
        isDoneSmelting = false;
        smeltingStates.put("copper", false);
        smeltingStates.put("tin", false);
        smeltingStates.put("bronze", false);
        smeltingStates.put("iron", false);
        smeltingStates.put("gold", false);
        timePass = 0;
        smelTime = 0;
        itensGive = 0;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
    }
    
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
        if(Furnace.getonOrOff()){
                smeltingTime();
            }
        if(Furnace.getonOrOff() == false){
                doneSmelting();
            }
        if (hudVisible) {
            updateHUD();
            moveSlots();
            smeltingItem();
        }
    }

    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("furnace-HUD.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
        // Atualiza a HUD
        updateHUD();
    }

    public void updateHUD() {
        // Cria a imagem base do HUD
        GreenfootImage imagem = new GreenfootImage("furnace-HUD.png");

        // Adiciona a imagem do slot selecionado
        ///String selectedImageName = "Fselected-" + selected + ".png";
        ///GreenfootImage selectedImage = new GreenfootImage(selectedImageName);
        ///imagem.drawImage(selectedImage, 0, 0); // Posiciona a imagem do slot selecionado no HUD
        
        // Adiciona o texto do número de Log
        GreenfootImage textoLog = new GreenfootImage("Troncos Disponiveis " + Inventory.getLog(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLog, 200, 200); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("MCobres: " + Inventory.getCopperOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopperOre, 80, 365); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("MEstanhos: " + Inventory.getTinOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTinOre, 140, 365); // Posiciona o texto no HUD
    
        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("Bronzes: " + Inventory.getBronze(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 200, 365); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("MFerros: " + Inventory.getIronOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIronOre, 260, 365); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("MOuro: " + Inventory.getGoldOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGoldOre, 320, 365); // Posiciona o texto no HUD

        // Define a nova imagem com tudo desenhado
        setImage(imagem);
    }

    public void handleHUDToggle() {
        if (Furnace.getOpenFurnace()) {
            hudVisible = true;
            setImageInitial();
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.removeObject(this);
            myWorld.addObject(this, myWorld.getWidth() / 2, myWorld.getHeight() / 2);
        } else {
            hudVisible = false;
            setImage((GreenfootImage) null); // Esconde o HUD
            }
    }
    
    public void moveSlots(){
        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && hudVisible){
            if (selected < 12){ 
                selected++;
                Greenfoot.delay(10);
            }
        }
    
        if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && hudVisible){
             if (selected > 1){ 
                selected--;
                Greenfoot.delay(10);
            }
        }
    
        if((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) && hudVisible && selected + 6  < 13){
         selected += 6;
         Greenfoot.delay(10);
        }
    
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && hudVisible && selected - 6 > 0){
         selected -= 6;
         Greenfoot.delay(10);
        }
    }
    
    public void smeltingTime(int time){
        smelTime += time;
        Furnace.onOrOff(0);
    }
    
    public void smeltingTime(){
        timePass++;
        //smelTime *= 1;
        if(timePass >= smelTime){  
            timePass = 0;
            smelTime = 0;
            Furnace.onOrOff(1);
            isDoneSmelting = true;
        }
    }
    
    // Método para controlar smelting de diferentes itens
    public void smeltingItem() {
        if (selected == 1 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && !isEnterPressed) {
            isEnterPressed = true;
            trySmelting(Inventory.getCopperOre(), Inventory.getLog(), 1, "copper");
        }
        if (selected == 2 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && !isEnterPressed) {
            isEnterPressed = true;
            trySmelting(Inventory.getTinOre(), Inventory.getLog(), 2, "tin");
        }
        if (selected == 3 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && !isEnterPressed) {
            isEnterPressed = true;
            trySmelting(Inventory.getTinOre(), Inventory.getLog(), 3, "bronze");
        }
        if (selected == 4 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && !isEnterPressed) {
            isEnterPressed = true;
            trySmelting(Inventory.getIronOre(), Inventory.getLog(), 4, "iron");
        }
        if (selected == 5 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")) && !isEnterPressed) {
            isEnterPressed = true;
            trySmelting(Inventory.getGoldOre(), Inventory.getLog(), 8, "gold");
        } else if(Greenfoot.isKeyDown("enter") == false && Greenfoot.isKeyDown("space") == false){
            isEnterPressed = false;
        }
    }

    // Método auxiliar para tentar smelting
    private void trySmelting(int oreCount, int logCount, int requiredLogs, String smeltingType) {
        if (oreCount >= 1 && logCount >= requiredLogs) {
            if(smeltingType == "copper" && (!Furnace.getonOrOff() || smeltingStates.get("copper"))){
                smeltingStates.put("copper", true);
                Inventory.takeItenLog(-requiredLogs);
                itensGive++;
                Inventory.takeItenCopperOre(-1);
                smeltingTime(100);
            }
            if(smeltingType == "tin" && (!Furnace.getonOrOff() || smeltingStates.get("tin"))){
                smeltingStates.put("tin", true);
                Inventory.takeItenLog(-requiredLogs);
                itensGive++;
                Inventory.takeItenTinOre(-1);
                smeltingTime(900);
            }
            if(smeltingType == "bronze" && Inventory.getCopperOre() >= 3 && Inventory.getTinOre() >= 1 && (!Furnace.getonOrOff() || smeltingStates.get("bronze"))){
                smeltingStates.put("bronze", true);
                Inventory.takeItenLog(-requiredLogs);
                itensGive++;
                Inventory.takeItenCopperOre(-3);
                Inventory.takeItenTinOre(-1);
                smeltingTime(480);
            }
            if(smeltingType == "iron" && (!Furnace.getonOrOff() || smeltingStates.get("iron"))){
                smeltingStates.put("iron", true);
                Inventory.takeItenLog(-requiredLogs);
                itensGive++;
                Inventory.takeItenIronOre(-1);
                smeltingTime(1320 );
            }
            if(smeltingType == "gold" && (!Furnace.getonOrOff() || smeltingStates.get("gold"))){
                smeltingStates.put("gold", true);
                Inventory.takeItenLog(-requiredLogs);
                itensGive++;
                Inventory.takeItenGoldOre(-1);
                smeltingTime(1800 );
            }
        }
    }
    
    private void doneSmelting(){
        String smeltingType = "";
        if (isDoneSmelting) {
            if(smeltingStates.get("copper")){
                Inventory.takeItenCopper(itensGive);
                smeltingType = "copper";
            }
            if(smeltingStates.get("tin")){
                Inventory.takeItenCopper(itensGive);
                smeltingType = "tin";
            }
            if(smeltingStates.get("bronze")){
                Inventory.takeItenCopper(itensGive);
                smeltingType = "bronze";
            }   
            if(smeltingStates.get("iron")){
                Inventory.takeItenCopper(itensGive);
                smeltingType = "iron";
            }
            if(smeltingStates.get("gold")){
                Inventory.takeItenCopper(itensGive);
                smeltingType = "gold";
            }
            
            itensGive = 0;
            isDoneSmelting = false;
            resetSmelting(smeltingType);
            smeltingType = "";
        }
    }
    
    private void resetSmelting(String smeltingType) {
        switch (smeltingType) {
            case "copper":
                smeltingStates.put("copper", false);
                break;
            case "tin":
                smeltingStates.put("tin", false);
                break;
            case "bronze":
                smeltingStates.put("bronze", false);
                break;
            case "iron":
                smeltingStates.put("iron", false);
                break;
            case "gold":
                smeltingStates.put("gold", false);
                break;
        }
    }
    
}
