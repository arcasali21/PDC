package EJ_6;

public class MainV2 {

    private static int CAPACIDAD_COCHERA = 5;
    private static int CANTIDAD_VEHICULOS = CAPACIDAD_COCHERA*2;

    public static void main(String[] args) {

        Cochera cochera = new Cochera(CAPACIDAD_COCHERA);

        for(int i = 0; i < CANTIDAD_VEHICULOS; i++) {
            if (Math.random() < 0.5) {
                Thread auto = new Thread(new Auto(cochera, i));
                auto.setPriority(Thread.MAX_PRIORITY);
                auto.start();
            }else {
                Thread camion = new Thread(new Camion(cochera, i));
                camion.setPriority(Thread.MIN_PRIORITY);
                camion.start();
            }
        }
    }
}
