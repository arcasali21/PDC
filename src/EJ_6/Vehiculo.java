package EJ_6;


public abstract class Vehiculo implements Runnable {

    private Cochera cochera;
    int numero;

    public Vehiculo(Cochera cochera, int numero) {
        this.cochera = cochera;
        this.numero = numero;
    }

    @Override
    public void run() {
        //while (true) {
            try {
                Thread.sleep((long) (Math.random()*4000 + 1000)); // espera alaeatoria entre 1 y 5 segs
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }

            cochera.estacionar(this);

            try {
                Thread.sleep((long) (Math.random()*4000 + 1000)); // espera alaeatoria entre 1 y 5 segs
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }

            cochera.retirar(this);
        //}
    }

    public abstract String darIdVehiculo();

    public abstract int getTamaño();

}
