package Ej_5_Filosofos_comensales;

import java.util.Random;

public class Main {

    private static final int NUM_FILOSOFOS = 5;
    private static final int TIEMPO_PESAMIENTO_MAX = 10000;
    private static final int TIEMPO_COMIENDO_MAX = 10000;

    public static void main(String[] args) {

        Tenedor[] tenedores = new Tenedor[NUM_FILOSOFOS];
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];

        for(int i = 0; i < NUM_FILOSOFOS; i++)
            tenedores[i] = new Tenedor("Tenedor " + i);

        for(int i = 0; i < NUM_FILOSOFOS; i++)
            filosofos[i] = new Filosofo("Filosofo " + i, (new Random()).nextInt(TIEMPO_PESAMIENTO_MAX)+1,(new Random()).nextInt(TIEMPO_COMIENDO_MAX)+1, tenedores[i], tenedores[(i+1)%NUM_FILOSOFOS]);

        for(int i = 0; i < NUM_FILOSOFOS; i++)
            filosofos[i].start();



    }
}
