package Ej_5_Filosofos_comensales;


public class Filosofo extends Thread {

    private String nombre = null;
    private Tenedor tenedor_derecha;
    private Tenedor tenedor_izquierda;
    private int tiempo_pensamiento = 0; //tiempo en ms en que el filosofo se la pasa pensando


    public Filosofo(String nombre, int tiempo_pensamiento, Tenedor tenedor_derecha, Tenedor tenedor_izquierda ) {
        this.nombre = nombre;
        this.tiempo_pensamiento = tiempo_pensamiento;
        this.tenedor_derecha = tenedor_derecha;
        this.tenedor_izquierda = tenedor_izquierda;
    }
    public void run() {

    }

}
