import java.awt.EventQueue;

/**
 * Clase principal
 * @author jesusredondogarcia
 * @author Marco Antnio Hern·ndez Valiente
 *
 */
public class Principal {

	/**
	 * MÈtodo main
	 * @param args : Cadenas de par√°metros del main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}