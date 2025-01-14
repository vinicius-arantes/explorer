import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDCoins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDCoins extends Actor
{
    private static int coin;
    
    public HUDCoins()
    {
        coin = 0;
    }
    
    /**
     * Act - do whatever the HUDCoins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        updadeHUDCoin();
    }
    
    public void setImageInitial()
    {
        //Cria o HUD
        GreenfootImage imagem = new GreenfootImage("HUD.png");
        // Aplica a imagem
        setImage(imagem);
        //Atualiza a HUD
        updadeHUDCoin();
    }
    

    public void updadeHUDCoin()
    {
        // Cria a imagem do HUD de Coin
        GreenfootImage imagem = new GreenfootImage("coin.png");

        // Cria o texto com o número de moedas
        GreenfootImage textoLog = new GreenfootImage("Moedas: " + coin, 20, Color.BLACK, new Color(0, 0, 0, 0));

        // Define a margem de 30px
        int margem = 30;

        // Calcula a posição para o texto, com a margem
        int xTexto = imagem.getWidth() + margem;  // O texto começa logo após a moeda, com margem
        int yTexto = (imagem.getHeight() - textoLog.getHeight()) / 2; // Centraliza verticalmente o texto em relação à moeda

        // Ajusta o tamanho da imagem para garantir que o texto caiba com a margem
        int larguraTotal = imagem.getWidth() + textoLog.getWidth() + margem;  // Largura da moeda, texto e margem
        int alturaTotal = Math.max(imagem.getHeight(), textoLog.getHeight());  // A altura será a maior entre as duas imagens

        // Cria uma imagem maior para o HUD (que acomoda a moeda e o texto)
        GreenfootImage fundoHUD = new GreenfootImage(larguraTotal, alturaTotal);
    
        // Desenha a imagem da moeda na imagem de fundo, com margem de 30px
        fundoHUD.drawImage(imagem, margem, (alturaTotal - imagem.getHeight()) / 2);  // A moeda será desenhada com a margem

        // Desenha o texto na imagem de fundo
        fundoHUD.drawImage(textoLog, xTexto, yTexto);  // O texto será desenhado com a margem à direita da moeda

        // Aplica a nova imagem ao ator
        setImage(fundoHUD);
    }
    
    public int getCoin()
    {
        return coin;
    }
    
    public static void setCoin(int adicionar)
    {
        coin += adicionar;
    }
    
}
