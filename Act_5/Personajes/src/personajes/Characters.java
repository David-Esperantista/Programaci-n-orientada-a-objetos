/*
* Descripción: Clase principal donde se encuentran todos los atributos y 
* caracteristicas de los personajes para la simulación del video juego
*/
package personajes;

/**
 * Clase o model principal de Characters
 * @author David Gutierrez Maciel
 */
public abstract class Characters {
    //Atributos
    private int life; // vida del personaje
    private int strength; // fuerza de ataque
    private String name; // Nombre del personaje
    private String hair; // Color del cabello y forma
    private String wear; // Vestimenta
    private String weapon; // Arma a usar
    
    // Constructores
    /**
     * Constructor 
     */
    public Characters(){
        this.name = null;
    }
    /**
     * 
     * @param name 
     */
    public Characters(String name){
        this.name = name;
    }
    /**
     * 
     * @param name
     * @param life 
     */
    public Characters(String name, int life){
        this.name = name;
        this.life = 0;
    }
    // getter y setters
    /**
     * 
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    } // fin de setName
    /**
     * Retorna el valor de name al objeto
     * @return Retorna name
     */
    public String getName(){
        return this.name;
    }// Fin de getName
    public void setlife(int x){
        this.life=x;
    }
    
    public int setLife(){
        return this.life;
    }
    //metodos polimorficos
   
    public abstract String Attack();
  // fin de metodo polimorfico
} // fin de Characters