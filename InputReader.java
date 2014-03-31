import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class InputReader
{
    private Scanner reader;
    
    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
   
    public String getInputOriginal()
    {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();

        return inputLine;
    }
    //ej 94-1 es el getInput que devolvia solo la primera palabra
    public String getInputPrimeraPalabra()
    {   
        String[] salidaSplit = new String[20];

        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();

        salidaSplit = inputLine.split(" ");
        return salidaSplit[0];
    }
    //ej 94-3 este devuleve un HashSet
    public HashSet<String> getInput()
    {
        String[] salidaSplit;
        HashSet<String> conjunto = new HashSet<>();
      
        System.out.print("> ");         // print prompt
       String inputLine = reader.nextLine();

        salidaSplit = inputLine.split(" ");

        for(int index=0; index < salidaSplit.length; index++)
        {
            conjunto.add(salidaSplit[index]);
        }
        
        
        return conjunto;
    }

}
