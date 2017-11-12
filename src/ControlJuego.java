import java.util.Random;

/**
 * Clase gestora del tablero de juego. Guarda una matriz de enteros representado
 * el tablero. Si hay una mina en una posici√≥n guarda el n√∫mero -1 Si no hay
 * una mina, se guarda cu√°ntas minas hay alrededor. Almacena la puntuaci√≥n de
 * la partida
 * 
 * @author jesusredondogarcia
 * @author Marco Antonio Hern·ndez Valiente
 */
public class ControlJuego {
	private final static int MINA = -1;
	final int MINAS_INICIALES = 20;
	final int LADO_TABLERO = 10;

	private int[][] tablero;
	private int puntuacion;

	public ControlJuego() {
		// Creamos el tablero:
		tablero = new int[LADO_TABLERO][LADO_TABLERO];

		// Inicializamos una nueva partida
		inicializarPartida();
	}

	/**
	 * MÈtodo para generar un nuevo tablero de partida:
	 * 
	 * @pre: La estructura tablero debe existir.
	 * @post: Al final el tablero se habr·° inicializado con tantas minas como
	 *        marque la variable MINAS_INICIALES. El resto de posiciones que no son
	 *        minas guardan en el entero cu·ntas minas hay alrededor de la celda
	 */
	public void inicializarPartida() {
		int x, y;
		Random random = new Random();

		for (int minaGenerada = 1; minaGenerada <= MINAS_INICIALES; minaGenerada++) {
			x = random.nextInt(LADO_TABLERO);
			y = random.nextInt(LADO_TABLERO);

			if (tablero[x][y] != MINA) {
				tablero[x][y] = MINA;
			} else {
				minaGenerada--;
			}
		}

		for (int ejeX = 0; ejeX < tablero.length; ejeX++) {
			for (int ejeY = 0; ejeY < tablero[ejeX].length; ejeY++) {
				if (tablero[ejeX][ejeY] == MINA) {
					calculoMinasAdjuntas(ejeX, ejeY);
				}
			}
		}

		// depurarTablero();
	}

