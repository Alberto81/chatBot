/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */import java.util.Random;
public class Responder
{
    private Random aleatorio;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio=new Random();
        
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return "That sounds interesting. Tell me more...";
    }
}
