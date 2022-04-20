package practico2.ejercicio4;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] miArreglo = new int[4];
        miArreglo[0] = 5;
        miArreglo[1] = 4;
        miArreglo[2] = 2;
        miArreglo[3] = 3;
        sortBySelection(miArreglo);
        System.out.println(Arrays.toString(miArreglo));
    }

    /**
     * @return Arreglo de enteros ordenado por seleccion.
     * @description El algoritmo por seleccion busca desde el primero el minimo y lo intercambia,
     * sigue por el segundo y asi sucesivamente hasta el anteultimo.
     * */
    private static void sortBySelection(int[] miArreglo) {
        for (int i = 0; i < miArreglo.length - 1; i++){
            int minimo = i;
            for (int j = i + 1; j < miArreglo.length; j++){
                if (miArreglo[j] < miArreglo[minimo]){
                    minimo = j;
                }
            }
            if (minimo != i) {
                int aux = miArreglo[i];
                miArreglo[i] = miArreglo[minimo];
                miArreglo[minimo] = aux;
            }
        }
    }

}
