import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Statistic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Statistic  
{
    private static long startTime;
    private static long stopTime;
    private static int xpAmount;

    /**
     * Constructor for objects of class Statistic
     */
    public Statistic()
    {
        startTime = System.currentTimeMillis();
        xpAmount = 0;
    }

    public static String getTimePlayed(){
        long elapsedTime = stopTime - startTime; // Calcula tempo decorrido
        return "Tempo jogado: " + elapsedTime / 1000 + "s";
    }
    
    public static void setStopStime(){
        stopTime = System.currentTimeMillis();;
    }
    
    public static void setXpAmount(int totalAmount){
        xpAmount = totalAmount;
    }
    
    public static String getTotalXp(){
        return "XP coletado: " + xpAmount;
    }
}
