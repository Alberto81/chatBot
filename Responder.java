import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{   

    private ArrayList<String> frases;
    private HashMap<HashSet, String> respuestas;
    private HashSet <String> conjunto1;
    private HashSet <String> conjunto2;
    private HashSet <String> conjunto3;
    //devemos mantener los cambios de indice en las diversas ejecuciones de los métodos, por eso no va como variable local
    //aunque al tratarse de un arraylist, podriamos borrar las frases ya dichas
    private int indice;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {


        conjunto1=new HashSet<>();
        conjunto1.add("capullo");
        conjunto1.add("tonto");
        conjunto1.add("anormal");
        conjunto1.add("estupido");

        conjunto2=new HashSet<>();
        conjunto2.add("roto");
        conjunto2.add("estropeado");
        conjunto2.add("desguazado");
        conjunto2.add("destrozado");

        conjunto3=new HashSet<>();
        conjunto3.add("garantia");
        conjunto3.add("gratis");
        conjunto3.add("arreglo");
        conjunto3.add("cambiar");

        frases = new ArrayList<>();
        frases.add("no entiendo la pregunta");
        frases.add("That sounds interesting. Tell me more...");
        frases.add("nuestro servicio tecnico se ocupara de todo");
        frases.add("ha probado a reiniciar el ordenador?");
        frases.add("desenchufe el cable y vuelvalo a enchufar");
        //a partir de aki es para el ejercio 92
        respuestas = new HashMap<>();
        //guardo las parejas de entrada-respuesta.
        respuestas.put(conjunto1, "habla bien, que no cuesta un huevo");
        respuestas.put(conjunto2, "llama a un tecnico para que lo arregle, el tlf es 123 45 67 89");
        respuestas.put(conjunto3, "la garantia es de 2 años, si conserva el tiquet llevelo todo a la tienda");

        indice=frases.size()-1;
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
     * cambiamos el tipo de parametro de String a HashSet
     * (95)sale con la primera palabra que coincide con una key de respuestas.
     * (96-da una misma respuesta para palabras parecidas)
     */
    public String generandoRespuesta(HashSet<String> entrada)
    {
        String fraseDevuelta = respuestas.get(entrada);
        if (fraseDevuelta == null){
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
        //así dara las respuestas desde el utimo indice hacia atras, sin repetir ninguno hasta llegar al 0 que se repitira siempre.
        //indice está como atributo.
        String respuesta="no entiendo la pregunta";
        if(indice==0){
            respuesta = frases.get(indice);
        }else{
            respuesta = frases.get(indice);
            indice--;
        }
        return respuesta;
    }

}
