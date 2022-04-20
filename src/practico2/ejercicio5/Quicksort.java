package practico2.ejercicio5;

import java.util.Arrays;

public class Quicksort {

    private int[] numbers;

    public Quicksort(int[] arreglo){
        this.numbers = arreglo;
        quicksort(this.numbers, 0, numbers.length - 1);
    }

    public void quicksort(int[] arreglo, int first, int last) {
        /*definimos los índices y calculamos el pivote*/
        int i = first;
        int j = last;
        int pivote = (arreglo[i] + arreglo[j]) / 2;

        /*iteramos hasta que i no sea menor que j*/
        while (i < j) {
            /*iteramos mientras que el valor de L[i] sea menor que pivote*/
            while (arreglo[i] < pivote) {
                /*Incrementamos el índice*/
                i += 1;
            }
            /*iteramos mientras que el valor de L[j] sea mayor que pivote*/
            while (arreglo[j] > pivote) {
                /*decrementamos el índice*/
                j -= 1;
            }
            /*si i es menor o igual que j significa que los índices se han cruzado*/
            if (i <= j) {
                /*creamos una variable temporal para guardar el valor de L[ j]*/
                int tmp = arreglo[j];
                /*intercambiamos los valores de L[j] y L[ i]*/
                arreglo[j] = arreglo[i];
                arreglo[i] = tmp;
                /*incrementamos y decrementamos i y j respectivamente*/
                i += 1;
                j -= 1;
            }
        }
        /*si first es menor que j mantenemos la recursividad*/
        if (first < j) {
            quicksort(arreglo, first, j);
        }
        /*si last es mayor que i mantenemos la recursividad*/
        if (last > i) {
            quicksort(arreglo, i, last);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers);
    }
}
