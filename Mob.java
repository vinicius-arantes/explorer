import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mob extends Actor
{
    private int delayAttack;
    private Island spawnIsland;
    private int life;
    private int damage;
    private static boolean increase;
    
    public Mob(Island spawnIsland){
        String islandType = spawnIsland.getType();
        increase = false;
        delayAttack = 200;
        this.spawnIsland = spawnIsland;
        prepareSkin(spawnIsland);
        if (islandType.contains("overworld")){
            life = 150;
            damage = 10;
        }
        if (islandType.contains("desert")){
            life = 300;
            damage = 13;
        }
        if (islandType.contains("tundra")){
            life = 600;
            damage = 18;
        }
        if (islandType.contains("graveyard")){
            life = 1050;
            damage = 20;
        }
    }
    
    /**
     * Act - do whatever the Mob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Pause.getGamePause() == false){
            followExplorer();
            giveDamage();
            delayAttack++;
            if(life > 0){
                decreaseLife();
            } else {
                MyWorld myWorld = (MyWorld)getWorld();
                String islandType = spawnIsland.getType();
                if(islandType.contains("desert")){
                    myWorld.addObject(new DesertOrb(), getX()-5, getY()-2);
                    if(increase){
                        myWorld.addObject(new DesertOrb(), getX()-5, getY()-2);
                    }
                } else if(islandType.contains("tundra")){
                    myWorld.addObject(new TundraOrb(), getX()-5, getY()-2);
                    if(increase){
                        myWorld.addObject(new TundraOrb(), getX()-5, getY()-2);
                    }
                } else if(islandType.contains("overworld") || islandType.contains("mainOverworld")){
                    myWorld.addObject(new OverworldOrb(), getX()-5, getY()-2);
                    if(increase){
                        myWorld.addObject(new OverworldOrb(), getX()-5, getY()-2);
                    }
                } else if(islandType.contains("graveyard")){
                    myWorld.addObject(new GraveyardOrb(), getX()-5, getY()-2);
                    if(increase){
                        myWorld.addObject(new GraveyardOrb(), getX()-5, getY()-2);
                    }
                }
                myWorld.addObject(new Xp(150), getX() + 5, getY() + 3);
                spawnIsland.setMobCounting(-1);
                myWorld.removeObject(this);
            }
        }
    }
    
    public void followExplorer(){
        Explorer explorer = getWorld().getObjects(Explorer.class).get(0);
        double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
        if(distance < 200){
            if(explorer.getX() >= getX()){
                setLocation(getX() + 1, getY());// Move para a esquerda
            } else {
                setLocation(getX() - 1, getY());// Move para a direita
            }
            if(explorer.getY() >= getY()){
                setLocation(getX(), getY() + 1); // Move para baixo
            } else {
                setLocation(getX(), getY() - 1); // Move para baixo
            }
        }
    }
    
    public void giveDamage(){
        Actor explorer = getOneIntersectingObject(Explorer.class);
        if(explorer != null && delayAttack >= 150){
            getWorld().getObjects(Explorer.class).get(0).takeDamage(damage);
            delayAttack = 0;
            Greenfoot.playSound("hit.mp3");
        }
    }
    
    public void prepareSkin(Island spawnIsland){
        setImage("" + spawnIsland.getType() + "Mob.png");
    }
    
    public void decreaseLife(){
        if(Greenfoot.mouseClicked(this)){
            Explorer explorer = (Explorer) getWorld().getObjects(Explorer.class).get(0);
            double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
            if(distance < 100){
                life -= explorer.getDamageCapabilityMobs();
            }
        }
    }
    
    public static void increaseDrop(){
        increase = true;
    }
}
