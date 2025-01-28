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
        hudVisible = false;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
    }

    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("marketHUD.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
        // Atualiza a HUD
        updateHUD();
    }

    public void updateHUD() {
        // Cria a imagem base do HUD
        GreenfootImage imagem = new GreenfootImage("marketHUD.png");

        // Adiciona a imagem do slot selecionado
        String selectedImageName = "selected-" + selected + ".png";
        GreenfootImage selectedImage = new GreenfootImage(selectedImageName);
        imagem.drawImage(selectedImage, 0, 0); // Posiciona a imagem do slot selecionado no HUD
        
        GreenfootImage textoLog = new GreenfootImage("" + Inventory.getLog(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage madeiraIcon = new GreenfootImage("madeiraIcon.png");
        imagem.drawImage(madeiraIcon, 99, 90);
        imagem.drawImage(textoLog, 120, 108);

        // Adiciona o texto do número de Stone
        GreenfootImage textoStone = new GreenfootImage("" + Inventory.getStone(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage stoneIcon = new GreenfootImage("rock.png");
        imagem.drawImage(stoneIcon, 155, 90);
        imagem.drawImage(textoStone, 176, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("" + Inventory.getCopperOre(), 15, Color.WHITE,new Color(0, 0, 0, 0));
        GreenfootImage cobreOreIcon = new GreenfootImage("cobreItem.png");
        imagem.drawImage(cobreOreIcon, 218, 90);
        imagem.drawImage(textoCopperOre, 238, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper
        GreenfootImage textoCopper = new GreenfootImage("" + Inventory.getCopper(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage cobreIcon = new GreenfootImage("cobreBarra.png");
        imagem.drawImage(cobreIcon, 273, 90);
        imagem.drawImage(textoCopper, 293, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("" + Inventory.getTinOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage tinOreIcon = new GreenfootImage("timItem.png");
        imagem.drawImage(tinOreIcon, 335, 90);
        imagem.drawImage(textoTinOre, 355, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin
        GreenfootImage textoTin = new GreenfootImage("" + Inventory.getTin(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage tinIcon = new GreenfootImage("timBarra.png");
        imagem.drawImage(tinIcon, 387, 90);
        imagem.drawImage(textoTin, 407, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("" + Inventory.getBronze(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage bronzeIcon = new GreenfootImage("cobreBarra.png");
        imagem.drawImage(bronzeIcon, 99, 145);
        imagem.drawImage(textoBronze, 120, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("" + Inventory.getIronOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage ironOreIcon = new GreenfootImage("ferroItem.png");
        imagem.drawImage(ironOreIcon, 162, 145);
        imagem.drawImage(textoIronOre, 182, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Iron
        GreenfootImage textoIron = new GreenfootImage("" + Inventory.getIron(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage ironIcon = new GreenfootImage("ferroBarra.png");
        imagem.drawImage(ironIcon, 218, 145);
        imagem.drawImage(textoIron, 238, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("" + Inventory.getGoldOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage goldOreIcon = new GreenfootImage("ouroItem.png");
        imagem.drawImage(goldOreIcon, 277, 145);
        imagem.drawImage(textoGoldOre, 297, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold
        GreenfootImage textoGold = new GreenfootImage("" + Inventory.getGold(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage goldIcon = new GreenfootImage("ouroBarra.png");
        imagem.drawImage(goldIcon, 335, 145);
        imagem.drawImage(textoGold, 355, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Couro
        GreenfootImage textoLeather = new GreenfootImage("" + Inventory.getLeather(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage couroIcon = new GreenfootImage("leather.png");
        imagem.drawImage(couroIcon, 387, 145);
        imagem.drawImage(textoLeather, 407, 160);

        // Define a nova imagem com tudo desenhado
        setImage(imagem);
    }

    public void handleHUDToggle() {
        if (Market.getOpenMarket()) {
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
                HUDCoins.setCoin(5);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 2 && Inventory.getStone() > 0){
                Inventory.takeItenStone(-1);
                HUDCoins.setCoin(7);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 3 && Inventory.getCopperOre() > 0){
                Inventory.takeItenCopperOre(-1);
                HUDCoins.setCoin(25);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 4 && Inventory.getCopper() > 0){
                Inventory.takeItenCopper(-1);
                HUDCoins.setCoin(35);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }   
            
            if (selected == 5 && Inventory.getTinOre() > 0){
                Inventory.takeItenTinOre(-1);
                HUDCoins.setCoin(25);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(10);
            }
            
            if (selected == 6 && Inventory.getTin() > 0){
                Inventory.takeItenTin(-1);
                HUDCoins.setCoin(35);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 7 && Inventory.getBronze() > 0){
                Inventory.takeItenBronze(-1);
                HUDCoins.setCoin(160);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 8 && Inventory.getIronOre() > 0){
                Inventory.takeItenIronOre(-1);
                HUDCoins.setCoin(65);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(10);
            }
            
            if (selected == 9 && Inventory.getIron() > 0){
                Inventory.takeItenIron(-1);
                HUDCoins.setCoin(130);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 10 && Inventory.getGoldOre() > 0){
                Inventory.takeItenGoldOre(-1);
                HUDCoins.setCoin(100);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }   
            
            if (selected == 11 && Inventory.getGold() > 0){
                Inventory.takeItenGold(-1);
                HUDCoins.setCoin(280);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
            
            if (selected == 12 && Inventory.getLeather() > 0){
                Inventory.takeItenLeather(-1);
                HUDCoins.setCoin(20);
                Greenfoot.playSound("buying.mp3");
                Greenfoot.delay(1);
            }
        }
    }
}

