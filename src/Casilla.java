public class Casilla {
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada;
    private int minasAdyacentes;

    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAdyacentes = 0;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void colocarMina() {
        this.tieneMina = true;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        this.descubierta = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void marcar() {
        this.marcada = true;
    }

    public void desmarcar() {
        this.marcada = false;
    }

    public int obtenerMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minas) {
        this.minasAdyacentes = minas;
    }
}
