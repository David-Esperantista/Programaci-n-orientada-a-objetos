package calculetor;

/**
 * Clase madre abstracta para las calculadoras del otro tipo
 * @author David
 */
public abstract class Calculadora {

    // Variables privadas que se usan para guardar el estado de la calculadora
    private String resultado = "0";
    private String error = "";

    /**
     * Establece el valor actual del resultado.
     * @param resultado El texto con el resultado a guardar.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtiene el valor actual del resultado.
     * @return El resultado actual en formato de cadena.
     */
    public String getResultado() {
        return this.resultado;
    }

    /**
     * Obtiene el mensaje de error actual.
     * @return El mensaje de error registrado.
     */
    public String getError() {
        return this.error;
    }

    /**
     * Establece un mensaje de error cuando ocurre un fallo.
     * @param error El mensaje descriptivo del error.
     */
    protected void setError(String error) {
        this.error = error;
    }
}