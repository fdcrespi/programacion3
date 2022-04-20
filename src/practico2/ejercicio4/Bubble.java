package practico2.ejercicio4;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] miArreglo = new int[7];
        miArreglo[0] = 5;
        miArreglo[1] = 3;
        miArreglo[2] = 2;
        miArreglo[3] = 4;
        miArreglo[4] = 8;
        miArreglo[5] = 6;
        miArreglo[6] = 7;
        sortByBubble(miArreglo);
        System.out.println(Arrays.toString(miArreglo));
    }

    /**
     * El algoritmo por burbujeo consiste en intercambiar un valor
     * por el siguiente si este es mayor, lo hace varias veces hasta que no haya
     * mas intercambios
     * */
    private static void sortByBubble(int[] miArreglo) {
        int i = 0;
        int tmp;
        boolean ordenado = false;
        while (!ordenado){
            ordenado = true;
            i++;
            for (int j = 0; j < miArreglo.length - i; j++) {
                if (miArreglo[j] > miArreglo[j + 1]) {
                    ordenado = false;
                    tmp = miArreglo[j + 1];
                    miArreglo[j + 1] = miArreglo[j];
                    miArreglo[j] = tmp;
                }
            }
        }
    }

}
