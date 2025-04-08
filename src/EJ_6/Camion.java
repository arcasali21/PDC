package EJ_6;

public class Camion extends Vehiculo {

    public Camion(Cochera cochera, int numero) {
        super(cochera, numero);
    }

    @Override
    public int getTamaño() {
        return 2;
    }

    @Override
    public String darIdVehiculo() {
        return "Camión " + this.numero;
    }
}
