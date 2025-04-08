package EJ_6;

public class Auto extends Vehiculo {

    public Auto(Cochera cochera, int numero) {
        super(cochera, numero);
    }

    @Override
    public int getTamaño() {
        return 1;
    }

    @Override
    public String darIdVehiculo() {
        return "Auto " + this.numero;
    }
}
