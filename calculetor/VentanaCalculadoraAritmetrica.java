package calculetor;

import java.awt.Font;
import javax.swing.*;

/**
 * Calculadora grafica ligada al .form del diseñador.
 * Los botones se identifican por su texto, no por el nombre del campo.
 */
public class VentanaCalculadoraAritmetrica {

    // Componentes del diseñador (mismos nombres que en el .form)
    private JPanel PanelPrincipal;
    private JTextField PantallaAritetrica;
    private JPanel TecladoAritmetrica;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton button7;
    private JButton button8;
    private JButton a0Button;
    private JButton salirButton;
    private JButton button11;
    private JButton button12;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton xButton;

    // Atributos de la logica
    private final Aritmetica calc = new Aritmetica();
    private String primero = "";
    private String operador = "";
    private boolean nuevoNumero = true;

    // Constructor
    public VentanaCalculadoraAritmetrica() {
        // Ajustes de la pantalla
        PantallaAritetrica.setText("0");
        PantallaAritetrica.setEditable(false);
        PantallaAritetrica.setHorizontalAlignment(SwingConstants.RIGHT);
        PantallaAritetrica.setFont(new Font("SansSerif", Font.BOLD, 30));

        // Los 16 botones; cada uno actua segun el texto que tiene
        JButton[] botones = {
                a0Button, a1Button, a2Button, a3Button, a4Button, a5Button,
                a6Button, a7Button, a8Button, a9Button,
                button7, button8, button11, button12,
                xButton, salirButton
        };
        for (JButton b : botones) {
            b.setFont(new Font("SansSerif", Font.PLAIN, 22));
            b.addActionListener(e -> presionar(b.getText().trim()));
        }
    }
public static void abrir() {
    SwingUtilities.invokeLater(() -> {
        JFrame ventana = new JFrame("Calculadora");
        ventana.setContentPane(new VentanaCalculadoraAritmetrica().PanelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    });
}

    // Decide que hacer segun la tecla
    private void presionar(String t) {
        if (t.matches("[0-9]")) {
            digito(t);
        } else if (t.equalsIgnoreCase("Salir")) {
            System.exit(0);
        } else if (t.equals("=")) {
            calcular();
            operador = "";
        } else if (t.equals("+") || t.equals("-") || t.equals("/") || t.equalsIgnoreCase("X")) {
            operacion(t);
        }
    }

    private void digito(String d) {
        String actual = PantallaAritetrica.getText();
        if (nuevoNumero || actual.equals("0") || actual.equals("Error")) {
            PantallaAritetrica.setText(d);
        } else {
            PantallaAritetrica.setText(actual + d);
        }
        nuevoNumero = false;
    }

    private void operacion(String op) {
        // Si ya habia una operacion pendiente y se escribio el segundo numero, se calcula primero
        if (!operador.isEmpty() && !nuevoNumero) {
            calcular();
        }
        primero = PantallaAritetrica.getText();
        operador = op;
        nuevoNumero = true;
    }

    // Usa la clase Aritmetica para hacer la operacion
    private void calcular() {
        if (operador.isEmpty()) {
            return;
        }
        String segundo = PantallaAritetrica.getText();
        calc.setResultado(primero);
        switch (operador) {
            case "+": calc.sum(segundo); break;
            case "-": calc.resta(segundo); break;
            case "/": calc.division(segundo); break;
            default:  calc.multiplicacion(segundo); break; // la tecla X
        }
        PantallaAritetrica.setText(formato(calc.getResultado()));
        nuevoNumero = true;
    }

    // Quita el ".0" cuando el resultado es entero (15.0 se ve como 15)
    private String formato(String r) {
        try {
            double d = Double.parseDouble(r);
            if (d == Math.rint(d) && Math.abs(d) < 1e15) {
                return String.valueOf((long) d);
            }
        } catch (NumberFormatException e) {
            // "Error" u otro texto: se muestra tal cual
        }
        return r;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Calculadora");
            ventana.setContentPane(new VentanaCalculadoraAritmetrica().PanelPrincipal);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
