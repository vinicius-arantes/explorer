import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MarketHUD extends Actor {
    private boolean hudVisible;
    private int selected = 1;
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
        if (hudVisible) {
            tradeItens();
            updateHUD();
            moveSlots();
        }
    }

    public MarketHUD() {
        setImageInitial();
        hudVisible = true;
    }

    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("inventory.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
        // Atualiza a HUD
        updateHUD();
    }

    public void updateHUD() {
        // Cria a imagem base do HUD
        GreenfootImage imagem = new GreenfootImage("inventory.png");

        // Adiciona a imagem do slot selecionado
        String selectedImageName = "selected-" + selected + ".png";
        GreenfootImage selectedImage = new GreenfootImage(selectedImageName);
        imagem.drawImage(selectedImage, 0, 0); // Posiciona a imagem do slot selecionado no HUD

        // Adiciona o texto do número de Log
        GreenfootImage textoLog = new GreenfootImage("Troncos: " + Inventory.getLog(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLog, 80, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Stone
        GreenfootImage textoStone = new GreenfootImage("Pedras: " + Inventory.getStone(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoStone, 140, 100); // Posiciona o texto no HUD
    
        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("MCobres: " + Inventory.getCopperOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopperOre, 200, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper
        GreenfootImage textoCopper = new GreenfootImage("Cobres: " + Inventory.getCopper(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopper, 260, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("MEstanhos: " + Inventory.getTinOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTinOre, 320, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin
        GreenfootImage textoTin = new GreenfootImage("Estanhos: " + Inventory.getTin(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTin, 380, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("Bronzes: " + Inventory.getBronze(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 80, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("MFerros: " + Inventory.getIronOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIronOre, 140, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Iron
        GreenfootImage textoIron = new GreenfootImage("Ferros: " + Inventory.getIron(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIron, 200, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("MOuro: " + Inventory.getGoldOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGoldOre, 260, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold
        GreenfootImage textoGold = new GreenfootImage("Ouro: " + Inventory.getGold(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGold, 320, 160); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Couro
        GreenfootImage textoLeather = new GreenfootImage("Couro: " + Inventory.getLeather(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLeather, 380, 160); // Posiciona o texto no HUD

        // Define a nova imagem com tudo desenhado
        setImage(imagem);
    }


        public void handleHUDToggle() {
        if (Market.getOpenMarket()) {
            if (!hudVisible) {
                hudVisible = true;
                setImageInitial(); // Atualiza e exibe o HUD
            }
        } 
        else {
            if (hudVisible) {
                hudVisible = false;
                setImage((GreenfootImage) null); // Esconde o HUD
            }
        }
    }
    
    public void moveSlots(){
        if(Greenfoot.isKeyDown("right") && hudVisible){
            if (selected < 12){ 
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
    
        if(Greenfoot.isKeyDown("down") && hudVisible && selected + 6  < 13){
         selected += 6;
         Greenfoot.delay(10);
        }
    
        if(Greenfoot.isKeyDown("up") && hudVisible && selected - 6 > 0){
         selected -= 6;
         Greenfoot.delay(10);
        }
    }
    
    public void tradeItens(){
        if(hudVisible && Greenfoot.isKeyDown("enter")){
            if (selected == 1 && Inventory.getLog() > 0){
                Inventory.takeItenLog(-1);
                HUDCoins.setCoin(10);
                Greenfoot.delay(10);
            }
            
            if (selected == 2 && Inventory.getStone() > 0){
                Inventory.takeItenStone(-1);
                HUDCoins.setCoin(10);
                Greenfoot.delay(10);
            }
            
            if (selected == 3 && Inventory.getCopperOre() > 0){
                Inventory.takeItenCopperOre(-1);
                HUDCoins.setCoin(15);
                Greenfoot.delay(10);
            }
            
            if (selected == 4 && Inventory.getCopper() > 0){
                Inventory.takeItenCopper(-1);
                HUDCoins.setCoin(30);
                Greenfoot.delay(10);
            }   
            
            if (selected == 5 && Inventory.getTinOre() > 0){
                Inventory.takeItenTinOre(-1);
                HUDCoins.setCoin(15);
                Greenfoot.delay(10);
            }
            
            if (selected == 6 && Inventory.getTin() > 0){
                Inventory.takeItenTin(-1);
                HUDCoins.setCoin(30);
                Greenfoot.delay(10);
            }
            
            if (selected == 7 && Inventory.getBronze() > 0){
                Inventory.takeItenBronze(-1);
                HUDCoins.setCoin(100);
                Greenfoot.delay(10);
            }
            
            if (selected == 8 && Inventory.getIronOre() > 0){
                Inventory.takeItenIronOre(-1);
                HUDCoins.setCoin(120);
                Greenfoot.delay(10);
            }
            
            if (selected == 9 && Inventory.getIron() > 0){
                Inventory.takeItenIron(-1);
                HUDCoins.setCoin(150);
                Greenfoot.delay(10);
            }
            
            if (selected == 10 && Inventory.getGoldOre() > 0){
                Inventory.takeItenGoldOre(-1);
                HUDCoins.setCoin(200);
                Greenfoot.delay(10);
            }   
            
            if (selected == 11 && Inventory.getGold() > 0){
                Inventory.takeItenGold(-1);
                HUDCoins.setCoin(250);
                Greenfoot.delay(10);
            }
            
            if (selected == 12 && Inventory.getLeather() > 0){
                Inventory.takeItenLeather(-1);
                HUDCoins.setCoin(100);
                Greenfoot.delay(10);
            }
        }
    }
}

