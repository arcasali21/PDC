package EJ_6;

public class Main {

    private static int CAPACIDAD_COCHERA = 5;
    private static int CANTIDAD_VEHICULOS = CAPACIDAD_COCHERA*2;

    public static void main(String[] args) {

        Cochera cochera = new Cochera(CAPACIDAD_COCHERA);

        Vehiculo[] vehiculos = new Vehiculo[CANTIDAD_VEHICULOS];

        for(int i = 0; i < CANTIDAD_VEHICULOS; i++) {
            if (Math.random() < 0.5)
                vehiculos[i] = new Auto(cochera, i);
            else
                vehiculos[i] = new Camion(cochera, i);

            (new Thread(vehiculos[i])).start();
        }
    }
}
