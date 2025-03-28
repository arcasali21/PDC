import java.text.SimpleDateFormat;
import java.util.Date;

public class Ej_1_HoraIntermitente_V1 extends Thread {

    @Override
    public void run() {
        while (true) {
            // Obtener la hora actual  
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(new Date());
            System.out.println("Hora actual: " + horaActual);

            // Hacer una pausa de 10 segundos  
            try {
                Thread.sleep(10000); // 10000 milisegundos = 10 segundos  
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Crear un hilo y ejecutarlo  
        Thread hiloHora = new Thread(new Ej_1_HoraIntermitente_V1());
        hiloHora.start();
    }
}  