package practico2.ejercicio5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] miArreglo = new int[7];
        miArreglo[0] = 5;
        miArreglo[1] = 3;
        miArreglo[2] = 2;
        miArreglo[3] = 4;
        miArreglo[4] = 8;
        miArreglo[5] = 6;
        miArreglo[6] = 7;
        System.out.println("Arreglo original: " + Arrays.toString(miArreglo));
        Mergesort ms = new Mergesort(miArreglo);
        System.out.println("Arreglo ordenado con mergesort: " + ms);
        Quicksort qs = new Quicksort(miArreglo);
        System.out.println("Arreglo ordenado con quicksort: " + qs);
    }
}
