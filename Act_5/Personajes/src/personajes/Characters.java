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
 public Characters(String name, float life_health, String weapon) {
    this.name = name;
    this.life_health = life_health;
    this.weapon = weapon;
}
  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // life_health
    public float getLife_health() {
        return life_health;
    }

    public void setLife_health(float life_health) {
        this.life_health = life_health;
    }

    // weapon
    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

}//fin de characters
