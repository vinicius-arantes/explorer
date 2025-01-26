import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inventory extends Actor {
    private static int log;
    private static int stone;
    private static int copper;
    private static int copperOre;
    private static int tin;
    private static int tinOre;
    private static int bronze;
    private static int iron;
    private static int ironOre;
    private static int gold;
    private static int goldOre;
    private static int leather;
    private static int overworldOrb;
    private static int desertOrb;
    private static int tundraOrb;
    private static int graveyardOrb;
    private boolean hudVisible;

    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
        if (hudVisible) {
            updateHUD();
        }
    }

    public Inventory() {
        setImageInitial();
        log = 0;
        stone = 0;
        copperOre = 0;
        copper = 0;
        tinOre = 0;
        tin = 0;
        bronze = 0;
        iron = 0;
        ironOre = 0;
        goldOre = 0;
        gold = 0;
        leather = 0;
        overworldOrb = 0;
        desertOrb = 0;
        tundraOrb = 0;
        graveyardOrb = 0;
        hudVisible = false;
        setImage((GreenfootImage) null); // Inicia com o HUD oculto
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
        // Cria a imagem do HUD
        GreenfootImage imagem = new GreenfootImage("inventory.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);

        // Adiciona o texto do número de Log
        GreenfootImage textoLog = new GreenfootImage("" + log, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage madeiraIcon = new GreenfootImage("madeiraIcon.png");
        imagem.drawImage(madeiraIcon, 99, 90);
        imagem.drawImage(textoLog, 120, 108);

        // Adiciona o texto do número de Stone
        GreenfootImage textoStone = new GreenfootImage("" + stone, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage stoneIcon = new GreenfootImage("rock.png");
        imagem.drawImage(stoneIcon, 155, 90);
        imagem.drawImage(textoStone, 176, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("" + copperOre, 15, Color.WHITE,new Color(0, 0, 0, 0));
        GreenfootImage cobreOreIcon = new GreenfootImage("cobreItem.png");
        imagem.drawImage(cobreOreIcon, 218, 90);
        imagem.drawImage(textoCopperOre, 238, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper
        GreenfootImage textoCopper = new GreenfootImage("" + copper, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage cobreIcon = new GreenfootImage("cobreBarra.png");
        imagem.drawImage(cobreIcon, 273, 90);
        imagem.drawImage(textoCopper, 293, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("" + tinOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage tinOreIcon = new GreenfootImage("timItem.png");
        imagem.drawImage(tinOreIcon, 335, 90);
        imagem.drawImage(textoTinOre, 355, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin
        GreenfootImage textoTin = new GreenfootImage("" + tin, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage tinIcon = new GreenfootImage("timBarra.png");
        imagem.drawImage(tinIcon, 387, 90);
        imagem.drawImage(textoTin, 407, 108); // Posiciona o texto no HUD

        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("" + bronze, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage bronzeIcon = new GreenfootImage("cobreBarra.png");
        imagem.drawImage(bronzeIcon, 99, 145);
        imagem.drawImage(textoBronze, 120, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("" + ironOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage ironOreIcon = new GreenfootImage("ferroItem.png");
        imagem.drawImage(ironOreIcon, 162, 145);
        imagem.drawImage(textoIronOre, 182, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Iron
        GreenfootImage textoIron = new GreenfootImage("" + iron, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage ironIcon = new GreenfootImage("ferroBarra.png");
        imagem.drawImage(ironIcon, 218, 145);
        imagem.drawImage(textoIron, 238, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("" + goldOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage goldOreIcon = new GreenfootImage("ouroItem.png");
        imagem.drawImage(goldOreIcon, 277, 145);
        imagem.drawImage(textoGoldOre, 297, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold
        GreenfootImage textoGold = new GreenfootImage("" + gold, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage goldIcon = new GreenfootImage("ouroBarra.png");
        imagem.drawImage(goldIcon, 335, 145);
        imagem.drawImage(textoGold, 355, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Couro
        GreenfootImage textoLeather = new GreenfootImage("" + leather, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage couroIcon = new GreenfootImage("leather.png");
        imagem.drawImage(couroIcon, 387, 145);
        imagem.drawImage(textoLeather, 407, 160); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de OverworldOrb
        GreenfootImage textoOverworldOrb = new GreenfootImage("" + overworldOrb, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage overworldOrbIcon = new GreenfootImage("overworldOrb.png");
        imagem.drawImage(overworldOrbIcon, 130, 217);
        imagem.drawImage(textoOverworldOrb, 145, 230);
        
        // Adiciona o texto do número de DesertOrb
        GreenfootImage textoDesertOrb = new GreenfootImage("" + desertOrb, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage desertOrbIcon = new GreenfootImage("desertOrb.png");
        imagem.drawImage(desertOrbIcon, 190, 217);
        imagem.drawImage(textoDesertOrb, 205, 230);
        
        // Adiciona o texto do número de TundraOrb
        GreenfootImage textoTundraOrb = new GreenfootImage("" + tundraOrb, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage TundraOrbIcon = new GreenfootImage("tundraOrb.png");
        imagem.drawImage(TundraOrbIcon, 245, 217);
        imagem.drawImage(textoTundraOrb, 260, 230);
        
        // Adiciona o texto do número de GraveyardOrb
        GreenfootImage textoGraveyardOrb = new GreenfootImage("" + graveyardOrb, 15, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage graveyardOrbIcon = new GreenfootImage("graveyardOrb.png");
        imagem.drawImage(graveyardOrbIcon, 300, 217);
        imagem.drawImage(textoGraveyardOrb, 315, 230);
        
        GreenfootImage xpLevel = new GreenfootImage("" + Explorer.getXpLevel(), 22, new Color(0x73, 0x3D, 0x26, 255) , new Color(0, 0, 0, 0));
        imagem.drawImage(xpLevel, 351, 264);
        
        GreenfootImage life = new GreenfootImage("" + Explorer.getLife(), 22, new Color(0x73, 0x3D, 0x26, 255) , new Color(0, 0, 0, 0));
        imagem.drawImage(life, 195, 264);
        
        // Define a nova imagem
        setImage(imagem);
    }

    public void handleHUDToggle() {
        if (Greenfoot.isKeyDown("e")) {
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

    public static void takeItenLog(int quantidade) {
        log += quantidade;
    }
    
    public static int getLog(){
        return log;
    }
    
    public static void takeItenStone(int quantidade) {
        stone += quantidade;
    }
    
    public static int getStone(){
        return stone;
    }
    
    public static void takeItenCopperOre(int quantidade) {
        copperOre += quantidade;
    }
    
    public static int getCopperOre(){
        return copperOre;
    }
    
    public static void takeItenCopper(int quantidade) {
        copper += quantidade;
    }
    
    public static int getCopper(){
        return copper;
    }
    
    public static void takeItenTinOre(int quantidade) {
        tinOre += quantidade;
    }
    
    public static int getTinOre(){
        return tinOre;
    }
    
    public static void takeItenTin(int quantidade) {
        tin += quantidade;
    }
    
    public static int getTin(){
        return tin;
    }
    
    public static void takeItenBronze(int quantidade) {
        bronze += quantidade;
    }
    
    public static int getBronze(){
        return bronze;
    }
    
    public static void takeItenIronOre(int quantidade) {
        ironOre += quantidade;
    }
    
    public static int getIronOre(){
        return ironOre;
    }
    
    public static void takeItenIron(int quantidade) {
        iron += quantidade;
    }
    
    public static int getIron(){
        return iron;
    }
    
    public static void takeItenGoldOre(int quantidade) {
        goldOre += quantidade;
    }
    
    public static int getGoldOre(){
        return goldOre;
    }
    
    public static void takeItenGold(int quantidade) {
        gold += quantidade;
    }
    
    public static int getGold(){
        return gold;
    }
    
    public static void takeItenLeather(int quantidade){
        leather += quantidade;
    }
    
    public static int getLeather(){
        return leather;
    }
    
    public static int getGraveyardOrb(){
        return graveyardOrb;
    }
    
    public static int getTundraOrb(){
        return tundraOrb;
    }
    
    public static int getDesertOrb(){
        return desertOrb;
    }
    
    public static int getOverworldOrb(){
        return overworldOrb;
    }
    
    public static void setGraveyardOrb(int quantidade){
        graveyardOrb += quantidade;
    }
    
    public static void setTundraOrb(int quantidade){
        tundraOrb += quantidade;
    }
    
    public static void setDesertOrb(int quantidade){
        desertOrb += quantidade;
    }
    
    public static void setOverworldOrb(int quantidade){
        overworldOrb += quantidade;
    }

}
