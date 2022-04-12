package practico2.ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arreglo = new ArrayList<>();
        arreglo.add(2);
        arreglo.add(3);
        arreglo.add(4);
        arreglo.add(5);
        System.out.println(arreglo);
        boolean inOrder = isArrayOrder(arreglo, 0);
        System.out.println(inOrder);
    }

    private static boolean isArrayOrder(ArrayList<Integer> arreglo, int pos) {
        if (pos < arreglo.size()-1){
            if (arreglo.get(pos) < arreglo.get(pos+1)){
                return isArrayOrder(arreglo, pos+1);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
