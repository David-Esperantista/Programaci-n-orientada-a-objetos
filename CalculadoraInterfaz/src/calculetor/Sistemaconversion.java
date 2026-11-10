package calculetor;
/**
 * @author David
 */
public class Sistemaconversion extends Calculadora {
    /**
     *  esta enumeracion define las magnitudes que puede manejar el sistema
     *  y almacena el factor maximo para detectar desbordes antes de guardar
     */
    private enum Magnitud {
        NINGUNA(1), LONGITUD(1000), PESO(1000), TEMPERATURA(2);

        private final double maxFactor;

        Magnitud(double maxFactor){
            this.maxFactor = maxFactor;
        }
    }

    private Magnitud actual = Magnitud.NINGUNA;
    /**
     *  constructor que inicializa el factor maximo de cada magnitud
     */
    public Sistemaconversion(){
        super.setResultado("");
        super.setError("");
    }
    /**
     *  Valida que sea un numero
     */
    private boolean esNumero(String valor){
        if (valor == null || valor.isBlank()) return false;
        try {
            double d = Double.parseDouble(valor.trim());
            return !Double.isNaN(d) && !Double.isInfinite(d);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     *  Valida que sea un numero
     */
    private boolean validaMedida(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= 0;
    }
    /**
     *  Valida que este el limite de Fahrenheit
     */
    private boolean validaFahrenheit(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= -459.67;
    }
    /**
     *  Valida que este el limite de FCelsius
     */
    private boolean validaCelsius(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= -273.15;
    }
    /**
     *  Validar que no tenga negativos
     */
    private boolean validaKelvin(String valor){
        return esNumero(valor) && Double.parseDouble(valor.trim()) >= 0;
    }
    /**
     *  asegura de que solo sea magnitud y que no se mescle con este
     */
    private double pivote(Magnitud m){
        if (actual != m){
            throw new IllegalStateException("Primero convierte un valor de " + m.name().toLowerCase() + ".");
        }
        return Double.parseDouble(super.getResultado());
    }

    private void guarda(double x, Magnitud m){
        if (Double.isNaN(x) || Double.isInfinite(x * m.maxFactor)){
            error("Desborde o valor inválido en la conversión.");
        } else {
            actual = m;
            super.setResultado(Double.toString(x));
            super.setError("");
        }
    }

    private void error(String mensaje){
        actual = Magnitud.NINGUNA;
        super.setResultado("Error");
        super.setError(mensaje);
    }
    /**
     *  los siguientes metodos son para convetir magnituds
     */
    public void pulgadasAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 0.0254, Magnitud.LONGITUD);
    }
    public void piesAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 0.3048, Magnitud.LONGITUD);
    }
    public void yardasAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 0.9144, Magnitud.LONGITUD);
    }
    public void millasAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 1609.344, Magnitud.LONGITUD);
    }
    public void milimetrosAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 0.001, Magnitud.LONGITUD);
    }
    public void centimetrosAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 0.01, Magnitud.LONGITUD);
    }
    public void metrosAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 1, Magnitud.LONGITUD);
    }
    public void kilometrosAMetros(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para longitud.");
        else guarda(Double.parseDouble(valor.trim()) * 1000, Magnitud.LONGITUD);
    }

    public double aMilimetros()  { return pivote(Magnitud.LONGITUD) * 1000; }
    public double aCentimetros() { return pivote(Magnitud.LONGITUD) * 100; }
    public double aMetros()      { return pivote(Magnitud.LONGITUD) * 1; }
    public double aKilometros()  { return pivote(Magnitud.LONGITUD) * 0.001; }
    public double aPulgadas()    { return pivote(Magnitud.LONGITUD) * 39.37007874015748; }
    public double aPies()        { return pivote(Magnitud.LONGITUD) * 3.280839895013123; }
    public double aYardas()      { return pivote(Magnitud.LONGITUD) * 1.0936132983377078; }
    public double aMillas()      { return pivote(Magnitud.LONGITUD) * 0.000621371192237334; }

    public void onzasAKilogramos(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para peso.");
        else guarda(Double.parseDouble(valor.trim()) * 0.028349523125, Magnitud.PESO);
    }
    public void librasAKilogramos(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para peso.");
        else guarda(Double.parseDouble(valor.trim()) * 0.45359237, Magnitud.PESO);
    }
    public void gramosAKilogramos(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para peso.");
        else guarda(Double.parseDouble(valor.trim()) * 0.001, Magnitud.PESO);
    }
    public void kilogramosAKilogramos(String valor){
        if (!validaMedida(valor)) error("Valor inválido o negativo para peso.");
        else guarda(Double.parseDouble(valor.trim()) * 1, Magnitud.PESO);
    }
    /**
     *  tranformar los pesos en los siguientes metodos
     */
    public double aGramos()      { return pivote(Magnitud.PESO) * 1000; }
    public double aKilogramos()  { return pivote(Magnitud.PESO) * 1; }
    public double aOnzas()       { return pivote(Magnitud.PESO) * 35.27396194958041; }
    public double aLibras()      { return pivote(Magnitud.PESO) * 2.2046226218487757; }

    public void fahrenheitACelsius(String valor){
        if (!validaFahrenheit(valor)) error("Temperatura por debajo del cero absoluto en Fahrenheit.");
        else guarda((Double.parseDouble(valor.trim()) - 32) * 5.0 / 9.0, Magnitud.TEMPERATURA);
    }
    public void celsiusACelsius(String valor){
        if (!validaCelsius(valor)) error("Temperatura por debajo del cero absoluto en Celsius.");
        else guarda(Double.parseDouble(valor.trim()), Magnitud.TEMPERATURA);
    }
    public void kelvinACelsius(String valor){
        if (!validaKelvin(valor)) error("Temperatura por debajo del cero absoluto en Kelvin.");
        else guarda(Double.parseDouble(valor.trim()) - 273.15, Magnitud.TEMPERATURA);
    }

    public double aCelsius()     { return pivote(Magnitud.TEMPERATURA) * 1; }
    public double aKelvin()      { return pivote(Magnitud.TEMPERATURA) + 273.15; }
    public double aFahrenheit()  { return pivote(Magnitud.TEMPERATURA) * 1.8 + 32; }

    public boolean hayError(){
        return super.getResultado().equals("Error");
    }
}