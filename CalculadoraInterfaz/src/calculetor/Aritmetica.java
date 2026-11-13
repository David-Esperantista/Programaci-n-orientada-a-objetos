package calculetor;

/**
 * clase aritmetica, hija de la calculadora
 *
 @author David
 */
public class Aritmetica extends Calculadora {

    /**
     * el constructor necesario para crear objetos
     */
    public Aritmetica(){
        super.setResultado("0");
        super.setError("");
    }

    /**
     * este metodo hace que la x reciba un valor y este lo suma al contador
     */
    public void sum(String num) {
        double x = Double.parseDouble(super.getResultado()) + Double.parseDouble(num);
        super.setResultado(Double.toString(x));
        super.setError("");
    }

    /**
     * este metodo hace que la x reciba un valor y este lo resta al contador
     */
    public void resta(String num) {
        double x = Double.parseDouble(super.getResultado()) - Double.parseDouble(num);
        super.setResultado(Double.toString(x));
        super.setError("");
    }

    /**
     *  este metodo hace que la x reciba un valor y este lo multiplica al acumulador
     */
    public void multiplicacion(String num) {
        double x = Double.parseDouble(super.getResultado()) * Double.parseDouble(num);
        super.setResultado(Double.toString(x));
        super.setError("");
    }

    /**
     *  este metodo hace que la x reciba un valor y este lo divide al acumulador
     */
    public void division(String num) {
        double divisor = Double.parseDouble(num);
        if (divisor == 0) {
            super.setResultado("Error");
            super.setError("No se puede divir entre cero");
        } else {
            double x = Double.parseDouble(super.getResultado()) / divisor;
            super.setResultado(Double.toString(x));
            super.setError("");
        }
    }

    /**
     *  este metodo reinicia el contador a cero
     */
    public void limpiar(){
        super.setResultado("0");
        super.setError("");
    }

    /**
     *  Quite validar porque con la interfaz ya no es posible que pase que pango un valon no valido porque yo
     *  pongo las teclas y solo esas se pueden poner
     */

    /**
     *  el acumulador empieza y le vamos agregando segun lo que pida en el menu
     */

    public boolean acumuladorValido() {
        return !super.getResultado().equals("Error");
    }
}