import greenfoot.*;
public class Pet extends Actor {
    private String petName = "";
    private boolean isTyping = true;
    private GreenfootImage baseImage = new GreenfootImage("capivarinha.png");
    
    public Pet() {
        askForName();
    }
    
    public void act() {
        if (isTyping) {
            captureInput();
        }
        followExplorer();
    }
    
    public void followExplorer(){
        Explorer explorer = getWorld().getObjects(Explorer.class).get(0);
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
    
    public boolean haveIntersectingObjects(){
        Actor border = getOneIntersectingObject(Border.class);
        Actor ore = getOneIntersectingObject(Ore.class);
        if(border != null || ore != null){
            return true;
        }
        return false;
    }

    private void askForName() {
        GreenfootImage promptImage = new GreenfootImage("Digite o nome do seu Pet e pressione ENTER:", 20, Color.WHITE, Color.BLACK);
        setImage(promptImage);
    }

    private void updatePetImage() {
        int width = baseImage.getWidth();
        int height = baseImage.getHeight();
        GreenfootImage updatedImage = new GreenfootImage(width, height + 15);

        updatedImage.drawImage(baseImage, 0, 15);

        if (!petName.isEmpty()) {
            GreenfootImage nameImage = new GreenfootImage(petName, 12, Color.WHITE, new Color(0, 0, 0, 128));
            int nameX = (updatedImage.getWidth() - nameImage.getWidth()) / 2;
            updatedImage.drawImage(nameImage, nameX, 0);
        }

        setImage(updatedImage);
    }

    private void captureInput() {
        String key = Greenfoot.getKey(); // Captura a tecla pressionada
        if (key != null) {
            if (key.equals("enter") && !petName.isEmpty()) {
                isTyping = false;
                updatePetImage();
            } else if (key.equals("backspace") && petName.length() > 0) {
                petName = petName.substring(0, petName.length() - 1);
                askForName();
            } else if (key.length() == 1 && petName.length() < 10) {
                petName += key;
                askForName();
            }
        }
    }
}
