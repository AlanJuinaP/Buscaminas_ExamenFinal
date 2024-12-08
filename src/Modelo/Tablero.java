package modelo;

import java.util.Random;

public class Tablero {
    private final int TAMANIO = 10;
    private final int MINAS = 10;
    private Celda[][] celdas;

    public Tablero() {
        celdas = new Celda[TAMANIO][TAMANIO];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                celdas[i][j] = new Celda();
            }
        }
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {
            int fila = rand.nextInt(TAMANIO);
            int columna = rand.nextInt(TAMANIO);
            if (!celdas[fila][columna].tieneMina()) {
                celdas[fila][columna].colocarMina(true);
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (!celdas[i][j].tieneMina()) {
                    celdas[i][j].establecerMinasAdyacentes(contarMinasAdyacentes(i, j));
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int conteo = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int f = fila + i;
                int c = columna + j;
                if (f >= 0 && f < TAMANIO && c >= 0 && c < TAMANIO && celdas[f][c].tieneMina()) {
                    conteo++;
                }
            }
        }
        return conteo;
    }

    public Celda[][] obtenerCeldas() {
        return celdas;
    }

    public int obtenerTamanio() {
        return TAMANIO;
    }
}
