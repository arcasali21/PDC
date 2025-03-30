package Ej_5_Filosofos_comensales;

public class Tenedor {
    private String nombre = null;
    private boolean usando = false;

    public Tenedor(String nombre) {
        this.nombre = nombre;
    }

    public synchronized boolean usando() {
        return usando;
    }

    public synchronized void usar() {
        this.usando = true;
    }

    public synchronized void liberar() {
        this.usando = false;
    }
}
