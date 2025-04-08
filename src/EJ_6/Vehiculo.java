package EJ_6;

import java.util.Random;

public class Vehiculo implements Runnable {

    private Cochera cochera;
    int numero;

    public Vehiculo(Cochera cochera) {
        this.cochera = cochera;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((new Random()).nextInt(4)+1); // espera alaeatoria entre 1 y 5 segs
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }

            cochera.estacionar(this);

            try {
                Thread.sleep((new Random()).nextInt(4)+1); // espera alaeatoria entre 1 y 5 segs
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }

            cochera.retirar(this);
        }
    }

    public int getTamaño() {
        return this.numero;
    }
}
