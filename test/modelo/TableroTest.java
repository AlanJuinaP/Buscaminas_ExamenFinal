package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Tablero;
import modelo.Celda;

class TableroTest {
	
	private Tablero tablero;
	
	@BeforeEach
	public void setUp() {
		tablero = new Tablero();
	}
	
	@Test
	public void testInicializarTablero() {
		//Verificar que el tablero tiene 10 minas
		
		int minasEncontradas = 0;
		for(int i = 0; i < tablero.obtenerCeldas().length; i++) {
			for(int j = 0; j < tablero.obtenerCeldas()[i].length; j++) {
				if(tablero.obtenerCeldas()[i][j].tieneMina()) {
					minasEncontradas++;
				}
			}
		}
		assertEquals(10, minasEncontradas, "El numero de minas deberia ser 10");
	}
	
	@Test
	public void testContarMinasAdyacentes() {
		Celda celda = tablero.obtenerCeldas()[1][1];
		
		if(!celda.tieneMina()) {
			int minasAdyacentes = celda.obtenerMinasAdyacentes();
			assertTrue(minasAdyacentes >= 0 && minasAdyacentes <= 0, "El numero de minas adyacentes debe estar 0 y 8.");
		}
	}
}
