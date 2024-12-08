package vista;

import modelo.*;
import java.util.Scanner;

public class VistaConsola {

    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarTablero(Tablero tablero) {
        Celda[][] celdas = tablero.obtenerCeldas();
        int tamanio = tablero.obtenerTamanio();

        System.out.print("  ");
        for (int i = 0; i < tamanio; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int fila = 0; fila < tamanio; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < tamanio; columna++) {
                Celda celda = celdas[fila][columna];
                if (celda.estaRevelada()) {
                    if (celda.tieneMina()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(celda.obtenerMinasAdyacentes() + " ");
                    }
                } else if (celda.estaMarcada()) {
                    System.out.print("F ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public String obtenerEntradaUsuario() {
        System.out.println("Introduce una coordenada (ejemplo: A5) o escribe 'marcar A5' para marcar:");
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
