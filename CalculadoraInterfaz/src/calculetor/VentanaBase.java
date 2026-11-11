package calculetor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Clase base para todas las ventanas del programa.
 * Contiene lo que se repite en cada una: crear el JFrame, mostrarlo y cerrarlo.
 * Cada ventana concreta solo dice como se arma su panel y cual es su titulo.
 */
public abstract class VentanaBase {

    private JFrame ventana;

    // Cada ventana arma su propio contenido
    protected abstract JPanel crearPanel();

    // Cada ventana define su titulo
    protected abstract String titulo();

    // Muestra la ventana; al cerrarla solo se cierra ella, el programa sigue
    public void abrir() {
        SwingUtilities.invokeLater(() -> {
            ventana = new JFrame(titulo());
            ventana.setContentPane(crearPanel());
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }

    // Cierra solo esta ventana
    protected void cerrar() {
        if (ventana != null) {
            ventana.dispose();
        }
    }
}
