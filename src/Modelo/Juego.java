package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Juego {
    private Tablero tablero;
    private boolean juegoTerminado;

    public Juego() {
        tablero = new Tablero();
        juegoTerminado = false;
    }

    public void revelarCelda(int fila, int columna) {
        if (tablero.obtenerCeldas()[fila][columna].tieneMina()) {
            juegoTerminado = true;
        } else {
            revelarRecursivamente(fila, columna);
        }
    }

    private void revelarRecursivamente(int fila, int columna) {
        if (fila < 0 || fila >= tablero.obtenerTamanio() || columna < 0 || columna >= tablero.obtenerTamanio()) {
            return;
        }
        Celda celda = tablero.obtenerCeldas()[fila][columna];
        if (celda.estaRevelada() || celda.tieneMina()) {
            return;
        }
        celda.revelar();
        if (celda.obtenerMinasAdyacentes() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revelarRecursivamente(fila + i, columna + j);
                }
            }
        }
    }

    public boolean estaJuegoTerminado() {
        return juegoTerminado;
    }

    public Tablero obtenerTablero() {
        return tablero;
    }

     public void guardarJuego(String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Celda[][] celdas = tablero.obtenerCeldas();
            int tamanio = tablero.obtenerTamanio();
            for (int fila = 0; fila < tamanio; fila++) {
                for (int columna = 0; columna < tamanio; columna++) {
                    Celda celda = celdas[fila][columna];
                    writer.write((celda.tieneMina() ? "M" : "0") + "," + 
                                 (celda.estaRevelada() ? "R" : "N") + "," +
                                 (celda.estaMarcada() ? "F" : "N") + "," +
                                 celda.obtenerMinasAdyacentes());
                    if (columna < tamanio - 1) writer.write(";");
                }
                writer.newLine();
            }
        }
    }
// Método para cargar el estado del juego desde un archivo
    public void cargarJuego(String nombreArchivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            Celda[][] celdas = tablero.obtenerCeldas();
            int fila = 0;
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] columnas = linea.split(";");
                for (int columna = 0; columna < columnas.length; columna++) {
                    String[] valores = columnas[columna].split(",");
                    Celda celda = celdas[fila][columna];
                    celda.colocarMina(valores[0].equals("M"));
                    celda.revelar();
                    if (valores[1].equals("R")) celda.revelar();
                    if (valores[2].equals("F")) celda.alternarMarcada();
                    celda.establecerMinasAdyacentes(Integer.parseInt(valores[3]));
                }
                fila++;
            }
        }
    }
}
