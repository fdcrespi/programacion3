package practico2.ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Por favor ingrese el tamanio del arreglo: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tamanio = Integer.parseInt(reader.readLine());
        int[] arreglo = crearArreglo(tamanio);
        System.out.println(Arrays.toString(arreglo));
        Arrays.sort(arreglo); /*Utiliza un quicksort con doble pivot*/
        System.out.println(Arrays.toString(arreglo));
    }
    private static int[] crearArreglo(int tamanio) {
        int[] miArreglo = new int[tamanio];
        for (int i = 0; i < miArreglo.length; i++) {
            miArreglo[i] = (int) Math.floor(Math.random()*100+1);
        }
        return miArreglo;
    }
}
