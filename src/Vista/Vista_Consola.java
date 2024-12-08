package Vista;

import Modelo.Tablero;
import Modelo.Casilla;

public class Vista_Consola {
    public void mostrarTablero(Tablero tablero) {
        System.out.print("   ");
        for (int j = 0; j < tablero.obtenerColumnas(); j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.obtenerFilas(); i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                Casilla casilla = tablero.obtenerCasilla(i, j);
                if (casilla.estaDescubierta()) {
                    if (casilla.tieneMina()) {
                        System.out.print("X ");
                    } else {
                        System.out.print(casilla.obtenerMinasAdyacentes() + " ");
                    }
                } else if (casilla.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
