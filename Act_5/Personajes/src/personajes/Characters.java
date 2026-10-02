/*
 * Descripción: Clase principal donde se encuentran todos los atributos y 
 * caracteristicas de los personajes para la simulación del video juego
 */
package personajes;

/**
 * Clase principal y abstracta de Characters.
 * @author David Gutierrez Maciel
 */
public abstract class Characters {
    // Atributos
    private int life;     // vida del personaje
    private int strength; // fuerza de ataque
    private String name;  // Nombre del personaje
    private String hair;  // Color del cabello y forma
    private String wear;  // Vestimenta
    private String weapon;// Arma a usar
    
    // Constructores
    /**
     * Constructor por defecto.
     */
    public Characters(){
        this.name = null;
    }

    /**
     * Constructor que asigna un nombre al personaje.
     * @param name Nombre del personaje
     */
    public Characters(String name){
        this.name = name;
    }

    /**
     * Constructor completo de la clase Characters.
     * @param life Puntos de vida iniciales
     * @param strength Puntos de fuerza de ataque
     * @param name Nombre del personaje
     * @param hair Estilo o color de cabello
     * @param wear Tipo de vestimenta
     * @param weapon Arma equipada
     */
    public Characters(int life, int strength, String name, String hair, String wear, String weapon){
        this.life = life;
        this.strength = strength;
        this.name = name;
        this.hair = hair;
        this.wear = wear;
        this.weapon = weapon;
    }

    // Getters y Setters
    /**
     * Establece el nombre del personaje.
     * @param name Nombre a asignar
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Obtiene el nombre del personaje.
     * @return Nombre del personaje
     */
    public String getName(){
        return this.name;
    }

    /**
     * Establece la vida del personaje.
     * @param life Puntos de vida a asignar
     */
    public void setLife(int life){
        this.life = life;
    }

    /**
     * Obtiene los puntos de vida del personaje.
     * @return Puntos de vida actuales
     */
    public int getLife(){
        return this.life;
    }

    /**
     * Establece la fuerza del personaje.
     * @param strength Puntos de fuerza a asignar
     */
    public void setStrength(int strength){
        this.strength = strength;
    }

    /**
     * Obtiene la fuerza del personaje.
     * @return Puntos de fuerza
     */
    public int getStrength(){
        return this.strength;
    }

    /**
     * Establece el tipo de cabello del personaje.
     * @param hair Estilo o color de cabello
     */
    public void setHair(String hair){
        this.hair = hair;
    }

    /**
     * Obtiene el tipo de cabello del personaje.
     * @return Estilo o color de cabello
     */
    public String getHair(){
        return this.hair;
    }

    /**
     * Establece la vestimenta del personaje.
     * @param wear Vestimenta a asignar
     */
    public void setWear(String wear){
        this.wear = wear;
    }

    /**
     * Obtiene la vestimenta del personaje.
     * @return Vestimenta actual
     */
    public String getWear(){
        return this.wear;
    }

    /**
     * Establece el arma del personaje.
     * @param weapon Arma a asignar
     */
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    /**
     * Obtiene el arma del personaje.
     * @return Arma equipada
     */
    public String getWeapon(){
        return this.weapon;
    }

    // Métodos polimórficos
    /**
     * Ejecuta la acción de ataque propia del personaje.
     * @return Descripción del ataque realizado
     */
    public abstract String Attack();
}