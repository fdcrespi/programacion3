package practico2.ejercicio2;

import java.lang.reflect.Array;

public class MainB {
    public static void main(String[] args) {
        int[] miArreglo = new int[4];
        miArreglo[0] = 1;
        miArreglo[1] = 2;
        miArreglo[2] = 3;
        miArreglo[3] = 4;
        int pos = searchInArray(miArreglo, 5, 0);
        System.out.println(pos);
    }

    private static int searchInArray(int[] miArreglo, int valorBuscado, int inicio) {
        if (inicio < miArreglo.length){
            if(valorBuscado != miArreglo[inicio]){
                return searchInArray(miArreglo, valorBuscado, inicio+1);
            } else {
                return inicio;
            }
        } else return -1;
    }

}
