package controlador;
import java.util.Scanner;

import Modelo.Casilla;
import Modelo.Tablero;
import Vista.Vista_Consola;


public class Juego {
    private Tablero tablero;
    private Vista_Consola vista;
    private Scanner scanner;

    public Juego() {
        this.tablero = new Tablero(10);
        this.vista = new Vista_Consola();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            vista.mostrarTablero(tablero);
            System.out.println("Ingrese una coordenada (ej. A1 para descubrir, o A1M para marcar): ");
            String entrada = scanner.nextLine().trim().toUpperCase(); // Asegura mayúsculas

            // Verificar si la entrada tiene al menos 2 caracteres y es válida
            if (entrada.length() < 2 || !entrada.matches("[A-J][1-9][0-9]?([M]?)")) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                continue; // Solicitar entrada nuevamente si es inválida
            }

            char fila = entrada.charAt(0);
            int columna;
            try {
                columna = Integer.parseInt(entrada.substring(1, entrada.length() - (entrada.endsWith("M") ? 1 : 0))) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Coordenada inválida.");
                continue;
            }

            boolean marcar = entrada.endsWith("M");

            if (marcar) {
                tablero.obtenerCasilla(fila - 'A', columna).marcar();
            } else {
                Casilla casilla = tablero.obtenerCasilla(fila - 'A', columna);
                casilla.descubrir();
                if (casilla.tieneMina()) {
                    System.out.println("¡Perdiste! Has tocado una mina.");
                    juegoTerminado = true;
                }
            }
        }
    }
}
