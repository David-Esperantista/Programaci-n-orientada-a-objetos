/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

/**
 *clase para hacer un maga
 * clase heredara de claracters
 *  @author David Gutierrez Maciel
 */
public class Warior extends Characters{
    // contrutor
    //contrutor por defaul
    /*
    *no lleva parametros pero inicializa los valores que el programador dese
    */
    public Warior(){
        // aceder ala variables de la clase
        super.setName(null);
        super.setLife(0);
    }
    public Warior(String name){
        super.setName(name);
    }
    @Override
    /**
     * este metodo es para que el mago lanze un hechizo en la otra clase en esta clase espara que pege
     */
    public String Attack(){
    return "Golpe fuerte";
    }
    
    
}