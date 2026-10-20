/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author David
 */
public abstract class calculadora {
    //atributos
    private String resultado;
    
    //Metodos para acceder al acumulador 
    public void setResultado(String valor){
        this.resultado = valor;
    }// fin set resultado
    
    public String getResultado(){
        return this.resultado;
        
    }
}
