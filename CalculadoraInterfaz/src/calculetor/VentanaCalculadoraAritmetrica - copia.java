/**Fuera de servisio
 * package calculetor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Calculadora grafica construida por codigo (sin archivo .form), para que
 * funcione igual en NetBeans y en IntelliJ.
 * Los botones se identifican por su texto.
 
public class VentanaCalculadoraAritmetrica {

    // Disposicion del teclado, fila por fila (4 filas x 4 columnas)
    private static final String[] TECLAS = {
        "1", "2", "3", "+",
        "4", "5", "6", "-",
        "7", "8", "9", "X",
        "0", "Salir", "=", "/"
    };

    // Componentes
    private final JPanel panelPrincipal = new JPanel(new BorderLayout());
    private final JTextField pantalla = new JTextField("0");
    private final JPanel teclado = new JPanel(new GridLayout(4, 4));
    private JFrame ventana;

    // Atributos de la logica
    private final Aritmetica calc = new Aritmetica();
    private String primero = "";
    private String operador = "";
    private boolean nuevoNumero = true;

    // Constructor
    public VentanaCalculadoraAritmetrica() {
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setFont(new Font("SansSerif", Font.BOLD, 30));
        pantalla.setPreferredSize(new Dimension(300, 60));

        for (String t : TECLAS) {
            JButton b = new JButton(t);
            b.setFont(new Font("SansSerif", Font.PLAIN, 22));
            b.addActionListener(e -> presionar(b.getText().trim()));
            teclado.add(b);
        }

        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        panelPrincipal.add(teclado, BorderLayout.CENTER);
        panelPrincipal.setPreferredSize(new Dimension(400, 460));
    }

    /**
     * Abre la calculadora desde el menu de consola: al cerrarla solo se
     * cierra la ventana, el programa sigue.
     
    public static void abrir() {
        mostrar(JFrame.DISPOSE_ON_CLOSE);
    }

    private static void mostrar(int accionCerrar) {
        SwingUtilities.invokeLater(() -> {
            VentanaCalculadoraAritmetrica v = new VentanaCalculadoraAritmetrica();
            v.ventana = new JFrame("Calculadora");
            v.ventana.setContentPane(v.panelPrincipal);
            v.ventana.setDefaultCloseOperation(accionCerrar);
            v.ventana.pack();
            v.ventana.setLocationRelativeTo(null);
            v.ventana.setVisible(true);
        });
    }

    // Decide que hacer segun la tecla
    private void presionar(String t) {
        if (t.matches("[0-9]")) {
            digito(t);
        } else if (t.equalsIgnoreCase("Salir")) {
            if (ventana != null) {
                ventana.dispose();
            }
        } else if (t.equals("=")) {
            calcular();
            operador = "";
        } else if (t.equals("+") || t.equals("-") || t.equals("/") || t.equalsIgnoreCase("X")) {
            operacion(t);
        }
    }

    private void digito(String d) {
        String actual = pantalla.getText();
        if (nuevoNumero || actual.equals("0") || actual.equals("Error")) {
            pantalla.setText(d);
        } else {
            pantalla.setText(actual + d);
        }
        nuevoNumero = false;
    }

    private void operacion(String op) {
        // Despues de un error no se puede seguir operando con "Error"
        if (pantalla.getText().equals("Error")) {
            return;
        }
        // Si ya habia una operacion pendiente y se escribio el segundo numero, se calcula primero
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

    // Usa la clase Aritmetica para hacer la operacion
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
            // se limpia la operacion pendiente para poder empezar de nuevo
            primero = "";
            operador = "";
        }
    }

    // Quita el ".0" de los enteros y evita la notacion cientifica (1.0E-5)
    private String formato(String r) {
        try {
            return new BigDecimal(r).stripTrailingZeros().toPlainString();
        } catch (NumberFormatException e) {
            // "Error" u otro texto: se muestra tal cual
            return r;
        }
    }

    public static void main(String[] args) {
        mostrar(JFrame.EXIT_ON_CLOSE);
    }
}
