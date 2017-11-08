import java.awt.EventQueue;

/**
 * Clase principal
 * @author jesusredondogarcia
 * @author Marco Antnio Hern�ndez Valiente
 *
 */
public class Principal {

	/**
	 * M�todo main
	 * @param args : Cadenas de parámetros del main
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