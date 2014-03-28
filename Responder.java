import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> frases;
    private HashMap<String, String> respuestas;
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
        frases.add("ha probado a reiniciar el ordenador?");
        frases.add("desenchufe el cable y vuelvalo a enchufar");
        //a partir de aki es para el ejercio 92
        respuestas = new HashMap<>();
        //guardo las parejas de entrada-respuesta.
        respuestas.put("capullo", "habla bien, que no cuesta un huevo");
        respuestas.put("roto", "llama a un tecnico para que lo arregle, el tlf es 123 45 67 89");
        respuestas.put("garantia", "la garantia es de 2 años, si conserva el tiquet llevelo todo a la tienda");
        respuestas.put("reclamaciones", "estamos haciendo lo posible por solucionar su problema");

    }

    /**
     *(92) busca una respuesta en función de las frases introducidas, a tener en cuenta que en una frase
     * podrian haber más de una key pero solo queremos una respuesta, si no usan ninguna de las palabras
     * definidas como keys, da una respuesta normal.
     */
    public String generandoRespuestav2(String entrada)
    {  
        String fraseDevuelta="";
        if(entrada.contains("capullo")){
            fraseDevuelta = respuestas.get("capullo");

        }else if(entrada.contains("roto")){
            fraseDevuelta = respuestas.get("roto");

        }else if(entrada.contains("garantia")){
            fraseDevuelta = respuestas.get("garantia");

        }else if(entrada.contains("reclamaciones")){
            fraseDevuelta = respuestas.get("reclamaciones");

        }else{
            fraseDevuelta = generateResponse();

        }//con estos bucles me aseguro una única respuesta en el supuesto que coincidieran varias keys

        return fraseDevuelta;
    }

    /**
     *(92) despues de leerme bien el enunciado (la buena)
     */
    public String generandoRespuesta(String entrada)
    {
        String fraseDevuelta = respuestas.get(entrada);
        if (fraseDevuelta==null ){ //el equals no se puede utilizar cuando el valor a comparar es null (null pointer exception)
            fraseDevuelta = generateResponse();
        }
        return fraseDevuelta;
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

    //
}
