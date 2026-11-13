package calculetor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Ventana de la calculadora aritmetica.
 * Hereda de VentanaBase: aqui solo queda lo propio de esta pantalla.
 *
 * @author David
 */
public class VentanaCalculadoraAritmetrica extends VentanaBase {

    /**
     * Disposicion del teclado, fila por fila.
     * Esta forma permite agregar todos los botones que se necesiten.
     */
    private static final String[] TECLAS = {
            "1", "2", "3", "+","=",
            "4", "5", "6", "-","/",
            "7", "8", "9", "X",".",
            "0", "Limpiar","Salir",
    };

    /** Pantalla donde se muestran los numeros y los resultados. */
    private final JTextField pantalla = new JTextField("0");

    /** Objeto de la logica que realiza las operaciones aritmeticas. */
    private final Aritmetica calc = new Aritmetica();

    /** Primer numero de la operacion pendiente. */
    private String primero = "";

    /** medotodo que indica que debe hacer la calculadora con los valores que se le dio */
    private String operador = "";

    /** Indica si el proximo digito debe empezar un numero nuevo. */
    private boolean nuevoNumero = true;

    /**
     * solo es para el titulo de la ventana
     *
     * @return el titulo que se muestra en la barra de la ventana
     */
    @Override
    protected String titulo() {
        return "Calculadora";
    }

    /**
     * crea la parte visual de la intefaz y esta programado asi para asegurarme que sea compatible en todos los compliladores
     *
     * @return el panel principal ya armado
     */
    @Override
    protected JPanel crearPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel teclado = new JPanel(new GridBagLayout());

        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        pantalla.setPreferredSize(new Dimension(300, 60));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        int columna = 0;
        int fila = 0;

        for (String t : TECLAS) {
            JButton b = new JButton(t);
            b.setFont(new Font("Arial", Font.PLAIN, 22));
            // esta parte es para cambiar el color de los botones
            b.setBackground(new Color(245, 245, 220));
            b.setOpaque(true);
            b.addActionListener(e -> presionar(b.getText().trim()));

            int ancho = (t.equals("Limpiar") || t.equals("Salir")) ? 2 : 1;
            if (columna + ancho > 5) {
                columna = 0;
                fila++;
            }
            gbc.gridx = columna;
            gbc.gridy = fila;
            gbc.gridwidth = ancho;
            teclado.add(b, gbc);
            columna += ancho;
        }

        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        panelPrincipal.add(teclado, BorderLayout.CENTER);
        panelPrincipal.setPreferredSize(new Dimension(400, 460));
        return panelPrincipal;
    }

    /**
     * Decide que hacer segun la tecla presionada.
     *
     * @param t el texto de la tecla presionada
     */
    private void presionar(String t) {
        if (t.matches("[0-9]")) {
            digito(t);
        } else if (t.equals(".")) {
            punto();
        } else if (t.equalsIgnoreCase("Limpiar")) {
            limpiar();
        } else if (t.equalsIgnoreCase("Salir")) {
            cerrar();
        } else if (t.equals("=")) {
            calcular();
            operador = "";
        } else if (t.equals("+") || t.equals("-") || t.equals("/") || t.equalsIgnoreCase("X")) {
            operacion(t);
        }
    }

    /**
     * Agrega un digito al numero que se esta escribiendo.
     * Si es un numero nuevo, o la pantalla muestra 0 o Error, lo reemplaza.
     *
     * @param d el digito presionado
     */
    private void digito(String d) {
        String actual = pantalla.getText();
        if (nuevoNumero || actual.equals("0") || actual.equals("Error")) {
            pantalla.setText(d);
        } else {
            pantalla.setText(actual + d);
        }
        nuevoNumero = false;
    }

    /**
     * El punto sirve para poder procesar numeros decimales a la hora de escribirlos.
     * Si empieza un numero nuevo escribe "0."; si el numero ya tiene punto, no hace nada.
     */
    private void punto() {
        String actual = pantalla.getText();
        if (nuevoNumero || actual.equals("Error")) {
            pantalla.setText("0.");
            nuevoNumero = false;
        } else if (!actual.contains(".")) {
            pantalla.setText(actual + ".");
        }
    }

    /**
     * Guarda la operacion elegida y el primer numero.
     * Si ya habia una operacion pendiente y se escribio el segundo numero, la calcula primero.
     * Despues de un error no se puede seguir operando con "Error".
     *
     * @param op la operacion elegida (+, -, /, X)
     */
    private void operacion(String op) {
        if (pantalla.getText().equals("Error")) {
            return;
        }
        if (!operador.isEmpty() && !nuevoNumero) {
            calcular();
            if (pantalla.getText().equals("Error")) {
                return;
            }
        }
        primero = pantalla.getText();
        operador = op;
        nuevoNumero = true;
    }

    /**
     * Usa la clase Aritmetica para hacer la operacion pendiente y muestra el resultado.
     * Si el resultado es un error, limpia la operacion pendiente para poder empezar de nuevo.
     */
    private void calcular() {
        if (operador.isEmpty()) {
            return;
        }
        String segundo = pantalla.getText();
        calc.setResultado(primero);
        switch (operador) {
            case "+": calc.sum(segundo); break;
            case "-": calc.resta(segundo); break;
            case "/": calc.division(segundo); break;
            default:  calc.multiplicacion(segundo); break; // la tecla X
        }
        pantalla.setText(formato(calc.getResultado()));
        nuevoNumero = true;
        if (calc.getResultado().equals("Error")) {
            primero = "";
            operador = "";
        }
    }

    /**
     * Quita el ".0" de los enteros y evita la notacion cientifica (1.0E-5).
     * Si el texto no es un numero (por ejemplo "Error"), lo devuelve tal cual.
     *
     * @param r el resultado en texto
     * @return el resultado listo para mostrarse en pantalla
     */
    private String formato(String r) {
        try {
            return new BigDecimal(r).stripTrailingZeros().toPlainString();
        } catch (NumberFormatException e) {
            return r;
        }
    }

    /**
     * Borra el acumulador y vuelve todo a cero.
     */
    private void limpiar() {
        calc.limpiar();
        pantalla.setText("limpiar");
        operador = "";
        nuevoNumero = true;
    }

    /**
     * Abre la calculadora aritmetica de forma independiente.
     *
     * @param args argumentos de la linea de comandos (no se usan)
     */
    public static void main(String[] args) {
        new VentanaCalculadoraAritmetrica().abrir();
    }
}
