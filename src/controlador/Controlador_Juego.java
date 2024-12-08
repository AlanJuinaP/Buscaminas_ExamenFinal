package controlador;

public class Controlador_Juego {
    private Juego juego;

    public Controlador_Juego() {
        this.juego = new Juego();
    }

    public void ejecutarJuego() {
        juego.iniciarJuego();
    }
}
