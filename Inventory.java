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
        GreenfootImage textoLog = new GreenfootImage("Troncos: " + log, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLog, 80, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Stone
        GreenfootImage textoStone = new GreenfootImage("Pedras: " + stone, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoStone, 140, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("MCobres: " + copperOre, 15, Color.WHITE,
                new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopperOre, 200, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Copper
        GreenfootImage textoCopper = new GreenfootImage("Cobres: " + copper, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopper, 260, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("MEstanhos: " + tinOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTinOre, 320, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Tin
        GreenfootImage textoTin = new GreenfootImage("Estanhos: " + tin, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTin, 380, 100); // Posiciona o texto no HUD

        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("Bronzes: " + bronze, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 80, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("MFerros: " + ironOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIronOre, 140, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Iron
        GreenfootImage textoIron = new GreenfootImage("Ferros: " + iron, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIron, 200, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("MOuro: " + goldOre, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGoldOre, 260, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold
        GreenfootImage textoGold = new GreenfootImage("Ouro: " + gold, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGold, 320, 160); // Posiciona o texto no HUD

        // Adiciona o texto do número de Couro
        GreenfootImage textoLeather = new GreenfootImage("Couro: " + leather, 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLeather, 380, 160); // Posiciona o texto no HUD
        
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
}
