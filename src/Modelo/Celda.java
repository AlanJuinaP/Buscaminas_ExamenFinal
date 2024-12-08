package modelo;

public class Celda {
    private boolean tieneMina;
    private boolean revelada;
    private boolean marcada;
    private int minasAdyacentes;

    public Celda() {
        this.tieneMina = false;
        this.revelada = false;
        this.marcada = false;
        this.minasAdyacentes = 0;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void colocarMina(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }

    public boolean estaRevelada() {
        return revelada;
    }

    public void revelar() {
        this.revelada = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void alternarMarcada() {
        this.marcada = !marcada;
    }

    public int obtenerMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void establecerMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}
