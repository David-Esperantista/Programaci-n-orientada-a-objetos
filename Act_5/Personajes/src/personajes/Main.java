
/*
* Nombre: Sergio Franco Casillas
* Materia: POO
* Descripción: Crear una clase (molde) para crear personajes de la simulación
* de algunos personajes de un video juego
* Fecha: 22/09/2026
*/
package personajes;

/**
 * Nombre de clase principal o de ejecución 
 * @author David Gutierrez Maciel
 */
public class Main {

    /**
     * para mostrat que funciona las clases
     */
    public static void main(String[] args) {
        // mago
        // instanciar objeto characters
    Wirzard wz= new Wirzard("David");
    wz.setLife(10);
    System.out.println("ataco");
    wz.setLife(wz.getLife()-1);

    Warior Wa= new Warior("Roberto");
    Wa.setLife(15);
    System.out.println(Wa.Attack());
    Wa.setLife(Wa.getLife()-2);
        
    }// fin de main
    
}