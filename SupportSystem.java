import java.util.HashSet;
/**
 * This class implements a technical support system. It is the top
 * level class in this project. The support system communicates via
 * text input/output in the text terminal.
 * 
 * This class uses an object of class InputReader to read input from
 * the user, and an object of class Responder to generate responses.
 * It contains a loop that repeatedly reads input and generates output
 * until the users wants to leave.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;

    /**
     * Creates a technical support system.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();//tengo que modificar el metodo start para que funcione con hashSet en vez de con String

            if (input.size()==1){// la salida se da solo cuando hay una sola palabra y esta es bye, pero en este caso, como que si una palabra se repite se guarda una sola vez,
                // si ponemos bye bye, bye bye bye, bye... solo lo guarda una vez, el tama�o de input es 1 y la palabra es bye, por lo que da la salida igualmente.
                for (String salida:input){//es lo unico que se me ocurre para trabajar con el unico string que contiene el HashSet
                    if (salida.trim().toLowerCase().equals("bye")){// podemos ahorrarnos el .trim()
                        finished = true;
                    }//con un contains() dariamos la salida si cualquiera de las palabras fuera bye, pero no se como le podria aplicar el .toLowerCase()
                }
            }
               //aunque se ejecute el if de arriba,si no se llega a ejecutar finished=true; devemos ejecutar el if de abajo (antes else)
            if(!finished) {
                String response = responder.generandoRespuesta(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
}
