package controlador;

import modelo.*;
import vista.VistaConsola;

public class ControladorJuego {

    private final Juego juego;
    private final VistaConsola vista;

    public ControladorJuego() {
        this.juego = new Juego();
        this.vista = new VistaConsola();
    }

    public void iniciarJuego() {
        while (!juego.estaJuegoTerminado()) {
            vista.mostrarTablero(juego.obtenerTablero());
            String entrada = vista.obtenerEntradaUsuario();

            try {
                procesarEntrada(entrada);
                if (juego.estaJuegoTerminado()) {
                    vista.mostrarMensaje("¡Perdiste! Descubriste una mina.");
                    break;
                }
                if (verificarVictoria()) {
                    vista.mostrarMensaje("¡Felicidades! Has descubierto todas las celdas sin minas.");
                    break;
                }
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Entrada inválida: " + e.getMessage());
            }
        }
        vista.mostrarTablero(juego.obtenerTablero());
    }

    private void procesarEntrada(String entrada) {
        entrada = entrada.toUpperCase();
        boolean marcar = entrada.startsWith("MARCAR");
        String coordenadas = marcar ? entrada.split(" ")[1] : entrada;

        if (coordenadas.length() != 2) {
            throw new IllegalArgumentException("Formato de coordenadas incorrecto. Usa algo como 'A5'.");
        }

        char columnaChar = coordenadas.charAt(0);
        int fila = Character.getNumericValue(coordenadas.charAt(1)) - 1;
        int columna = columnaChar - 'A';

        if (fila < 0 || fila >= juego.obtenerTablero().obtenerTamanio() || columna < 0 || columna >= juego.obtenerTablero().obtenerTamanio()) {
            throw new IllegalArgumentException("Coordenadas fuera del tablero.");
        }

        if (marcar) {
            juego.obtenerTablero().obtenerCeldas()[fila][columna].alternarMarcada();
        } else {
            juego.revelarCelda(fila, columna);
        }
    }

    private boolean verificarVictoria() {
        Tablero tablero = juego.obtenerTablero();
        int tamanio = tablero.obtenerTamanio();
        Celda[][] celdas = tablero.obtenerCeldas();

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Celda celda = celdas[i][j];
                if (!celda.estaRevelada() && !celda.tieneMina()) {
                    return false;
                }
            }
        }
        return true;
    }
}
