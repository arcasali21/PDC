package EJ_6;

import java.util.ArrayList;


public class Cochera {

    private ArrayList<Vehiculo> vehiculos;
    private int capacidad;
    
    public Cochera(int capacidad) {
        this.capacidad = capacidad;
        this.vehiculos = new ArrayList<>();
    }
    
    public synchronized void estacionar(Vehiculo vehiculo) {
        System.out.println(" - Intentando estacionar vehiculo " + vehiculo.darIdVehiculo());
        if(this.capacidad - this.vehiculos.size() > vehiculo.getTamaño()){
            System.out.println("    + ESTACIONAMOS vehiculo " + vehiculo.darIdVehiculo());

            if(vehiculo.getTamaño() == 2)     //si es un Camion (que ocupa 2 lugares), guarda dos posiciones en el ArrayList, sino 1 sola
                this.vehiculos.add(vehiculo);
            this.vehiculos.add(vehiculo);
            this.imprimir_cochera();
        }else{
            System.out.println("    + NO HAY LUGAR - vehiculo " + vehiculo.darIdVehiculo() + " en ESPERA");
            try {
                wait();
                this.estacionar(vehiculo); //para que pruebe nuevamente estacionar
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public synchronized void retirar(Vehiculo vehiculo) {
        System.out.println(" - SE RETIRA el vehiculo " + vehiculo.darIdVehiculo());
        if(vehiculo.getTamaño() == 2)     //si es un Camion (que ocupa 2 lugares), guarda dos posiciones en el ArrayList, sino 1 sola
            this.vehiculos.remove(vehiculo);
        this.vehiculos.remove(vehiculo);
        this.imprimir_cochera();
        notifyAll();
    }

    private void imprimir_cochera() {
        /*for (int i = 0; i < this.capacidad; i++)
            System.out.print("|---------");
        System.out.println("|");*/
        for (int i = 0; i < this.capacidad; i++)
            System.out.print("|    "+i+"    ");
        System.out.println("|");
        for (int i = 0; i < this.capacidad; i++)
            System.out.print("|---------");
        System.out.println("|");
        for (int i = 0; i < this.capacidad; i++)
            if(i < this.vehiculos.size())
                System.out.print("| "+this.vehiculos.get(i).darIdVehiculo() + ((this.vehiculos.get(i).darIdVehiculo().length() < 8)? "  ":""));
            else
                System.out.print("|   ---   ");
        System.out.println("|");
        for (int i = 0; i < this.capacidad; i++)
            System.out.print("|---------");
        System.out.println("|");

    }
    
}
