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
    public void sum(String num){
        if (!valida(num) || !acumuladorValido()){
            super.setResultado("Error");
            super.setError("Valor inválido para la suma.");
        } else {
            double x = Double.parseDouble(super.getResultado()) + Double.parseDouble(num);
            super.setResultado(Double.toString(x));
            super.setError("");
        }
    }

    /**
     * este metodo hace que la x reciba un valor y este lo resta al contador
     */
    public void resta(String num){
        if (!valida(num) || !acumuladorValido()){
            super.setResultado("Error");
            super.setError("Valor inválido para la resta.");
        } else {
            double x = Double.parseDouble(super.getResultado()) - Double.parseDouble(num);
            super.setResultado(Double.toString(x));
            super.setError("");
        }
    }

    /**
     *  este metodo hace que la x reciba un valor y este lo multiplica al acumulador
     */
    public void multiplicacion(String num){
        if (!valida(num) || !acumuladorValido()){
            super.setResultado("Error");
            super.setError("Valor inválido para la multiplicación.");
        } else {
            double x = Double.parseDouble(super.getResultado()) * Double.parseDouble(num);
            super.setResultado(Double.toString(x));
            super.setError("");
        }
    }

    /**
     *  este metodo hace que la x reciba un valor y este lo divide al acumulador
     */
    public void division(String num){
        if (!valida(num) || !acumuladorValido()){
            super.setResultado("Error");
            super.setError("Valor inválido para la división.");
        } else {
            double divisor = Double.parseDouble(num);
            if (divisor == 0){
                super.setResultado("Error");
                super.setError("Error: División entre cero no permitida.");
            } else {
                double x = Double.parseDouble(super.getResultado()) / divisor;
                super.setResultado(Double.toString(x));
                super.setError("");
            }
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
     *  este metodo valida que sea un numero
     */
    private boolean valida(String valor){
        if (valor == null) return false;
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *  el acumulador empieza y le vamos agregando segun lo que pida en el menu
     */
    private boolean acumuladorValido(){
        return valida(super.getResultado());
    }
}