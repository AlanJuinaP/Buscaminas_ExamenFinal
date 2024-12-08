import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private boolean enJuego;

    public Juego(int minas) {
        this.tablero = new Tablero(minas);
        this.enJuego = true;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (enJuego) {
            mostrarTablero();
            System.out.println("Opciones: 1. Descubrir casilla  2. Marcar casilla");
            System.out.print("Elija una opción (1 o 2): ");
            int opcion = scanner.nextInt();
            System.out.print("Ingrese la fila (0-9): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna (0-9): ");
            int columna = scanner.nextInt();

            if (opcion == 1) {
                Casilla casillaSeleccionada = tablero.obtenerCasilla(fila, columna);
                if (casillaSeleccionada.tieneMina()) {
                    System.out.println("¡Has perdido! Se ha descubierto una mina.");
                    enJuego = false;
                } else {
                    tablero.revelarCasillasVacias(fila, columna);
                    if (verificarVictoria()) {
                        System.out.println("¡Felicidades! Has ganado.");
                        enJuego = false;
                    }
                }
            } else if (opcion == 2) {
                Casilla casillaSeleccionada = tablero.obtenerCasilla(fila, columna);
                if (!casillaSeleccionada.estaDescubierta()) {
                    casillaSeleccionada.marcar();
                }
            }
        }
        scanner.close();
    }

    private boolean verificarVictoria() {
        for (int i = 0; i < tablero.obtenerFilas(); i++) {
            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                Casilla casilla = tablero.obtenerCasilla(i, j);
                if (!casilla.tieneMina() && !casilla.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void mostrarTablero() {
        System.out.print("   ");
        for (int j = 0; j < tablero.obtenerColumnas(); j++) {
            System.out.print((j + 1) + " ");  // Mostrar números de las columnas
        }
        System.out.println();
    
        for (int i = 0; i < tablero.obtenerFilas(); i++) {
            // Imprimir la letra de la fila
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
