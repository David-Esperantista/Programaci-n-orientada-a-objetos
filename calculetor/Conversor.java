package calculetor;
/**
 * @author David
 */

public class Conversor extends Calculadora {
    /**
     * el constructor necesario para crear objetos
     */
    public Conversor(){
        super.setResultado("");
        super.setError("");
    }
    /**
     *  Valida que no este vacio que no sea null y por ultimo que solo sean los numeros arabes
     */
    private boolean validaDecimal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
    /**
     *  Valida que no este vacio que no sea null y por ultimo que solo sean los 1 o 0
     */
    private boolean validaBinario(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c != '0' && c != '1') return false;
        }
        return true;
    }
    /**
     *  Valida que no este vacio que no sea null y por ultimo que solo sean los 0 a 7 el 8 no porque seria 10
     */
    private boolean validaOctal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }
    /**
     *  Valida que no este vacio que no sea null y por ultimo que solo sean los numeroa arabes mas a al f
     */
    private boolean validaHexadecimal(String valor){
        if (valor == null || valor.isBlank()) return false;
        valor = valor.trim();
        for (int i = 0; i < valor.length(); i++){
            char c = valor.charAt(i);
            boolean digito    = (c >= '0' && c <= '9');
            boolean mayuscula = (c >= 'A' && c <= 'F');
            boolean minuscula = (c >= 'a' && c <= 'f');
            if (!digito && !mayuscula && !minuscula) return false;
        }
        return true;
    }
    /**
     *  el siguiente metodo es para validar si es la vase y si no lo marca por eso es verdadero y falso
     */
    private boolean validaSegunBase(String valor, int baseOrigen) {
        switch (baseOrigen) {
            case 2:  return validaBinario(valor);
            case 8:  return validaOctal(valor);
            case 10: return validaDecimal(valor);
            case 16: return validaHexadecimal(valor);
            default: return false;
        }
    }

    private int valorDigito(char c){
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'A' && c <= 'F') return c - 'A' + 10;
        if (c >= 'a' && c <= 'f') return c - 'a' + 10;
        return -1;
    }
    /**
     *  Tanforma la base  ala deseada
     */
    public void convertirBase(String valor, int baseOrigen, int baseDestino){
        if (!validaSegunBase(valor, baseOrigen)){
            super.setResultado("Error");
            super.setError("El valor ingresado no coincide con los caracteres permitidos para la base " + baseOrigen);
            return;
        }

        valor = valor.trim();
        long decimal = 0;
        for (int i = 0; i < valor.length(); i++){
            decimal = decimal * baseOrigen + valorDigito(valor.charAt(i));
        }

        if (decimal == 0){
            super.setResultado("0");
            super.setError("");
            return;
        }
        /**
         *  asegura que sea alguno de este digito 0123456789ABCDEF
         */
        String simbolos = "0123456789ABCDEF";
        String texto = "";
        long numero = decimal;
        while (numero > 0){
            int residuo = (int) (numero % baseDestino);
            texto = simbolos.charAt(residuo) + texto;
            numero = numero / baseDestino;
        }
        super.setResultado(texto);
        super.setError("");
    }

    public boolean hayError(){
        return super.getResultado().equals("Error");
    }
}