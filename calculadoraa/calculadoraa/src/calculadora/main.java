/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author David
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aritmetica ar= new Aritmetica();
        ar.setResultado("5");
        ar.sum("10");
        System.out.println(ar.getResultado());

        ar.setResultado("5");                    // la resta
        ar.resta("3");
        System.out.println(ar.getResultado());

        ar.setResultado("5");                    // multiplicacion
        ar.multiplicacion("5");
        System.out.println(ar.getResultado());

        ar.setResultado("10");
        ar.division("5");
        System.out.println(ar.getResultado());   // division
    }
    
}
