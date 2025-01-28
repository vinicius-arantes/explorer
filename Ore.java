import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ore extends Actor
{
    private int life;
    private int initialLife;
    private String type;
    
    public Ore(int life, String type){
        this.life = life;
        initialLife = life;
        this.type = type;
    }
    
    /**
     * Act - do whatever the Stone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(life > 0){
            decreaseLife();
        } else {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.addObject(new Xp(initialLife), getX() + 5, getY() + 3);
            if(type.contains("tree")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setTreeCounting(-1);
                myWorld.addObject(new Log(), getX()-5, getY());
            } else if(type.contains("rock")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setStoneCounting(-1);
                myWorld.addObject(new StoneItem(), getX()-5, getY());
            } else if(type.contains("iron")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setIronCounting(-1);
                myWorld.addObject(new IronDrop(), getX()-5, getY());
            } else if(type.contains("tin")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setTinCounting(-1);
                myWorld.addObject(new TinDrop(), getX()-5, getY());
            } else if(type.contains("copper")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setCopperCounting(-1);
                myWorld.addObject(new CopperDrop(), getX()-5, getY());
            } else if(type.contains("gold")){
                getWorld().getObjectsAt(getX(), getY(), Island.class).get(0).setGoldCounting(-1);
                myWorld.addObject(new GoldDrop(), getX()-5, getY());
            }
            myWorld.removeObject(this);
        }
    }
    
    public void decreaseLife(){
        if(Greenfoot.mouseClicked(this)){
            Explorer explorer = (Explorer) getWorld().getObjects(Explorer.class).get(0);
            double distance = Math.sqrt(Math.pow(explorer.getX() - getX(), 2) + Math.pow(explorer.getY() - getY(), 2));
            if(distance < 50){
                life -= explorer.getDamageCapability();
                if(life < 100 && life > 50){
                    setImage(type + "Damaged75.png");
                } else if (life < 75 && life > 25){
                    setImage(type + "Damaged50.png");
                } else if(life < 50 && life > 0){
                    setImage(type + "Damaged25.png");
                }
            }
        }
        if(isTouching(Pet.class)){
            life -= 500;
            if(life < 100 && life > 50){
                setImage(type + "Damaged75.png");
            } else if (life < 75 && life > 25){
                setImage(type + "Damaged50.png");
            } else if(life < 50 && life > 0){
                setImage(type + "Damaged25.png");
            }
        }
    }
}
