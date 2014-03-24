/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */import java.util.Random;
   import java.util.ArrayList;
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> frases;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        frases = new ArrayList<>();
        frases.add("si...");
        frases.add("That sounds interesting. Tell me more...");
        frases.add("nuestro servicio tecnico se ocupara de todo");
        frases.add("ha provado a reiniciar el ordenador?");
        frases.add("desenchufe el cable y vuelvalo a enchufar");
        
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int index=aleatorio.nextInt(5);
        return frases.get(index);
    }
}
