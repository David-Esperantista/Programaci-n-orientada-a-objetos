/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


 /*descricion
*clase principal que se encuentra los personajes
*
*/
package personajes;

/**
 *clase o model principal de characters
 * @author David
 */
public class Characters {
    //Atributos (variables)
    private float life_health; // vida del personaje
    private float strangeth; // fuerza de ataque
    private String name; // nombre del personaje
    private String hair; // Color de cabello y forma
    private String wear; // vestimenta
    private String weapon; //varma a usar

    //constructores
    public Characters() {
    }

    public Characters(String name) {
        this.name = name;
    }

    //geter y setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}//fin de characters
