package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Tablero;
import modelo.Celda;
import modelo.Juego;

class JuegoTest {
	private Juego juego;

    @BeforeEach
    public void testRevelarCeldaVacia() {
        // Suponemos que la casilla (2,2) no tiene mina
        Celda celda = juego.obtenerTablero().obtenerCeldas()[2][2];

        if (!celda.tieneMina()) {
            juego.revelarCelda(2, 2);  // Revelamos la casilla vacía
            assertTrue(celda.estaRevelada(), "La celda debería estar revelada.");
        }
    }

}
