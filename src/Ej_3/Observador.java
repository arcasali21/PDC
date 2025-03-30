package Ej_3;

public class Observador extends Thread {

    private DosContadores dosContadores;

    public Observador(DosContadores dosCont) {
        dosContadores = dosCont;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }
            dosContadores.testSincro();
        }
    }

}
