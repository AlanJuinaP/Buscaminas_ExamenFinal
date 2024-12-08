import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private int filas = 10;
    private int columnas = 10;
    private int minas;

    public Tablero(int minas) {
        this.minas = minas;
        casillas = new Casilla[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna].colocarMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina()) {
                    int minasAlrededor = contarMinasAdyacentes(i, j);
                    casillas[i][j].setMinasAdyacentes(minasAlrededor);
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int minasAlrededor = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                    if (casillas[nuevaFila][nuevaColumna].tieneMina()) {
                        minasAlrededor++;
                    }
                }
            }
        }
        return minasAlrededor;
    }

    public Casilla obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public void revelarCasillasVacias(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) return;
        Casilla casilla = casillas[fila][columna];
        if (casilla.estaDescubierta() || casilla.estaMarcada()) return;

        casilla.descubrir();
        if (casilla.obtenerMinasAdyacentes() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        revelarCasillasVacias(fila + i, columna + j);
                    }
                }
            }
        }
    }

    public int obtenerFilas() {
        return filas;
    }

    public int obtenerColumnas() {
        return columnas;
    }
}