	/**
	 * C·lculo de las minas adjuntas: Para calcular el n˙mero de minas tenemos que
	 * tener en cuenta que no nos salimos nunca del tablero. Por lo tanto, como
	 * mucho la i y la j valdr·n LADO_TABLERO-1. Por lo tanto, como mucho la i y la
	 * j valdr·n como poco 0.
	 * 
	 * @param i:
	 *            posiciÛn verticalmente de la casilla a rellenar
	 * @param j:
	 *            posiciÛn horizontalmente de la casilla a rellenar
	 * @return : El n˙mero de minas que hay alrededor de la casilla [i][j]
	 **/
	private int calculoMinasAdjuntas(int i, int j) {
		int ejeX = i, ejeY = j;

		if (ejeX == 0 && ejeY == 0) {
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY + 1] != MINA) {
				tablero[ejeX + 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
		} else if (ejeX == 9 && ejeY == 0) {
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY + 1] != MINA) {
				tablero[ejeX - 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
		} else if (ejeX == 9 && ejeY == 9) {
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY - 1] != MINA) {
				tablero[ejeX - 1][ejeY - 1] += 1;
			}
		} else if (ejeX == 0 && ejeY == 9) {
			if (tablero[ejeX][ejeY - 1] != MINA) {
				tablero[ejeX][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY - 1] != MINA) {
				tablero[ejeX + 1][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
		} else if (ejeY == 0 && ejeX > 0 && ejeX < 9) {
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
			if (tablero[ejeX + 1][ejeY + 1] != MINA) {
				tablero[ejeX + 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY + 1] != MINA) {
				tablero[ejeX - 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
		} else if (ejeX == 9 && ejeY > 0 && ejeY < 9) {
			if (tablero[ejeX][ejeY - 1] != MINA) {
				tablero[ejeX][ejeY - 1] += 1;
			}
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY + 1] != MINA) {
				tablero[ejeX - 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY - 1] != MINA) {
				tablero[ejeX - 1][ejeY - 1] += 1;
			}
		} else if (ejeY == 9 && ejeX > 0 && ejeX < 9) {
			if (tablero[ejeX][ejeY - 1] != MINA) {
				tablero[ejeX][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY - 1] != MINA) {
				tablero[ejeX + 1][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY - 1] != MINA) {
				tablero[ejeX - 1][ejeY - 1] += 1;
			}
		} else if (ejeX == 0 && ejeY > 0 && ejeY < 9) {
			if (tablero[ejeX][ejeY - 1] != MINA) {
				tablero[ejeX][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY - 1] != MINA) {
				tablero[ejeX + 1][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
			if (tablero[ejeX + 1][ejeY + 1] != MINA) {
				tablero[ejeX + 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
		} else {
			if (tablero[ejeX][ejeY - 1] != MINA) {
				tablero[ejeX][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY - 1] != MINA) {
				tablero[ejeX + 1][ejeY - 1] += 1;
			}
			if (tablero[ejeX + 1][ejeY] != MINA) {
				tablero[ejeX + 1][ejeY] += 1;
			}
			if (tablero[ejeX + 1][ejeY + 1] != MINA) {
				tablero[ejeX + 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX][ejeY + 1] != MINA) {
				tablero[ejeX][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY + 1] != MINA) {
				tablero[ejeX - 1][ejeY + 1] += 1;
			}
			if (tablero[ejeX - 1][ejeY] != MINA) {
				tablero[ejeX - 1][ejeY] += 1;
			}
			if (tablero[ejeX - 1][ejeY - 1] != MINA) {
				tablero[ejeX - 1][ejeY - 1] += 1;
			}
		}
		return tablero[ejeX][ejeY];
	}

	/**
	 * MÈtodo que nos permite
	 * 
	 * @pre : La casilla nunca debe haber sido abierta antes, no es controlado por
	 *      el GestorJuego. Por lo tanto siempre sumaremos puntos
	 * @param i:
	 *            posiciÛn verticalmente de la casilla a abrir
	 * @param j:
	 *            posiciÛn horizontalmente de la casilla a abrir
	 * @return : Verdadero si no ha explotado una mina. Falso en caso contrario.
	 */
	public boolean abrirCasilla(int i, int j) {
		int ejeX = i, ejeY = j;
		
		if (tablero[ejeX][ejeY] != MINA) {
			puntuacion++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * MÈtodo que checkea si se ha terminado el juego porque se han abierto todas
	 * las casillas.
	 * 
	 * @return Devuelve verdadero si se han abierto todas las celdas que no son
	 *         minas.
	 **/
	public boolean esFinJuego() {
		if (puntuacion == Math.pow(LADO_TABLERO, 2) - MINAS_INICIALES) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * MÈtodo que pinta por pantalla toda la informaciÛn del tablero, se utiliza
	 * para depurar
	 */
	public void depurarTablero() {
		System.out.println("---------TABLERO--------------");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\nPuntuaciÛn: " + puntuacion);
	}

	/**
	 * MÈtodo que se utiliza para obtener las minas que hay alrededor de una celda
	 * 
	 * @pre : El tablero tiene que estar ya inicializado, por lo tanto no hace falta
	 *      calcularlo, sÌmplemente consultarlo
	 * @param i
	 *            : posiciÛn vertical de la celda.
	 * @param j
	 *            : posiciÛn horizontal de la cela.
	 * @return Un entero que representa el n˙mero de minas alrededor de la celda
	 */
	public int getMinasAlrededor(int i, int j) {
		int ejeX = i, ejeY = j;
		return tablero[ejeX][ejeY];
	}

	/**
	 * MÈtodo que devuelve la puntuaciÛn actual
	 * 
	 * @return Un entero con la puntuaciÛn actual
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
}