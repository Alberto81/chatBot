import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{   
    Iterator<String> it;
    private Random aleatorio;
    private ArrayList<String> frases;
    private HashMap<String, String> respuestas;
    //devemos mantener los cambios de indice en las diversas ejecuciones de los m�todos, por eso no va como variable local
    //aunque al tratarse de un arraylist, podriamos borrar las frases ya dichas
    private int indice;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {

        aleatorio = new Random();
        frases = new ArrayList<>();

        frases.add("no entiendo la pregunta");
        frases.add("That sounds interesting. Tell me more...");
        frases.add("nuestro servicio tecnico se ocupara de todo");
        frases.add("ha probado a reiniciar el ordenador?");
        frases.add("desenchufe el cable y vuelvalo a enchufar");
        //a partir de aki es para el ejercio 92
        respuestas = new HashMap<>();
        //guardo las parejas de entrada-respuesta.
        respuestas.put ( "capullo", "habla bien, que no cuesta un huevo");
        respuestas.put("roto", "llama a un tecnico para que lo arregle, el tlf es 123 45 67 89");
        respuestas.put("garantia", "la garantia es de 2 a�os, si conserva el tiquet llevelo todo a la tienda");
        respuestas.put("reclamaciones", "estamos haciendo lo posible por solucionar su problema");
        indice=frases.size()-1;
    }

    /**
     *(92) busca una respuesta en funci�n de las frases introducidas, a tener en cuenta que en una frase
     * podrian haber m�s de una key pero solo queremos una respuesta, si no usan ninguna de las palabras
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

        }//con estos bucles me aseguro una �nica respuesta en el supuesto que coincidieran varias keys

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
        it=entrada.iterator();
        boolean encontrado = false;
        String palabra = "";
        String fraseDevuelta = "";
        while(it.hasNext() && !encontrado){
            palabra = it.next();
            //el orden de los if es irrelevante, pues si entra en uno, no entra en el otro.
            if (respuestas.get(palabra) != null){
                fraseDevuelta = respuestas.get(palabra);
                encontrado = true;
            }

            if(palabra.equals("tonto") || palabra.equals("anormal") || palabra.equals("estupido")){
                fraseDevuelta = respuestas.get("capullo");
                encontrado = true;
            }

        }

        if (!encontrado){
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
        //as� dara las respuestas desde el utimo indice hacia atras, sin repetir ninguno hasta llegar al 0 que se repitira siempre
        String respuesta="";
        if(indice==0){
            respuesta = frases.get(indice);
        }else{
            respuesta = frases.get(indice);
            indice--;
        }
        return respuesta;
    }

    //
}
