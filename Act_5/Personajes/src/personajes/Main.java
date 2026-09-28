/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*
* David Gutierrrez Maciel
*crear clase molde
*/
package personajes;

public class Main {

    public static void main(String[] args) {
        Characters p2 = new Characters();
        Characters personaje1 = new Characters("Samara");
        personaje1.setName("Alondra");

        System.out.println("Mi objeto se llama: " + personaje1.getName());
        p2.setName("Uriel");
        System.out.println("Este objeto se llama: " + p2.getName());
    }//fin de main
