/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author David
 */
public class Aritmetica extends calculadora {
    ///Atributos
    ///Constructores
    /*
        constructor default de calculadora aritmetica 
        */
    public Aritmetica(){
        super.setResultado("");
    }//fin constructor 
    /// metodos
    public void sum(String num){
        if (valida(num) == false){
            super.setResultado("Error");
        }else {
            double x;
            x = Long.parseLong(super.getResultado()) + Long.parseLong(num);
            super.setResultado(Double.toString(x));
        }
        /*
        
        */
    }
    public void resta(String num){
        if (valida(num) == false){
            super.setResultado("Error");
        } else {
            double x;
            x = Long.parseLong(super.getResultado()) - Long.parseLong(num);
            super.setResultado(Double.toString(x));
        }
    }
    public void multiplicacion(String num){
        if (valida(num) == false){
            super.setResultado("Error");
        } else {
            double x;
            x = Long.parseLong(super.getResultado()) * Long.parseLong(num);
            super.setResultado(Double.toString(x));
        }
    }
    public void division(String num){
        if (valida(num) == false){
            super.setResultado("Error");
        } else {
            long divisor = Long.parseLong(num);
            if (divisor == 0){
                super.setResultado("Error");
            } else {
                double x;
                x = (double) Long.parseLong(super.getResultado()) / divisor;
                super.setResultado(Double.toString(x));
            }
        }
    }
    
    private boolean valida(String valor){
         if (valor  == null) return false;
    try {
        Long.parseLong(valor);
        return true; // Se pudo convertir sin problemas
    } catch (NumberFormatException e) {
        return false; // Tenía letras o caracteres especiales
    }
}//fin valida
    
}
