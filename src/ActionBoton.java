import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author jesusredondogarcia
 * @author Marco Antnio Hernández Valiente
 */
public class ActionBoton implements ActionListener {
	private VentanaPrincipal ventanaPrincipal;
	private int ejeX;
	private int ejeY;

	public ActionBoton() {
	}

	public ActionBoton(VentanaPrincipal ventanaPrincipal, int ejeX, int ejeY) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ventanaPrincipal.mostrarNumMinasAlrededor(ejeX, ejeY);
		
		if (!ventanaPrincipal.getJuego().abrirCasilla(ejeX, ejeY)) {			
			ventanaPrincipal.mostrarFinJuego(true);
		} 
		
		if (ventanaPrincipal.getJuego().esFinJuego()) {			
			ventanaPrincipal.mostrarFinJuego(false);
		} 

		ventanaPrincipal.actualizarPuntuacion();
	}
}