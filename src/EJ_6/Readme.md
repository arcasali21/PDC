<h3><strong>Ejercicio 6 (entregar):</strong></h3>

Se desea modelizar una cochera que tiene N lugares disponibles. En la cochera pueden
guardarse autos y camiones. Cada auto ocupa un lugar en la cochera, cada camión ocupa
2 lugares. Cada vez que un vehículo sale de la cochera libera un espacio y los demás
vehículos son reacomodados para que ingresen la mayor cantidad de autos o camiones.
Implemente en Java las clases Cochera, Vehiculo, Auto, Camion, y una clase Test para
probar la aplicación creando vehículos en forma aleatoria. Responda las siguientes
preguntas:

<strong>a.- ¿Cuál es la sección crítica?</strong></br>
Está en la cochera, epecificamente en:

```java
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
```

<strong>b.- ¿Conviene utilizar subclases de Threads, clases internas como Threads o
implementar Runnable? ¿Cuáles son los hilos?</strong></br>

Conviene usar Runnable para poder implementar las dos interfases de Vehiculo (Auto y Camion). 
Con Thread no se podría hacer.<br>
Los hilos son todas las instancias de Camiones y Autos que se crean.

<strong>c.- ¿Cuál o cuáles mecanismos de sincronización puedo utilizar para resolver el
problema?</strong></br>
Utilizando el mecanismo <i>synchronized</i> en la sección crítica. 

<strong>d.- Realice una segunda versión que brinde prioridad de ingreso a los autos sobre los
camiones.</strong></br> 
```java
MainV2
```
