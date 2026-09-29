/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

/**
 *clase para hacer un maga
 * clase heredara de claracters
 * @David Gutierrez Maciel
 */
public class Wirzard extends Characters{
    // contrutor
    //contrutor por defaul
    /*
    *no lleva parametros pero inicializa los valores que el programador dese
    */
    public Wirzard(){
        // aceder ala variables de la clase
        super.setName(null);
        super.setlife(0);
    }
    public Wirzard(Sting name){
        super.setName(name);
    }
    @Override
    /**
     * este metodo es para que el mago lanze un hechizo
     */
    public String Attack(){
    return "lanza un hechizo";
    }
    
    
}
