/*
* Nombre: Sergio Franco Casillas
* Materia: POO
* Descripción: Crear una clase (molde) para crear personajes de la simulación
* de algunos personajes de un video juego
* Fecha: 22/09/2026
*/
package personajes;

/**
 * Nombre de clase principal o de ejecución (Front-End)
 * @author David Gutierrez Maciel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // instanciar objeto characters
    Wirzard wz= new Wirzard("David");
    wz.setLife(10);
    System.out.println("ataco");
    wz.setLife(wz.getLife()-1)
        
    }// fin de main
    
}