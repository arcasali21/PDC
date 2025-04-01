package Ej_5_Filosofos_comensales;


public class Filosofo extends Thread {

    private String nombre = null;
    private Tenedor tenedor_derecha;
    private Tenedor tenedor_izquierda;
    private int tiempo_pensamiento = 0; //tiempo en ms en que el filosofo se la pasa pensando
    private int tiempo_comiendo = 0; //tiempo en ms en que el filosofo se la pasa pensando


    public Filosofo(String nombre, int tiempo_pensamiento, int tiempo_comiendo, Tenedor tenedor_derecha, Tenedor tenedor_izquierda ) {
        this.nombre = nombre;
        this.tiempo_pensamiento = tiempo_pensamiento;
        this.tiempo_comiendo = tiempo_comiendo;
        this.tenedor_derecha = tenedor_derecha;
        this.tenedor_izquierda = tenedor_izquierda;
    }

    public void run() {
        while(true) {
            //System.out.println(this.nombre + " - Intenta comer ");
            if(intentar_comer()){
                System.out.println(this.nombre + " - COMIENDO ");
                try {
                    sleep(tiempo_comiendo);
                } catch (InterruptedException e) {
                    System.err.println("El hilo fue interrumpido: " + e.getMessage());
                }
                tenedor_derecha.liberar();
                tenedor_izquierda.liberar();
                //System.out.println(this.nombre + " - termino de comer ");
                this.pensando(" - termino de comer ");
            }else {
                //System.out.println(this.nombre + " - No tiene tenedores");
                this.pensando(" - No tiene tenedores");
            }

        }
    }

    private void pensando(String razon) {
        System.out.println(this.nombre + " - PENSANDO" + razon);
        try {
            wait(tiempo_pensamiento);
        } catch (InterruptedException e) {
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
        }
    }

    public synchronized boolean intentar_comer() {
        if(!tenedor_derecha.usando() && !tenedor_izquierda.usando()) {
            tenedor_derecha.usar();
            tenedor_izquierda.usar();
            return true;
        }else
            return false;
    }

}
